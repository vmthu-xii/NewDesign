package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.features.*;


public class AppListener implements ActionListener{
	
	private AppDesign appDesign; 
	
	public AppListener(AppDesign appDesign) { 
		this.appDesign = appDesign;
	}

	private void List() throws IOException {
		String s = "LIST_APP";
		Client.out.write(s);
		Client.out.newLine();
		Client.out.flush();
		
		String name = null;
		String ID = null;
		String count = null;
		
		this.ClearListener();
		
		while(true) {
			name = Client.in.readLine();
			if(name.equals("Done")) break;
			ID = Client.in.readLine();
			count = Client.in.readLine();
			String list[] = {name, ID, count};
			DefaultTableModel model = (DefaultTableModel) appDesign.tableApp.getModel();
	        model.addRow(list);
		}
	}
	
	private void Start() throws IOException {
		String s = "START_APP";
		String name = null;
		name = appDesign.txtNameApp.getText();
				
		if(name != "") {
			Client.out.write(s);
			Client.out.newLine();
			Client.out.flush();
			
			Client.out.write(name);
			Client.out.newLine();
			Client.out.flush();
		} else {
			JOptionPane.showMessageDialog(null, "Please enter an application name!");
		}
		
		try {
			s = Client.in.readLine();
		} catch (IOException e1) {
		}
        JOptionPane.showMessageDialog(null, s);
	}
	
	private void Stop() throws IOException {
		String s = "STOP_APP";
		String ID = appDesign.txtIDApp.getText();

		if(ID != null) { 
			Client.out.write(s);
			Client.out.newLine();
			Client.out.flush();
		
			Client.out.write(ID);
			Client.out.newLine();
			Client.out.flush();
		} else {
			JOptionPane.showMessageDialog(null, "Please enter an application ID!");
		}
		
		try {
			s = Client.in.readLine();
		} catch (IOException e1) {
		}
        JOptionPane.showMessageDialog(null, s);
	}
	
	private void ClearListener() {
		DefaultTableModel model = (DefaultTableModel) appDesign.tableApp.getModel();
		model.setRowCount(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		
		String click = e.getActionCommand();
		
		if(click.equals("LIST"))
			try {
				this.List();
			} catch (IOException e2) {
				e2.printStackTrace();
			} 
		
		if(click.equals("START"))
			try {
				this.Start();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		if(click.equals("STOP"))
			try {
				this.Stop();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
}	