/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swing_frame;

import java.awt.print.PrinterException;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.print.PrintException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class ListDanhSachDatPhong extends javax.swing.JInternalFrame {

    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
    static String te;
    public  ImageIcon Format= null;
    public ListDanhSachDatPhong() {
        initComponents();
        remove_title_bar();
        connection = new MySqlConnectionUtil().getConnection();
        Addichage();
    }
    public static String re(){
        return te;
    }
    public void clear(){
        txtId.setText("");
        txtMaKH.setText("");
        txtNgayDat.setText("");
        txtMaPhong.setText("");
        txtId_user.setText("");
        txtTinhTrang.setText("");
        txtGhiChu.setText("");
       
    }
    public void Addichage(){
        try{
            String request = "select MaDP as 'MaDP',user_table.name as 'Ten Nguoi dung' ,KhachHang.HoTen as 'Ten Khach Hang',Phong.TenPhong as 'Ten Phong',NgayDat,GhiChu,DatPhong.TinhTrang from user_table,khachhang,phong,datphong where user_table.id_user=DatPhong.id_user and KhachHang.MaKH=DatPhong.MaKH and Phong.MaPhong=DatPhong.MaDP";
            ps = connection.prepareStatement(request);
            rs=ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            System.out.println("Exception"+ e);
        }
    }
    public  void Deplace(){
        try{
            int row = Table.getSelectedRow();
            this.test = (Table.getModel().getValueAt(row,0).toString());
            String request = "select * from DatPhong where MaDP = '"+test+"' ";
            ps=connection.prepareStatement(request);
            rs= ps.executeQuery();
            if(rs.next()){
                String t1= rs.getString("MaDP");
                txtId.setText(t1);
                String t2= rs.getString("id_user");
                txtId_user.setText(t2);
                String t3= rs.getString("MaKH");
                txtMaKH.setText(t3);
                String t4= rs.getString("MaPhong");
                txtMaPhong.setText(t4);
                String t5= rs.getString("NgayDat");
                txtNgayDat.setText(t5);
                String t6= rs.getString("GhiChu");
                txtGhiChu.setText(t6);
                String t7= rs.getString("TinhTrang");
                txtTinhTrang.setText(t7);
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    void remove_title_bar(){
        putClientProperty("List_des_Conddats.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }
    public static String gettalleresult(){
        return test;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtId_user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTinhTrang = new javax.swing.JTextField();
        txtNgayDat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        btnprint = new javax.swing.JButton();
        btlUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        btnFreshe = new javax.swing.JButton();

        setBorder(null);
        setTitle("List");
        setPreferredSize(new java.awt.Dimension(800, 346));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("List Of User"));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel10.setText("GhiChu");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel1.setText("Id");

        txtId_user.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtId_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_userActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Id_user");
        jLabel4.setToolTipText("");

        txtTinhTrang.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTinhTrangActionPerformed(evt);
            }
        });

        txtNgayDat.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtNgayDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayDatActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel8.setText("TinhTrang");

        txtMaKH.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("MaPhong");

        txtMaPhong.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel7.setText("NgayDat");

        txtGhiChu.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("MaKH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId_user, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtId_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39))
        );

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swing/images/user-add-icon.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swing/images/user-delete-icon.png"))); // NOI18N
        btndelete.setContentAreaFilled(false);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        Table.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        btnprint.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swing/images/Folders-OS-Exit-Full-Screen-Metro-icon.png"))); // NOI18N
        btnprint.setContentAreaFilled(false);
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        btlUpdate.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btlUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swing/images/Male-user-edit-icon.png"))); // NOI18N
        btlUpdate.setContentAreaFilled(false);
        btlUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("Thêm Đặt Phòng");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Sửa Đặt Phòng");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel11.setText("Xóa Đặt Phòng");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel12.setText("Print");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btlUpdate)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btndelete)
                            .addComponent(jLabel11))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnprint))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnprint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btlUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtsearch.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        btnsearch.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnFreshe.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btnFreshe.setText("Refresh");
        btnFreshe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFresheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnFreshe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtsearch)
                        .addComponent(btnFreshe))
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.te = "a";
        
        InsertUser insertUser = new InsertUser();
        insertUser.setVisible(true);
        insertUser.clearData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuActionPerformed

    private void txtId_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_userActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtNgayDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayDatActionPerformed

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        Deplace();
    }//GEN-LAST:event_TableMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(null, "Ban Co Chac Chan Khong ?",
                    "Delete", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION);
            if(txtId.getText().length()!=0){
               
            String request= "delete from DatPhong where MaDP= ?";
            ps= connection.prepareStatement(request);
            ps.setString(1, txtId.getText());
            ps.execute();
            System.out.println("deleted");
            JOptionPane.showMessageDialog(null, "Deleted");
             clear();
            }else{JOptionPane.showMessageDialog(null,"Chon mot phiếu đặt phòng");}
        }catch(Exception e){
            System.out.println(e);
        }
        btndelete.setEnabled(false);
        btlUpdate.setEnabled(false);
        Addichage();
        clear();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btlUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlUpdateActionPerformed
        this.te="ah";
        InsertUser insertUser = new InsertUser();
        insertUser.setVisible(true);
    }//GEN-LAST:event_btlUpdateActionPerformed

    private void TableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseReleased
        btndelete.setEnabled(true);
        btlUpdate.setEnabled(true);
        Deplace();
    }//GEN-LAST:event_TableMouseReleased

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        btndelete.setEnabled(false);
        btlUpdate.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        MessageFormat header= new MessageFormat("List Danh Sach Dat Phong:");
        MessageFormat footer= new MessageFormat("Page");
        try{
            Table.print(JTable.PrintMode.NORMAL,header,footer);
        }catch(PrinterException e){
            System.err.format("Sai roi",e.getMessage());
        }
    }//GEN-LAST:event_btnprintActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        search();
       
    }//GEN-LAST:event_btnsearchActionPerformed
    public void search(){
       
        try{
             String request = "select * from user_table where name like ?";
            ps = connection.prepareStatement(request);
            ps.setString(1,"%"+txtsearch.getText()+"%");
            rs= ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
        
       
        try{
             String request = "select * from user_table where id_user=?";
            ps = connection.prepareStatement(request);
            ps.setString(1, txtsearch.getText());
            rs= ps.executeQuery();
            
            if(rs.next()){
                 String t1= rs.getString("MaDP");
                txtId.setText(t1);
                String t2= rs.getString("id_user");
                txtId_user.setText(t2);
                String t3= rs.getString("MaKH");
                txtMaKH.setText(t3);
                String t4= rs.getString("MaPhong");
                txtMaPhong.setText(t4);
                String t5= rs.getString("NgayDat");
                txtNgayDat.setText(t5);
                String t6= rs.getString("GhiChu");
                txtGhiChu.setText(t6);
                String t7= rs.getString("TinhTrang");
                txtTinhTrang.setText(t7);
              
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
             String request = "select * from user_table where name like ?";
            ps = connection.prepareStatement(request);
            ps.setString(1, "%"+txtsearch.getText()+"%");
            rs= ps.executeQuery();
            
            if(rs.next()){
                String t1= rs.getString("MaDP");
                txtId.setText(t1);
                String t2= rs.getString("id_user");
                txtId_user.setText(t2);
                String t3= rs.getString("MaKH");
                txtMaKH.setText(t3);
                String t4= rs.getString("MaPhong");
                txtMaPhong.setText(t4);
                String t5= rs.getString("NgayDat");
                txtNgayDat.setText(t5);
                String t6= rs.getString("GhiChu");
                txtGhiChu.setText(t6);
                String t7= rs.getString("TinhTrang");
                txtTinhTrang.setText(t7);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
  
    private void btnFresheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFresheActionPerformed
       Addichage();
       txtsearch.setText("");
       clear();
    }//GEN-LAST:event_btnFresheActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
     search();
    }//GEN-LAST:event_txtsearchKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Addichage();
        clear();
        btndelete.setEnabled(false);
        btlUpdate.setEnabled(false);
      
    }//GEN-LAST:event_formMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        this.Table.getTableHeader().setResizingAllowed(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTinhTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTinhTrangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btlUpdate;
    private javax.swing.JButton btnFreshe;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtId_user;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtNgayDat;
    private javax.swing.JTextField txtTinhTrang;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
