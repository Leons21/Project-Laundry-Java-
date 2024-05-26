/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inilaundry;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class menu extends javax.swing.JFrame {

    Statement stat;
    ResultSet rs;
    String sql;
    int id_service, id_user;

    DefaultTableModel temp = new DefaultTableModel();
    DefaultTableModel tempo = new DefaultTableModel();

    public menu() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        stat = db.stm;

        this.prep();
        this.select();
        this.prep2();
        this.select2();

        vision();
    }

    public void prep() {
        // definisi daftar kolom pada tabel sementara (temp)
        temp.addColumn("Nama Depan");
        temp.addColumn("Nama Belakang");
        temp.addColumn("Username");
        temp.addColumn("No Telepon");
        temp.addColumn("Domisili");
        temp.addColumn("Alamat");
        temp.addColumn("Kode Pos");
        temp.addColumn("Password");

//        this.jTable1.setModel(temp);
        this.jTable2.setModel(temp);
    }

    public void prep2() {
        tempo.addColumn("ID Order");
        tempo.addColumn("ID User");
        tempo.addColumn("Jenis Paket");
        tempo.addColumn("Jenis Cucian");
        tempo.addColumn("Berat Cucian");
        tempo.addColumn("Metode Bayar");
        tempo.addColumn("Total Biaya");
        tempo.addColumn("Jumlah Bayar");

        this.jTable1.setModel(tempo);
    }

    public void select() {
        try {
            L1signin session = new L1signin();

            // ngosongin isi tabel di form
            temp.getDataVector().removeAllElements();
            temp.fireTableDataChanged();

            // query database
            sql = "SELECT * FROM USER_DATA WHERE USERNAME = '" + session.getUsername() + "'";
            rs = stat.executeQuery(sql);

            // tampilkan hasil di tabel sementara (temp)
            while (rs.next()) {
                Object[] o = new Object[8];
                o[0] = rs.getString("FRONT_NAME");
                o[1] = rs.getString("LAST_NAME");
                o[2] = rs.getString("USERNAME");
                o[3] = rs.getString("PHONE");
                o[4] = rs.getString("DOMICILE");
                o[5] = rs.getString("ADDRESS");
                o[6] = rs.getString("POST_CODE");
                o[7] = rs.getString("PASSWORD");
                temp.addRow(o);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Koneksi" + e);
        }
    }

    public void select2() {
        try {
            temp.getDataVector().removeAllElements();
            temp.fireTableDataChanged();

            sql = "SELECT * FROM ORDER_LOG";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                Object[] o = new Object[9];
                o[0] = rs.getString("ID_ORDER");
                o[1] = rs.getString("IN_DATE");
                o[2] = rs.getString("OUT_DATE");
                o[3] = rs.getString("PACKAGE");
                o[4] = rs.getString("CLOTH_TYPE");
                o[5] = rs.getString("WEIGHT");
                o[6] = rs.getString("BILL");
                o[7] = rs.getString("PAYMENT_METHOD");
                o[8] = rs.getString("PAYMENT");

                tempo.addRow(o);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Koneksi" + e);
        }
    }

    public void select3() {
        try {
            temp.getDataVector().removeAllElements();
            temp.fireTableDataChanged();

            sql = "SELECT * FROM SERVICE_FEE";
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                Object[] o = new Object[3];
                o[0] = rs.getString("ID_SERVICE");
                o[1] = rs.getString("SERVICE");
                o[2] = rs.getString("FEE");

                tempo.addRow(o);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Koneksi" + e);
        }
    }

    public void input(String jenisPaket, String jenisCucian, int beratCucian, String metodeBayar, Double totalBiaya, int jumlahBayar) {
        L1signin session = new L1signin();

        try {
            try {
                sql = "SELECT ID_SERVICE FROM SERVICE_FEE WHERE SERVICE = '" + jenisPaket + "'";
                rs = stat.executeQuery(sql);

                while (rs.next()) {
                    id_service = rs.getInt("ID_SERVICE");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengambil id_service" + e.getMessage());
            }

            try {
                sql = "SELECT ID_USER FROM USER_DATA WHERE USERNAME = '" + session.getUsername() + "'";
                rs = stat.executeQuery(sql);

                while (rs.next()) {
                    id_user = rs.getInt("ID_USER");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal mengambil id_user" + e.getMessage());
            }

            switch (id_service) {
                case 1:
                    sql = "INSERT INTO ORDER_LOG (ID_SERVICE, ID_USER, IN_DATE, OUT_DATE, PACKAGE, CLOTH_TYPE, WEIGHT, BILL, PAYMENT_METHOD, PAYMENT) "
                            + "VALUES ('" + id_service + "','" + id_user + "', NOW(), ADDDATE(NOW(), INTERVAL 2 DAY),'" + jenisPaket + "','" + jenisCucian + "'," + beratCucian + "," + totalBiaya + ",'" + metodeBayar + "'," + jumlahBayar + ")";
                    stat.executeUpdate(sql);
                    break;
                case 2:
                    sql = "INSERT INTO ORDER_LOG (ID_SERVICE, ID_USER, IN_DATE, OUT_DATE, PACKAGE, CLOTH_TYPE, WEIGHT, BILL, PAYMENT_METHOD, PAYMENT) "
                            + "VALUES ('" + id_service + "','" + id_user + "', NOW(), ADDDATE(NOW(), INTERVAL 1 DAY),'" + jenisPaket + "','" + jenisCucian + "'," + beratCucian + "," + totalBiaya + ",'" + metodeBayar + "'," + jumlahBayar + ")";
                    stat.executeUpdate(sql);
                    break;
                case 3:
                    sql = "INSERT INTO ORDER_LOG (ID_SERVICE, ID_USER, IN_DATE, OUT_DATE, PACKAGE, CLOTH_TYPE, WEIGHT, BILL, PAYMENT_METHOD, PAYMENT) "
                            + "VALUES ('" + id_service + "','" + id_user + "', NOW(), ADDDATE(NOW(), INTERVAL 6 HOUR),'" + jenisPaket + "','" + jenisCucian + "'," + beratCucian + "," + totalBiaya + ",'" + metodeBayar + "'," + jumlahBayar + ")";
                    stat.executeUpdate(sql);
                    break;
                default:
                    break;
            }

            JOptionPane.showMessageDialog(null, "Berhasil Memasukkan Data");
        } catch (Exception er) {
            JOptionPane.showMessageDialog(null, "Gagal Memasukkan Data" + er.getMessage());
        }
    }

    public void update(String a, String b, String c, String d, String e, String f, String g, String h) {
        try {
            sql = "update tb_user set fname = '" + a + "'"
                    + ", bname = '" + b + "'"
                    + ", username = '" + c + "'"
                    + ", notelp = '" + d + "'"
                    + ", domisili = '" + e + "'"
                    + ", alamat = '" + f + "'"
                    + ", kodepos = '" + g + "'"
                    + ", password = '" + h + "'";
            stat.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Berhasil Mengubah Data");
        } catch (Exception er) {
            JOptionPane.showMessageDialog(null, "Gagal Mengubah Data" + er.getMessage());
        }
    }

    public void vision() {
        this.home.setVisible(true);
        this.laundry.setVisible(false);
        this.history.setVisible(false);
        this.edit.setVisible(false);
        this.lblhome.setVisible(false);
        this.lbllaundry.setVisible(false);
        this.lblhistory.setVisible(false);
        this.lbleditdata.setVisible(false);
        this.lbllogout.setVisible(false);
    }

    private void home() {
        this.home.setVisible(true);
        this.laundry.setVisible(false);
        this.history.setVisible(false);
        this.edit.setVisible(false);
    }

    private void laundry() {
        this.home.setVisible(false);
        this.laundry.setVisible(true);
        this.history.setVisible(false);
        this.edit.setVisible(false);
    }

    private void history() {
        this.home.setVisible(false);
        this.laundry.setVisible(false);
        this.history.setVisible(true);
        this.edit.setVisible(false);
    }

    private void edit() {
        this.home.setVisible(false);
        this.laundry.setVisible(false);
        this.history.setVisible(false);
        this.edit.setVisible(true);
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
        jLabel2 = new javax.swing.JLabel();
        menuhome = new javax.swing.JLabel();
        lblhome = new javax.swing.JLabel();
        menulaundry = new javax.swing.JLabel();
        lbllaundry = new javax.swing.JLabel();
        menuhistory = new javax.swing.JLabel();
        lblhistory = new javax.swing.JLabel();
        menuedit = new javax.swing.JLabel();
        lbleditdata = new javax.swing.JLabel();
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
        laundry = new javax.swing.JScrollPane();
        laundry1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ketsatuan = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rblunas = new javax.swing.JRadioButton();
        rbbon = new javax.swing.JRadioButton();
        txtberat = new javax.swing.JTextField();
        cbcucian = new javax.swing.JComboBox<>();
        cbpaket = new javax.swing.JComboBox<>();
        satuan = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        history = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        edit = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtfront1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtback1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtusername1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtphone1 = new javax.swing.JTextField();
        rbsalatiga = new javax.swing.JRadioButton();
        rbluarsalatiga = new javax.swing.JRadioButton();
        txtaddress1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtpassword1 = new javax.swing.JPasswordField();
        txtpostcode1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        toolbar.setBackground(new java.awt.Color(0, 0, 0));
        toolbar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Poppins Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INI LAUNDRY");

        menuhome.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        menuhome.setForeground(new java.awt.Color(255, 255, 255));
        menuhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon home.png"))); // NOI18N
        menuhome.setText("Beranda");
        menuhome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuhomeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuhomeMousePressed(evt);
            }
        });

        lblhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/grey transparan.png"))); // NOI18N

        menulaundry.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        menulaundry.setForeground(new java.awt.Color(255, 255, 255));
        menulaundry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon wash machine.png"))); // NOI18N
        menulaundry.setText("Laundry");
        menulaundry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menulaundry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menulaundryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menulaundryMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                laundrymenu(evt);
            }
        });

        lbllaundry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/grey transparan.png"))); // NOI18N

        menuhistory.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        menuhistory.setForeground(new java.awt.Color(255, 255, 255));
        menuhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon history.png"))); // NOI18N
        menuhistory.setText("Riwayat");
        menuhistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuhistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuhistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuhistoryMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                historymenu(evt);
            }
        });

        lblhistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/grey transparan.png"))); // NOI18N

        menuedit.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        menuedit.setForeground(new java.awt.Color(255, 255, 255));
        menuedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon customer.png"))); // NOI18N
        menuedit.setText("Ubah Profil");
        menuedit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menueditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menueditMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editmenu(evt);
            }
        });

        lbleditdata.setForeground(new java.awt.Color(255, 255, 255));
        lbleditdata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/grey transparan.png"))); // NOI18N

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
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(toolbarLayout.createSequentialGroup()
                            .addGap(230, 230, 230)
                            .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(menuhome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblhome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbllaundry, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menulaundry, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblhistory, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menuhistory, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menuedit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbleditdata, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menulogout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbllogout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        toolbarLayout.setVerticalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(toolbarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(toolbarLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(menuhome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblhome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbllaundry, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menulaundry, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblhistory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menuhistory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(menuedit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbleditdata, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        laundry1.setBackground(new java.awt.Color(36, 36, 36));
        laundry1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Jenis Paket");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Jenis Cucian");

        ketsatuan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ketsatuan.setForeground(new java.awt.Color(255, 255, 255));
        ketsatuan.setText("Berat Cucian");

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Metode Bayar");

        rblunas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        rblunas.setForeground(new java.awt.Color(255, 255, 255));
        rblunas.setText("Lunas");
        rblunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rblunasActionPerformed(evt);
            }
        });

        rbbon.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        rbbon.setForeground(new java.awt.Color(255, 255, 255));
        rbbon.setText("Bon ( min DP 30% )");
        rbbon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbbonActionPerformed(evt);
            }
        });

        txtberat.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtberat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtberatActionPerformed(evt);
            }
        });

        cbcucian.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cbcucian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Seprai", "Selimut", "Sepatu" }));
        cbcucian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcucianActionPerformed(evt);
            }
        });

        cbpaket.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cbpaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reguler", "Ekspress", "Kilat" }));

        satuan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        satuan.setForeground(new java.awt.Color(255, 255, 255));
        satuan.setText("kg");

        jToggleButton1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jToggleButton1.setText("Simpan");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Poppins Black", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon wash machine.png"))); // NOI18N
        jLabel14.setText("PESAN LAUNDRY");
        jLabel14.setIconTextGap(20);

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jumlah Bayar");

        javax.swing.GroupLayout laundry1Layout = new javax.swing.GroupLayout(laundry1);
        laundry1.setLayout(laundry1Layout);
        laundry1Layout.setHorizontalGroup(
            laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(laundry1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, laundry1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbayar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, laundry1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rblunas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbbon, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(laundry1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laundry1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbpaket, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laundry1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbcucian, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laundry1Layout.createSequentialGroup()
                        .addComponent(ketsatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(satuan))))
        );
        laundry1Layout.setVerticalGroup(
            laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laundry1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laundry1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(cbpaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laundry1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel11))
                    .addComponent(cbcucian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(laundry1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ketsatuan)
                            .addComponent(satuan))))
                .addGap(26, 26, 26)
                .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laundry1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel13))
                    .addComponent(rblunas)
                    .addComponent(rbbon))
                .addGap(23, 23, 23)
                .addGroup(laundry1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        laundry.setViewportView(laundry1);

        getContentPane().add(laundry);
        laundry.setBounds(0, 40, 800, 360);

        history.setViewportView(null);

        jPanel4.setBackground(new java.awt.Color(36, 36, 36));
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));

        jLabel12.setFont(new java.awt.Font("Poppins Black", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon history.png"))); // NOI18N
        jLabel12.setText("RIWAYAT");
        jLabel12.setIconTextGap(20);

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        history.setViewportView(jPanel4);

        getContentPane().add(history);
        history.setBounds(0, 40, 800, 437);

        edit.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        edit.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(36, 36, 36));
        jPanel6.setForeground(new java.awt.Color(51, 51, 51));

        jLabel24.setFont(new java.awt.Font("Poppins Black", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inilaundry/tot/whiteicon customer.png"))); // NOI18N
        jLabel24.setText("UBAH PROFIL");
        jLabel24.setIconTextGap(20);

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("ID");

        lblid.setForeground(new java.awt.Color(255, 255, 255));
        lblid.setText("<< ID >>");

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nama Depan");

        txtfront1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nama Belakang");

        txtback1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Username");

        txtusername1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("No. Telp");

        jLabel29.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Domisili");

        txtphone1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        rbsalatiga.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        rbsalatiga.setForeground(new java.awt.Color(255, 255, 255));
        rbsalatiga.setText("Salatiga");
        rbsalatiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbsalatigaActionPerformed(evt);
            }
        });

        rbluarsalatiga.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        rbluarsalatiga.setForeground(new java.awt.Color(255, 255, 255));
        rbluarsalatiga.setText("Luar Salatiga");
        rbluarsalatiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbluarsalatigaActionPerformed(evt);
            }
        });

        txtaddress1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Alamat");

        jLabel31.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Kode Pos");

        jLabel32.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Password");

        txtpassword1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        txtpostcode1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jButton6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton6.setText("Simpan");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(102, 102, 102));
        jTable2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        jTable2.setToolTipText("");
        jTable2.setSelectionBackground(new java.awt.Color(51, 51, 255));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel24))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtfront1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtback1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(rbsalatiga, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rbluarsalatiga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtaddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtpostcode1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(lblid))
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(txtfront1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(txtback1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(txtusername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(txtphone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(rbsalatiga)
                    .addComponent(rbluarsalatiga))
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(txtaddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(txtpostcode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(txtpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        edit.setViewportView(jPanel6);

        getContentPane().add(edit);
        edit.setBounds(0, 40, 800, 360);

        setSize(new java.awt.Dimension(814, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuhomeMouseEntered
        // TODO add your handling code here:
        this.lblhome.setVisible(true);
    }//GEN-LAST:event_menuhomeMouseEntered

    private void menuhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuhomeMouseExited
        // TODO add your handling code here:
        this.lblhome.setVisible(false);
    }//GEN-LAST:event_menuhomeMouseExited

    private void menulaundryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulaundryMouseEntered
        // TODO add your handling code here:
        this.lbllaundry.setVisible(true);
    }//GEN-LAST:event_menulaundryMouseEntered

    private void menulaundryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulaundryMouseExited
        // TODO add your handling code here:
        this.lbllaundry.setVisible(false);
    }//GEN-LAST:event_menulaundryMouseExited

    private void menuhistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuhistoryMouseEntered
        // TODO add your handling code here:
        this.lblhistory.setVisible(true);
    }//GEN-LAST:event_menuhistoryMouseEntered

    private void menuhistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuhistoryMouseExited
        // TODO add your handling code here:
        this.lblhistory.setVisible(false);
    }//GEN-LAST:event_menuhistoryMouseExited

    private void menueditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menueditMouseEntered
        // TODO add your handling code here:
        this.lbleditdata.setVisible(true);
    }//GEN-LAST:event_menueditMouseEntered

    private void menueditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menueditMouseExited
        // TODO add your handling code here:
        this.lbleditdata.setVisible(false);
    }//GEN-LAST:event_menueditMouseExited

    private void menulogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulogoutMouseEntered
        // TODO add your handling code here:
        this.lbllogout.setVisible(true);
    }//GEN-LAST:event_menulogoutMouseEntered

    private void menulogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulogoutMouseExited
        // TODO add your handling code here:
        this.lbllogout.setVisible(false);
    }//GEN-LAST:event_menulogoutMouseExited

    private void menuhomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuhomeMousePressed
        // TODO add your handling code here:
        home();
    }//GEN-LAST:event_menuhomeMousePressed

    private void laundrymenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laundrymenu
        // TODO add your handling code here:
        laundry();
    }//GEN-LAST:event_laundrymenu

    private void historymenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historymenu
        // TODO add your handling code here:
        history();
    }//GEN-LAST:event_historymenu

    private void editmenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editmenu
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_editmenu

    private void menulogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulogoutMousePressed
        // TODO add your handling code here:
        L1signin si = new L1signin();
        si.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menulogoutMousePressed

    private void jLabel7jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7jLabel4MousePressed
        // TODO add your handling code here:
        laundry();
    }//GEN-LAST:event_jLabel7jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel8jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8jLabel5MousePressed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_jLabel8jLabel5MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        laundry();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel6jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6jLabel9MousePressed
        // TODO add your handling code here:
        history();
    }//GEN-LAST:event_jLabel6jLabel9MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        // TODO add your handling code here:
        history();
    }//GEN-LAST:event_jLabel9MousePressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String txtdomisili;
        if (rbsalatiga.isSelected()) {
            txtdomisili = rbsalatiga.getText();
        } else {
            txtdomisili = rbluarsalatiga.getText();
        }
        this.update(txtfront1.getText(),
                txtback1.getText(),
                txtusername1.getText(),
                txtphone1.getText(),
                txtdomisili,
                txtaddress1.getText(),
                txtpostcode1.getText(),
                txtpassword1.getText());
        this.select();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rbluarsalatigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbluarsalatigaActionPerformed
        // TODO add your handling code here:
        if (this.rbluarsalatiga.isSelected())
            this.rbsalatiga.setSelected(false);
    }//GEN-LAST:event_rbluarsalatigaActionPerformed

    private void rbsalatigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbsalatigaActionPerformed
        // TODO add your handling code here:
        if (this.rbsalatiga.isSelected())
            this.rbluarsalatiga.setSelected(false);
    }//GEN-LAST:event_rbsalatigaActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        // konversi jtable2 ke tabel sementara 2 (temp2)
        DefaultTableModel temp2 = (DefaultTableModel) jTable2.getModel();

        // ngambil data 1 baris yang diklik
        int selectedRowIndex = jTable2.getSelectedRow();

        // baris yang diklik dimasukkan ke textfield
        this.lblid.setText(temp2.getValueAt(selectedRowIndex, 0).toString());
        this.txtfront1.setText(temp2.getValueAt(selectedRowIndex, 1).toString());
        this.txtback1.setText(temp2.getValueAt(selectedRowIndex, 2).toString());
        this.txtusername1.setText(temp2.getValueAt(selectedRowIndex, 3).toString());
        this.txtphone1.setText(temp2.getValueAt(selectedRowIndex, 4).toString());
        if (temp2.getValueAt(selectedRowIndex, 5).toString().equalsIgnoreCase("salatiga")) {
            rbsalatiga.setSelected(true);
            rbluarsalatiga.setSelected(false);
        } else {
            rbsalatiga.setSelected(false);
            rbluarsalatiga.setSelected(true);
        }
        this.txtaddress1.setText(temp2.getValueAt(selectedRowIndex, 6).toString());
        this.txtpostcode1.setText(temp2.getValueAt(selectedRowIndex, 7).toString());
        this.txtpassword1.setText(temp2.getValueAt(selectedRowIndex, 8).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void rblunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rblunasActionPerformed
        // TODO add your handling code here:
        if (this.rblunas.isSelected()) {
            this.rbbon.setSelected(false);
        }
    }//GEN-LAST:event_rblunasActionPerformed

    private void rbbonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbbonActionPerformed
        // TODO add your handling code here:
        if (this.rbbon.isSelected()) {
            this.rblunas.setSelected(false);
        }
    }//GEN-LAST:event_rbbonActionPerformed

    private void txtberatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtberatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtberatActionPerformed

    private void cbcucianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcucianActionPerformed
        // TODO add your handling code here:
        if (cbcucian.getSelectedItem().toString().equalsIgnoreCase("normal")) {
            ketsatuan.setText("Berat Cucian");
            satuan.setText("kg");
        } else {
            ketsatuan.setText("Jumlah Cucian");
            if (cbcucian.getSelectedItem().toString().equalsIgnoreCase("sepatu")) {
                satuan.setText("pasang");
            } else {
                satuan.setText("buah");
            }
        }
    }//GEN-LAST:event_cbcucianActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        hitunglaundry hitung = new hitunglaundry();
        hitung.setJenisPaket(cbpaket.getSelectedItem().toString());
        hitung.setJenisCucian(cbcucian.getSelectedItem().toString());
        hitung.setJumlahCucian(Double.parseDouble(txtberat.getText()));
        hitung.setJumlahBayar(Double.parseDouble(txtbayar.getText()));
        if (rblunas.isSelected()) {
            hitung.setMetodebayar("Lunas");
        } else if (rbbon.isSelected()) {
            hitung.setMetodebayar("Bon");
        }
        hitung.getHargaTotal();
        if (hitung.getJumlahBayar() < hitung.getHargaTotal() * 0.3) {
            JOptionPane.showMessageDialog(null, "Uang Tidak Cukup\nMinimal Bayar " + hitung.getHargaTotal() * 0.3);
        } else if (hitung.getJumlahBayar() < hitung.getHargaTotal() && hitung.getJumlahBayar() >= hitung.getHargaTotal() * 0.3) {
            rbbon.setSelected(true); rblunas.setSelected(false);
            JOptionPane.showMessageDialog(null, "Sisa Pembayaran Anda : " + hitung.getSisaBayar());
        } else {
            rbbon.setSelected(false); rblunas.setSelected(true);
            JOptionPane.showMessageDialog(null, "Kembalian Anda : " + hitung.getSisaBayar() + "\nTerimakasih");
        }
        Double baru = hitung.getHargaTotal();
        if (rblunas.isSelected()) {
            this.input(cbpaket.getSelectedItem().toString(), cbcucian.getSelectedItem().toString(), Integer.parseInt(txtberat.getText()), rblunas.getText(), Double.parseDouble(baru.toString()), Integer.parseInt(txtbayar.getText()));
        } else {
            this.input(cbpaket.getSelectedItem().toString(), cbcucian.getSelectedItem().toString(), Integer.parseInt(txtberat.getText()), rbbon.getText(), Double.parseDouble(baru.toString()), Integer.parseInt(txtbayar.getText()));
        }
        this.select2();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> cbcucian;
    private javax.swing.JComboBox<String> cbpaket;
    private javax.swing.JScrollPane edit;
    private javax.swing.JScrollPane history;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel ketsatuan;
    private javax.swing.JScrollPane laundry;
    private javax.swing.JPanel laundry1;
    private javax.swing.JLabel lbleditdata;
    private javax.swing.JLabel lblhistory;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lbllaundry;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JLabel menuedit;
    private javax.swing.JLabel menuhistory;
    private javax.swing.JLabel menuhome;
    private javax.swing.JLabel menulaundry;
    private javax.swing.JLabel menulogout;
    private javax.swing.JRadioButton rbbon;
    private javax.swing.JRadioButton rbluarsalatiga;
    private javax.swing.JRadioButton rblunas;
    private javax.swing.JRadioButton rbsalatiga;
    private javax.swing.JLabel satuan;
    private javax.swing.JPanel toolbar;
    private javax.swing.JTextField txtaddress1;
    private javax.swing.JTextField txtback1;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtberat;
    private javax.swing.JTextField txtfront1;
    private javax.swing.JPasswordField txtpassword1;
    private javax.swing.JTextField txtphone1;
    private javax.swing.JTextField txtpostcode1;
    private javax.swing.JTextField txtusername1;
    // End of variables declaration//GEN-END:variables
}
