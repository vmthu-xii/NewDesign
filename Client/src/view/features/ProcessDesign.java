package view.features;

import controller.AppListener;
import controller.ProcessListener;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.table.*;

public class ProcessDesign extends javax.swing.JPanel {

    public ProcessDesign() {
        initComponents();
        
        spTable.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        spTable.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableProcess.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        
        tableProcess.setGridColor(new Color(230, 230, 230));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        ActionListener act = new ProcessListener(this);

        panelBorder1 = new view.components.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStartProcess = new javax.swing.JTextField();
        btnStartProcess = new javax.swing.JButton();
        panelBorder2 = new view.components.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtStopProcess = new javax.swing.JTextField();
        btnStopProcess = new javax.swing.JButton();
        panelBorder3 = new view.components.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnListProcess = new javax.swing.JButton();
        spTable = new javax.swing.JScrollPane();
        tableProcess = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(141, 185, 205));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 29, 82));
        jLabel1.setText("Start a process ");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 2, 13)); // NOI18N
        jLabel2.setText("Enter an process name and click START to start it on server  ");

        txtStartProcess.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStartProcess.setPreferredSize(new java.awt.Dimension(70, 25));

        btnStartProcess.setText("START");
        btnStartProcess.setPreferredSize(new java.awt.Dimension(72, 25));
        btnStartProcess.addActionListener(act);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(txtStartProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnStartProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStartProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStartProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelBorder2.setBackground(new java.awt.Color(141, 185, 205));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(15, 29, 82));
        jLabel3.setText("Stop (a) process ");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 2, 13)); // NOI18N
        jLabel4.setText("Enter an process ID (name) and click STOP to stop it (all of them) on server ");

        txtStopProcess.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStopProcess.setPreferredSize(new java.awt.Dimension(70, 25));

        btnStopProcess.setText("STOP");
        btnStopProcess.setPreferredSize(new java.awt.Dimension(72, 25));
        btnStopProcess.addActionListener(act);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(txtStopProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStopProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStopProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStopProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelBorder3.setBackground(new java.awt.Color(141, 185, 205));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(15, 29, 82));
        jLabel5.setText("Show running processes");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 2, 13)); // NOI18N
        jLabel6.setText("Click LIST to show all running processes on server ");

        btnListProcess.setText("LIST");
        btnListProcess.setPreferredSize(new java.awt.Dimension(72, 25));
        btnListProcess.addActionListener(act);

        spTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableProcess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name Process", "ID Process", "Count thread"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProcess.getTableHeader().setReorderingAllowed(false);
        spTable.setViewportView(tableProcess);
        if (tableProcess.getColumnModel().getColumnCount() > 0) {
            tableProcess.getColumnModel().getColumn(0).setResizable(false);
            tableProcess.getColumnModel().getColumn(1).setResizable(false);
            tableProcess.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelBorder3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnListProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListProcess;
    private javax.swing.JButton btnStartProcess;
    private javax.swing.JButton btnStopProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private view.components.PanelBorder panelBorder1;
    private view.components.PanelBorder panelBorder2;
    private view.components.PanelBorder panelBorder3;
    private javax.swing.JScrollPane spTable;
    public javax.swing.JTable tableProcess;
    public javax.swing.JTextField txtStartProcess;
    public javax.swing.JTextField txtStopProcess;
    // End of variables declaration//GEN-END:variables
}
