package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.features.*;


public class ProcessListener implements ActionListener{

    private ProcessDesign processDesign;

    public ProcessListener(ProcessDesign processDesign) {
        this.processDesign = processDesign;
    }

    private void List() throws IOException {
        String s = "LIST_PROCESS";
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
            DefaultTableModel model = (DefaultTableModel) processDesign.tableProcess.getModel();
            model.addRow(list);
        }
    }

    private void Start() throws IOException {
        String s = "START_PROCESS";
        String name = null;
        name = processDesign.txtStartProcess.getText();

        if(name != "") {
            Client.out.write(s);
            Client.out.newLine();
            Client.out.flush();

            Client.out.write(name);
            Client.out.newLine();
            Client.out.flush();
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a process name!");
        }

        try {
            s = Client.in.readLine();
        } catch (IOException e1) {
        }
        JOptionPane.showMessageDialog(null, s);
    }

    private void Stop() throws IOException {
        String s = "STOP_PROCESS";
        String ID = processDesign.txtStopProcess.getText();

        if(ID != null) {
            Client.out.write(s);
            Client.out.newLine();
            Client.out.flush();

            Client.out.write(ID);
            Client.out.newLine();
            Client.out.flush();
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a process ID!");
        }

        try {
            s = Client.in.readLine();
        } catch (IOException e1) {
        }
        JOptionPane.showMessageDialog(null, s);
    }

    private void ClearListener() {
        DefaultTableModel model = (DefaultTableModel) processDesign.tableProcess.getModel();
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