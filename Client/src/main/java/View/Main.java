package View;

import View.Features.AppDesign;
import View.Features.Form5_Capture;
import View.Features.ProcessDesign;
import View.Features.ExitDesign;
import View.Features.ControlDesign;
import View.Features.InfoProjectDesign;
import View.Features.KeylogDesign;
import java.awt.*;
import javax.swing.*;

public class Main extends javax.swing.JFrame {

    private InfoProjectDesign info;
    private AppDesign application;
    private ProcessDesign process;
    private KeylogDesign keystroke;
    private Form5_Capture capture;
    private ControlDesign shutdown;
    private ExitDesign exit;
    
    public Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        
        info = new InfoProjectDesign();
        application = new AppDesign();
        process = new ProcessDesign();
        keystroke = new KeylogDesign();
        capture = new Form5_Capture();
        shutdown = new ControlDesign();
        exit = new ExitDesign();
        
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if(index == 0) {
                    setForm(info);
                } else if(index == 1) {
                    setForm(application);
                } else if(index == 2) {
                    setForm(process);
                } else if (index == 3) {
                    setForm(keystroke);
                } else if (index == 4) {
                    setForm(capture);
                } else if (index == 5) {
                    setForm(shutdown);
                } else if (index == 6) {
                    setForm(exit);
                }
            }
        });
        
        setForm(new InfoProjectDesign());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new View.Header();
        jPanel2 = new javax.swing.JPanel();
        panelBorder = new View.PanelBorder();
        panelBorder2 = new View.PanelBorder();
        header = new View.Header();
        mainPanel = new javax.swing.JPanel();
        menu = new View.Menu();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setPreferredSize(new java.awt.Dimension(580, 45));

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorderLayout = new javax.swing.GroupLayout(panelBorder);
        panelBorder.setLayout(panelBorderLayout);
        panelBorderLayout.setHorizontalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorderLayout.setVerticalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderLayout.createSequentialGroup()
                .addGroup(panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorderLayout.createSequentialGroup()
                        .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Header header;
    private View.Header header1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    private View.Menu menu;
    private View.PanelBorder panelBorder;
    private View.PanelBorder panelBorder2;
    // End of variables declaration//GEN-END:variables
}
