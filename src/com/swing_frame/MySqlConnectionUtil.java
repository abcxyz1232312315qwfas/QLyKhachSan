/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swing_frame;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import sun.applet.Main;

public class MySqlConnectionUtil {
    String filename = null;
    public static String path;
    private Connection connection;

    public MySqlConnectionUtil() {
    }
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/baitaplon", "root", "123456");
        } catch (Exception e) {
        }
        return null;
    }

    public void thucThiCauLenhSQL(String sql) {
        Connection connect = getConnection();
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet chonDuLieuTuDTB(String sql) {
        try {
            Connection connect = getConnection();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public void filen(){
        try{
        JFileChooser chooser= new JFileChooser();
        chooser.setDialogTitle("Choose one image png");
        chooser.setApproveButtonText("Insert image");
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        this.path=(filename);
        }catch(Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Choose picture");
        }
    }
      
    public static String getpath(){
        return path;
    }
}
    

