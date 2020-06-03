/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swing_frame;

import com.swing.model.Role;
import com.swing.model.User;
import com.swing.repository.Icrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ADMIN
 */
public class Test extends javax.swing.JFrame {

    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    /**
     * Creates new form Test
     */
    
    public Test() {
        initComponents();
        connection = new MySqlConnectionUtil().getConnection();
        loadCBB();
        getCBB();
          Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // java.util.Date; GIVEN
        txtDateModified.setDate(date);
    }
        public long TinhGio(String ngaydat, String ngayTra) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date d1 = null;
        Date d2 = null;
        long result = 0;
        try {
            d1 = format.parse(ngaydat);
            d2 = format.parse(ngayTra);

            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            result = diffDays * 24 + diffHours * 1;

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbx = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtDateModified = new com.toedter.calendar.JDateChooser();
        txtDateModified1 = new com.toedter.calendar.JDateChooser();
        txtDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cbx.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxItemStateChanged(evt);
            }
        });
        cbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDateModified.setDateFormatString("yyyy/MM/dd");
        txtDateModified.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtDateModified.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDateModifiedMouseClicked(evt);
            }
        });
        txtDateModified.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtDateModifiedInputMethodTextChanged(evt);
            }
        });
        txtDateModified.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDateModifiedKeyPressed(evt);
            }
        });

        txtDateModified1.setDateFormatString("yyyy/MM/dd");
        txtDateModified1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtDateModified1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDateModified1MouseClicked(evt);
            }
        });
        txtDateModified1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtDateModified1InputMethodTextChanged(evt);
            }
        });
        txtDateModified1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDateModified1KeyPressed(evt);
            }
        });

        txtDate.setDateFormatString("yyyy/MM/dd");
        txtDate.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtDateModified, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton1)
                        .addGap(0, 217, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtDateModified1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(txtDateModified, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDateModified1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public String getMaLP(String MaP){
        String result= null;
        String request= "select * from Phong where MaPhong = '"+MaP+"'";
        rs = new MySqlConnectionUtil().chonDuLieuTuDTB(request);
        try {
            while (rs.next()) {
                result=rs.getString("MaLP");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormThanhToanPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        txtDateModified.setDate("2020/04/14");

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateNgayDat = dateFormat.format(txtDateModified.getDate());
        String dateNgayThanhToan = dateFormat.format(txtDateModified1.getDate());
        String a = txtDate.getDate().toString();
        long gio = TinhGio(dateNgayDat, dateNgayThanhToan);
        //        double gia = Integer.valueOf(txtDateModified1.getText());
        //        double tien = gia + gia * 0.1 * (gio - 1);
        //
        System.out.println(gio);
        System.out.println(a);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxActionPerformed
        System.out.println(cbx.getModel().getSelectedItem());
    }//GEN-LAST:event_cbxActionPerformed

    private void cbxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxItemStateChanged
        //        this.setTitle(((Role) cbx.getSelectedItem()).getMaQuyen()+"");
    }//GEN-LAST:event_cbxItemStateChanged

    private void txtDateModified1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateModified1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateModified1KeyPressed

    private void txtDateModified1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtDateModified1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateModified1InputMethodTextChanged

    private void txtDateModified1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateModified1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateModified1MouseClicked

    private void txtDateModifiedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateModifiedKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateModifiedKeyPressed

    private void txtDateModifiedInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtDateModifiedInputMethodTextChanged
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // java.util.Date; GIVEN
        txtDateModified.setDate(date);
    }//GEN-LAST:event_txtDateModifiedInputMethodTextChanged

    private void txtDateModifiedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateModifiedMouseClicked
        System.out.println(txtDateModified.getDate().toString());
    }//GEN-LAST:event_txtDateModifiedMouseClicked
    public String getMaDP(String MaP){
        String maDP=null;
        rs = new MySqlConnectionUtil().chonDuLieuTuDTB("select * from DatPhong where MaPhong = '"+MaP+"'");
        try {
            while (rs.next()) {
                maDP=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormThanhToanPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maDP;
    }
    /**
     * @param args the command line arguments
     */
    public void loadCBB() {
      DefaultComboBoxModel model = new DefaultComboBoxModel();
        rs = new MySqlConnectionUtil().chonDuLieuTuDTB("select * from DatPhong");
        try {
            while (rs.next()) {
                Role u = new Role();
                model.addElement(rs.getString(1));
                cbx.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getCBB() {
        System.out.println(cbx.getModel().getSelectedItem());
    }

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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbx;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser txtDate;
    private com.toedter.calendar.JDateChooser txtDateModified;
    private com.toedter.calendar.JDateChooser txtDateModified1;
    // End of variables declaration//GEN-END:variables
}