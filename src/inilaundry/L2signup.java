/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inilaundry;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class L2signup extends javax.swing.JFrame {

    /**
     * Creates new form signup
     */
    
    Statement stat;
    ResultSet rs;
    String sql;
    
    public L2signup() {
        initComponents();
        koneksi db = new koneksi();
        stat = db.stm;
    }
 
    public void inputdata(String frontName, String lastName, String username, String phone, String domicile, String address, String postCode, String password) {
        try {
            L0hashing bcrypt = new L0hashing();
            
            password = bcrypt.bcryptHashing(password);
            
            sql = "INSERT INTO USER_DATA (USERNAME, PASSWORD, FRONT_NAME, LAST_NAME, PHONE, DOMICILE, ADDRESS, POST_CODE)"
                    + "values ('" + username + "','" + password + "','" + frontName + "','" + lastName + "','" + phone + "','" + domicile + "','" + address + "','" + postCode + "')";
            stat.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Berhasil Daftar");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Daftar" + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtfront = new javax.swing.JTextField();
        txtback = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtpostcode = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rbsalatiga = new javax.swing.JRadioButton();
        rbluarsalatiga = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulir Daftar - Ini Laundry");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama Depan");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(440, 20, 110, 19);

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nama Belakang");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(440, 60, 110, 19);

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Username");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(440, 100, 110, 19);

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("No. Telp");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(440, 140, 110, 19);

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Domisili");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(440, 180, 110, 19);

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Alamat");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(440, 220, 110, 19);

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Kode Pos");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(440, 260, 110, 19);

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Password");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(440, 300, 110, 19);

        txtfront.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtfront.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfrontActionPerformed(evt);
            }
        });
        getContentPane().add(txtfront);
        txtfront.setBounds(570, 20, 190, 25);

        txtback.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbackActionPerformed(evt);
            }
        });
        getContentPane().add(txtback);
        txtback.setBounds(570, 60, 190, 25);

        txtusername.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        getContentPane().add(txtusername);
        txtusername.setBounds(570, 100, 190, 25);

        txtphone.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        getContentPane().add(txtphone);
        txtphone.setBounds(570, 140, 190, 25);

        txtaddress.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        getContentPane().add(txtaddress);
        txtaddress.setBounds(570, 220, 190, 25);

        txtpostcode.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        getContentPane().add(txtpostcode);
        txtpostcode.setBounds(570, 260, 190, 25);

        txtpassword.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        getContentPane().add(txtpassword);
        txtpassword.setBounds(570, 300, 190, 25);

        jButton1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton1.setText("Hapus");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(670, 350, 80, 26);

        jButton2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton2.setText("Simpan");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(580, 350, 80, 26);

        rbsalatiga.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        rbsalatiga.setForeground(new java.awt.Color(255, 255, 255));
        rbsalatiga.setText("Salatiga");
        rbsalatiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbsalatigaActionPerformed(evt);
            }
        });
        getContentPane().add(rbsalatiga);
        rbsalatiga.setBounds(570, 180, 80, 24);

        rbluarsalatiga.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        rbluarsalatiga.setForeground(new java.awt.Color(255, 255, 255));
        rbluarsalatiga.setText("Luar Salatiga");
        rbluarsalatiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbluarsalatigaActionPerformed(evt);
            }
        });
        getContentPane().add(rbluarsalatiga);
        rbluarsalatiga.setBounds(650, 180, 120, 24);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/icons8-back-48.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 48, 48);

        jLabel3.setFont(new java.awt.Font("Poppins Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon signup.png"))); // NOI18N
        jLabel3.setText("DAFTAR");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 180, 170, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/Register.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 800, 400);

        setSize(new java.awt.Dimension(814, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbsalatigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbsalatigaActionPerformed
        // TODO add your handling code here:
        if(this.rbsalatiga.isSelected())
            this.rbluarsalatiga.setSelected(false);
    }//GEN-LAST:event_rbsalatigaActionPerformed

    private void rbluarsalatigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbluarsalatigaActionPerformed
        // TODO add your handling code here:
        if(this.rbluarsalatiga.isSelected())
            this.rbsalatiga.setSelected(false);
    }//GEN-LAST:event_rbluarsalatigaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        L1signin si = new L1signin();
        if(txtfront.getText().isBlank() || 
                txtback.getText().isBlank() || 
                txtusername.getText().isBlank() || 
                txtphone.getText().isBlank() || 
                txtaddress.getText().isBlank() || 
                txtpostcode.getText().isBlank() || 
                txtpassword.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Masukkan Data");
        } else if(rbsalatiga.isSelected()) {
            this.inputdata(txtfront.getText(), txtback.getText(), txtusername.getText(), txtphone.getText(), this.rbsalatiga.getText(), txtaddress.getText(), txtpostcode.getText(), txtpassword.getText());
            this.setVisible(false);
            si.setVisible(true);
        } else if(rbluarsalatiga.isSelected()) {
            this.inputdata(txtfront.getText(), txtback.getText(), txtusername.getText(), txtphone.getText(), this.rbluarsalatiga.getText(), txtaddress.getText(), txtpostcode.getText(), txtpassword.getText());
            this.setVisible(false);
            si.setVisible(true);
        }
        
        // panggil method tampilkan barang, agar data baru tampil di tabel SELECT
        menu menu = new menu();
        menu.select();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        L1signin si = new L1signin();
        si.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.txtfront.setText("");
        this.txtback.setText("");
        this.txtusername.setText("");
        this.txtphone.setText("");
        this.txtaddress.setText("");
        this.txtpostcode.setText("");
        this.txtpassword.setText("");
        this.rbluarsalatiga.setSelected(false);
        this.rbsalatiga.setSelected(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtfrontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfrontActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfrontActionPerformed

    private void txtbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbackActionPerformed

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
            java.util.logging.Logger.getLogger(L2signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(L2signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(L2signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(L2signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new L2signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbluarsalatiga;
    private javax.swing.JRadioButton rbsalatiga;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtback;
    private javax.swing.JTextField txtfront;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtpostcode;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
