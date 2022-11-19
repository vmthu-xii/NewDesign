package controller;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;

import javax.swing.*;

import model.*;
import view.features.*;

public class ConnectListener implements ActionListener{
	
	private ConnectServerDesign connectDesign; 
	
	public ConnectListener(ConnectServerDesign connectDesign) { 
		this.connectDesign = connectDesign;
	}
	
	private void Connect() throws IOException {
		boolean test = true;
		int port = 6789;
		
		try {
			Client.client = new Socket(ConnectServerDesign.txtIP.getText(), port);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to " + e.getMessage());
            test = false;
            Client.client = null;
		}
		
		if(test) {
            JOptionPane.showMessageDialog(null, "Connected successfully!");

            // Create input and output streams to read from and write to the server
            Client.in = new BufferedReader(new InputStreamReader(Client.client.getInputStream()));
            Client.out = new BufferedWriter(new OutputStreamWriter(Client.client.getOutputStream()));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.Connect();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
