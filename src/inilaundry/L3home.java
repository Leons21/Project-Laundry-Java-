/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inilaundry;

/**
 *
 * @author HP
 */
public class L3home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public L3home() {
        initComponents();
        this.lbllogout.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JPanel();
        menulogout = new javax.swing.JLabel();
        lbllogout = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Beranda - Ini Laundry");
        setResizable(false);
        getContentPane().setLayout(null);

        toolbar.setBackground(new java.awt.Color(0, 0, 0));
        toolbar.setForeground(new java.awt.Color(0, 0, 0));

        menulogout.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        menulogout.setForeground(new java.awt.Color(255, 255, 255));
        menulogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon logout.png"))); // NOI18N
        menulogout.setText("Keluar");
        menulogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menulogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menulogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menulogoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menulogoutMousePressed(evt);
            }
        });

        lbllogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/grey transparan.png"))); // NOI18N

        javax.swing.GroupLayout toolbarLayout = new javax.swing.GroupLayout(toolbar);
        toolbar.setLayout(toolbarLayout);
        toolbarLayout.setHorizontalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(toolbarLayout.createSequentialGroup()
                    .addGap(0, 685, Short.MAX_VALUE)
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menulogout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbllogout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 5, Short.MAX_VALUE)))
        );
        toolbarLayout.setVerticalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(toolbarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menulogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbllogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(toolbar);
        toolbar.setBounds(0, 0, 800, 40);

        home.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Laundry");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7jLabel4MousePressed(evt);
            }
        });
        home.add(jLabel7);
        jLabel7.setBounds(40, 210, 200, 70);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon 48 username.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        home.add(jLabel5);
        jLabel5.setBounds(560, 160, 200, 70);

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ubah Profil");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8jLabel5MousePressed(evt);
            }
        });
        home.add(jLabel8);
        jLabel8.setBounds(560, 210, 200, 70);

        jLabel3.setFont(new java.awt.Font("Poppins Black", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INI LAUNDRY");
        home.add(jLabel3);
        jLabel3.setBounds(20, 30, 761, 80);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon 48 wash machine.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        home.add(jLabel4);
        jLabel4.setBounds(40, 160, 200, 70);

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Riwayat");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6jLabel9MousePressed(evt);
            }
        });
        home.add(jLabel6);
        jLabel6.setBounds(300, 210, 200, 70);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon 48 history.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });
        home.add(jLabel9);
        jLabel9.setBounds(300, 160, 200, 70);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/Home.png"))); // NOI18N
        home.add(bg);
        bg.setBounds(0, -40, 800, 400);

        getContentPane().add(home);
        home.setBounds(0, 40, 800, 360);

        setSize(new java.awt.Dimension(815, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7jLabel4MousePressed
        // TODO add your handling code here:
        L4laundry laundry = new L4laundry();
        laundry.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:
        L6editdata edit = new L6editdata();
        edit.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel8jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8jLabel5MousePressed
        // TODO add your handling code here:
        L6editdata edit = new L6editdata();
        edit.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8jLabel5MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        L4laundry laundry = new L4laundry();
        laundry.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel6jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6jLabel9MousePressed
        // TODO add your handling code here:
        L5history history = new L5history();
        history.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6jLabel9MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        // TODO add your handling code here:
        L5history history = new L5history();
        history.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel9MousePressed

    private void menulogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulogoutMousePressed
        // TODO add your handling code here:
        L1signin si = new L1signin();
        si.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menulogoutMousePressed

    private void menulogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulogoutMouseExited
        // TODO add your handling code here:
        this.lbllogout.setVisible(false);
    }//GEN-LAST:event_menulogoutMouseExited

    private void menulogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulogoutMouseEntered
        // TODO add your handling code here:
        this.lbllogout.setVisible(true);
    }//GEN-LAST:event_menulogoutMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(L3home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(L3home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(L3home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(L3home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new L3home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JPanel home;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JLabel menulogout;
    private javax.swing.JPanel toolbar;
    // End of variables declaration//GEN-END:variables
}
