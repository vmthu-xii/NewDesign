import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

import model.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int port = 6789;
		try {
            Server.server = new ServerSocket(port);
            Server.client = Server.server.accept();
            Server.in = new BufferedReader(new InputStreamReader(Server.client.getInputStream()));
            Server.out = new BufferedWriter(new OutputStreamWriter(Server.client.getOutputStream()));
        } catch (Exception e){
        } 
		
		boolean isRunning = true;
		while (isRunning)
        {
			String msg = null;
			try {
				msg = Server.in.readLine();
				
				System.out.println("[server] receive: " + msg); // msg from client
				
				if(msg.equals("START_APP") || msg.equals("START_PROCESS")) Start();
				else if(msg.equals("STOP_APP") || msg.equals("STOP_PROCESS")) Stop();
				else if(msg.equals("LIST_APP")) List("APP");
				else if(msg.equals("LIST_PROCESS")) List("PROCESS");
				else isRunning = false;
				
			} catch(Exception e1) {
				isRunning = false;
			}
        }
		
		try {
			Server.server.close();
			Server.client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// START ======================================================================================
	private static void Start() {
		String nameApp = null;
		try {
			nameApp = Server.in.readLine();
			try {
				Runtime.getRuntime().exec("powershell -command \"Start-Process " + nameApp);
				Server.out.write("Start " + nameApp);
				Server.out.newLine();
				Server.out.flush();
			} catch (Exception e) {
				e.printStackTrace();	
			}
		} catch(Exception e) {
		}
	}
	
	// STOP =======================================================================================
	private static void Stop() {
		String msg = null;
		try {
			msg = Server.in.readLine();
			
			try {
				long pid = Integer.parseInt(msg.toString());		
				Runtime.getRuntime().exec("powershell -command \"Stop-Process -ID " + pid + " -Force");
			} catch (Exception e) {
				Runtime.getRuntime().exec("powershell -command \"Stop-Process -name " + msg + " -Force");
			}
			
			Server.out.write("Stopped successfully!");
			Server.out.newLine();
			Server.out.flush();
			
		} catch(Exception e) {
		}
	}
	
	// LIST =======================================================================================
	private static void List(String type) throws IOException, InterruptedException {
		Process process;
		
		if (type == "APP") 
			process = new ProcessBuilder("powershell","\"gps| ? {$_.mainwindowtitle.length -ne 0} | Format-Table -HideTableHeaders  name, ID, {$_.Threads.Count}").start(); 
		else 
			process = new ProcessBuilder("powershell","\"gps| Format-Table -HideTableHeaders  name, ID, {$_.Threads.Count}").start(); 


		new Thread(() -> {
			Scanner sc = new Scanner(process.getInputStream());
			if (sc.hasNextLine()) sc.nextLine();
			while (sc.hasNextLine()) {
			    String info = sc.nextLine();
			    
			    if(info.length() == 0) continue;
			    	                
			    int pFirstSpace = info.indexOf(" ");
				int pLastSpace = info.lastIndexOf(" ") + 1;
				
				String name = info.substring(0, pFirstSpace);
				String ID = info.substring(pFirstSpace + 1, pLastSpace - 1);
				ID = ID.replaceAll("\\s", "");
				String count = info.substring(pLastSpace);
				//System.out.println(name + " " + ID + " " + count);
				try {
					Server.out.write(name);
					Server.out.newLine();
					Server.out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					Server.out.write(ID);
					Server.out.newLine();
					Server.out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					Server.out.write(count);
					Server.out.newLine();
					Server.out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}).start();   
	    process.waitFor();
		Server.out.write("Done");
   		Server.out.newLine();
   		Server.out.flush();
	}
	
	
}
