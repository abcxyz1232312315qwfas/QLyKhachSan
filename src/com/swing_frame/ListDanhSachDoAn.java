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
public class ListDanhSachDoAn extends javax.swing.JInternalFrame {

    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
    static String te;
    public  ImageIcon Format= null;
    public ListDanhSachDoAn() {
        initComponents();
        remove_title_bar();
        connection = new MySqlConnectionUtil().getConnection();
        Addichage();
    }
    public static String re(){
        return te;
    }
    public void clear(){
       
       
    }
    public void Addichage(){
        try{
            String request = "select MaDV as 'ID', TenDV as 'Name', Gia as 'Price', MoTa as 'Description' from DichVu";
            ps = connection.prepareStatement(request);
            rs=ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            System.out.println("Exception"+ e);
        }
    }
//    public  void Deplace(){
//        try{
//            int row = Table.getSelectedRow();
//            this.test = (Table.getModel().getValueAt(row,0).toString());
//            String request = "select * from DichVu where MaDV = "+test+" ";
//            ps=connection.prepareStatement(request);
//            rs= ps.executeQuery();
//            if(rs.next()){
//                String t1= rs.getString("MaDV");
//                txtId.setText(t1);
//                String t2= rs.getString("TenDV");
//                txtName.setText(t2);
//                String t3= rs.getString("Gia");
//                txtAddress.setText(t3);
//                String t4= rs.getString("MoTa");
//                txtDate.setText(t4);
//                
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated
//    public void search(){
//       
//        try{
//             String request = "select * from DichVu where TenDV like ?";
//            ps = connection.prepareStatement(request);
//            ps.setString(1,"%"+txtsearch.getText()+"%");
//            rs= ps.executeQuery();
//            Table.setModel(DbUtils.resultSetToTableModel(rs));
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        
//       
//        try{
//             String request = "select * from DichVu where MaDV=?";
//            ps = connection.prepareStatement(request);
//            ps.setString(1, txtsearch.getText());
//            rs= ps.executeQuery();
//            
//            if(rs.next()){
//               String t1= rs.getString("MaDV");
//                txtId.setText(t1);
//                String t2= rs.getString("TenDV");
//                txtName.setText(t2);
//                String t3= rs.getString("Gia");
//                txtAddress.setText(t3);
//                String t4= rs.getString("MoTa");
//                txtDate.setText(t4);
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        try{
//             String request = "select * from DichVu where TenDV like ?";
//            ps = connection.prepareStatement(request);
//            ps.setString(1, "%"+txtsearch.getText()+"%");
//            rs= ps.executeQuery();
//            
//            if(rs.next()){
//                 String t1= rs.getString("MaDV");
//                txtId.setText(t1);
//                String t2= rs.getString("TenDV");
//                txtName.setText(t2);
//                String t3= rs.getString("Gia");
//                txtAddress.setText(t3);
//                String t4= rs.getString("MoTa");
//                txtDate.setText(t4);
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        
//    }
  
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Addichage();
        clear();
      
    }//GEN-LAST:event_formMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        this.Table.getTableHeader().setResizingAllowed(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void TableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseReleased
;
      
//        Deplace();
    }//GEN-LAST:event_TableMouseReleased

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
//        Deplace();
    }//GEN-LAST:event_TableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
