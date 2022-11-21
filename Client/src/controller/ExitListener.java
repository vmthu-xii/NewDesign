package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Client;
import view.features.ExitDesign;

public class ExitListener implements ActionListener {

	private ExitDesign exitDesign;
	
	public ExitListener(ExitDesign exitDesign) {
		this.exitDesign = exitDesign;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = "EXIT";
		if (Client.client != null) {
			try {
				Client.out.write(s);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		System.exit(0);
	}
}
