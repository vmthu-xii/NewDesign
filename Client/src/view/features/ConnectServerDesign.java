package view.features;

import java.awt.*;
import java.awt.event.ActionListener;

import controller.ConnectListener;
import model.Client;

public class ConnectServerDesign extends javax.swing.JPanel {

    public ConnectServerDesign() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	ActionListener act = new ConnectListener(this);
    	
        jLabel1 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();

        setBackground(new java.awt.Color(232, 231, 231));
        setPreferredSize(new java.awt.Dimension(610, 45));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        jLabel1.setText("Enter server IP: ");
       
        txtIP.setAutoscrolls(false);
        txtIP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnConnect.setBackground(new java.awt.Color(15, 32, 39));
        btnConnect.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnConnect.setForeground(new java.awt.Color(255, 255, 255));
        btnConnect.setText("Connect");
        btnConnect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConnect.setPreferredSize(new java.awt.Dimension(80, 30));
        btnConnect.addActionListener(act);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
    }// </editor-fold>                        

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        g2d.fillRect(0, 0, 25, getHeight());
        g2d.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());

        super.paintComponent(grphcs);
    }
    
    // Variables declaration - do not modify                     
    public javax.swing.JButton btnConnect;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JTextField txtIP;
    // End of variables declaration                   
}
