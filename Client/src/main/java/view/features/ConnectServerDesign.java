package view.features;

import java.awt.*;
import java.awt.event.ActionListener;

import controller.*;

public class ConnectServerDesign extends javax.swing.JPanel {

    public ConnectServerDesign() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

		ActionListener act = new ConnectListener(this);

        lbIP = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();
        txtIP = new javax.swing.JTextField();

        setBackground(java.awt.SystemColor.controlHighlight);
        setOpaque(false);

        lbIP.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lbIP.setText("Enter IP of server :");
        
		btnConnect.addActionListener(act);
        btnConnect.setBackground(new java.awt.Color(15, 32, 39));
        btnConnect.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConnect.setForeground(new java.awt.Color(255, 255, 255));
        btnConnect.setText("Connect");
        btnConnect.setBorder(null);
        btnConnect.setPreferredSize(new java.awt.Dimension(75, 30));

        txtIP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIP.setPreferredSize(new java.awt.Dimension(65, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIP)
                .addGap(18, 18, 18)
                .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel lbIP;
    public static javax.swing.JTextField txtIP;
    // End of variables declaration//GEN-END:variables
}
