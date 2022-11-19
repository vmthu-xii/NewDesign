import java.io.IOException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws IOException {
		Process process;
		
//		if (type == "APP") 
		process = new ProcessBuilder("powershell","\"gps| ? {$_.mainwindowtitle.length -ne 0} | Format-Table -HideTableHeaders  name, ID, {$_.Threads.Count}").start(); 
			//process = new ProcessBuilder("powershell","\"gps| ? {$_.mainwindowtitle.length -ne 0} | Format-Table -HideTableHeaders  name, ID").start(); 
//		else 
//			process = new ProcessBuilder("powershell","\"gps| Format-Table -HideTableHeaders  name, ID").start(); 
//			//process = new ProcessBuilder("powershell -command \"Get-Process |  Format-Table -HideTableHeaders Name, Id, {$_.Threads.Count}").start();


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
				System.out.println(name + " " + ID + " " + count);
				
			}
		}).start();   
	}
}
