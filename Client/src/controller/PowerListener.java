package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Client;
import view.features.*;

public class PowerListener implements ActionListener {
    private PowerDesign powerDesign;
    public PowerListener(PowerDesign powerDesign ) {
        this.powerDesign = powerDesign;
    }


    private void ShutdownListenner() throws IOException{
        String s = "SHUTDOWN";
        Client.out.write(s);
        Client.out.newLine();
        Client.out.flush();
        Client.client.close();
        Client.client = null;
    }

    private void RestartListener() throws IOException{

        String s = "RESTART";
        Client.out.write(s);
        Client.out.newLine();
        Client.out.flush();
        Client.client.close();
        Client.client = null;
    }
    
    private void SleepListener() throws IOException{

        String s = "SLEEP";
        Client.out.write(s);
        Client.out.newLine();
        Client.out.flush();
        Client.client.close();
        Client.client = null;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(Client.client == null) {
            JOptionPane.showMessageDialog(null, "Not connected to the server");
            return;
        }
    	
        String scr = e.getActionCommand();

        if (scr.equals("SHUTDOWN"))
        {
            try {
                this.ShutdownListenner();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (scr.equals("RESTART"))
        {
            try {
                this.RestartListener();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (scr.equals("SLEEP"))
        {
            try {
                this.SleepListener();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
