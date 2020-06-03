/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swing_frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class ListTaiKhoan extends javax.swing.JInternalFrame {
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
    static String te;
    String maUser1, maQ1;
    /**
     * Creates new form ListTaiKhoan
     */
    public ListTaiKhoan() {
        initComponents();
        remove_title_bar();
        connection = new MySqlConnectionUtil().getConnection();
        Addichage();
    }
public void clear(){
        txtIduser.setText("");
        txtidrole.setText("");
        txtpassword.setText("");
        txtsearch.setText("");
        txtusername.setText("");
    }
    public static String re(){
        return te;
    }
    public void Addichage(){
        try{
            String request = "select username as 'UserName',password as 'Password',name as 'Name',Quyen.TenQuyen as 'Quyen' from taikhoan,user_table,quyen where TaiKhoan.id_user=user_table.id_user and Quyen.MaQuyen= TaiKhoan.MaQuyen";
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
            String request = "select username,password,name,Quyen.TenQuyen from taikhoan,user_table,quyen where TaiKhoan.id_user=user_table.id_user and Quyen.MaQuyen= TaiKhoan.MaQuyen and username = '"+test+"' ";
            ps=connection.prepareStatement(request);
            rs= ps.executeQuery();
            if(rs.next()){
                String t1= rs.getString("username");
                txtusername.setText(t1);
                String t2= rs.getString("password");
                txtpassword.setText(t2);
                String t3= rs.getString("name");
                txtIduser.setText(t3);
                String t4= rs.getString("TenQuyen");
                txtidrole.setText(t4);
                
                maQ1= t4;
                maUser1= t3;
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
    public void search(){
       
        try{
             String request = "select username,password,name,Quyen.TenQuyen from taikhoan,user_table,quyen where TaiKhoan.id_user=user_table.id_user and Quyen.MaQuyen= TaiKhoan.MaQuyen and username like ?";
            ps = connection.prepareStatement(request);
            ps.setString(1,"%"+txtsearch.getText()+"%");
            rs= ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println(e);
        }
        
       
        try{
             String request = "select username,password,name,Quyen.TenQuyen from taikhoan,user_table,quyen where TaiKhoan.id_user=user_table.id_user and Quyen.MaQuyen= TaiKhoan.MaQuyen and username=?";
            ps = connection.prepareStatement(request);
            ps.setString(1, txtsearch.getText());
            rs= ps.executeQuery();
            
            if(rs.next()){
               String t1= rs.getString("username");
                txtusername.setText(t1);
                String t2= rs.getString("password");
                txtpassword.setText(t2);
                String t3= rs.getString("name");
                txtIduser.setText(t3);
                String t4= rs.getString("TenQuyen");
                txtidrole.setText(t4);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
             String request = "select username,password,name,Quyen.TenQuyen from taikhoan,user_table,quyen where TaiKhoan.id_user=user_table.id_user and Quyen.MaQuyen= TaiKhoan.MaQuyen and username like ?";
            ps = connection.prepareStatement(request);
            ps.setString(1, "%"+txtsearch.getText()+"%");
            rs= ps.executeQuery();
            
            if(rs.next()){
                String t1= rs.getString("username");
                txtusername.setText(t1);
                String t2= rs.getString("password");
                txtpassword.setText(t2);
                String t3= rs.getString("name");
                txtIduser.setText(t3);
                String t4= rs.getString("TenQuyen");
                txtidrole.setText(t4);
            }
        }catch(Exception e){
            System.out.println(e);
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        btnFreshe = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btlUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIduser = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtidrole = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

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

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

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

        btnFreshe.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btnFreshe.setText("Refresh");
        btnFreshe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFresheActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swing/images/user-add-icon.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("Thêm Tài Khoản");

        btlUpdate.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btlUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swing/images/Male-user-edit-icon.png"))); // NOI18N
        btlUpdate.setContentAreaFilled(false);
        btlUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlUpdateActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Sửa Tài Khoản");

        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/swing/images/user-delete-icon.png"))); // NOI18N
        btndelete.setContentAreaFilled(false);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel11.setText("Xóa Tài Khoản");

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

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnFreshe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btlUpdate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btndelete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtsearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnsearch, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(42, 42, 42))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addGap(57, 57, 57)))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(btlUpdate))
                        .addGap(55, 55, 55)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(btndelete)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(btnFreshe)
                        .addGap(18, 18, 18)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsearch))
                    .addComponent(btnFreshe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btlUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Tài Khoản"));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel1.setText("UserName");
        jLabel1.setToolTipText("");

        txtpassword.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Password");

        txtIduser.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtIduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIduserActionPerformed(evt);
            }
        });

        txtusername.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Id_Role");

        txtidrole.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtidrole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidroleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("Id_User");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIduser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidrole, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addComponent(txtIduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txtidrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
                Deplace();
    }//GEN-LAST:event_TableMouseClicked

    private void TableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseReleased
        btndelete.setEnabled(true);
        btlUpdate.setEnabled(true);
                Deplace();
    }//GEN-LAST:event_TableMouseReleased

    private void btnFresheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFresheActionPerformed
                Addichage();
                txtsearch.setText("");
                clear();
    }//GEN-LAST:event_btnFresheActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                this.te = "a";
                InsertTaiKhoan insertTaiKhoan = new InsertTaiKhoan();
                insertTaiKhoan.setVisible(true);
                insertTaiKhoan.clearData();
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btlUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlUpdateActionPerformed
                this.te="ah";
                InsertTaiKhoan insertTaiKhoan = new InsertTaiKhoan();
                insertTaiKhoan.setVisible(true);
    }//GEN-LAST:event_btlUpdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
                try{
                        if(JOptionPane.showConfirmDialog(null, "Ban Co Chac Chan Khong ?",
                                "Delete", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION);
                    if(txtusername.getText().length()!=0){
            
                        String request= "delete from TaiKhoan where username= ?";
                        ps= connection.prepareStatement(request);
                        ps.setString(1, txtusername.getText());
                        ps.execute();
                        System.out.println("deleted");
                        JOptionPane.showMessageDialog(null, "Deleted");
                        clear();
                    }else{JOptionPane.showMessageDialog(null,"Chon mot user");}
                }catch(Exception e){
                    System.out.println(e);
                }
        btndelete.setEnabled(false);
        btlUpdate.setEnabled(false);
                Addichage();
                clear();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtIduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIduserActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtidroleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidroleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidroleActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        search();
    }//GEN-LAST:event_txtsearchKeyReleased

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        search();
    }//GEN-LAST:event_btnsearchActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        btndelete.setEnabled(false);
        btlUpdate.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        this.Table.getTableHeader().setResizingAllowed(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Addichage();
        clear();
        btndelete.setEnabled(false);
        btlUpdate.setEnabled(false);
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btlUpdate;
    private javax.swing.JButton btnFreshe;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIduser;
    private javax.swing.JTextField txtidrole;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
