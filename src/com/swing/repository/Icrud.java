/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swing.repository;
import com.swing.model.Phong;
import com.swing.model.Account;
import com.swing.model.Other;
import com.swing_frame.MySqlConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.Security;

/**
 *
 * @author ADMIN
 */
public class Icrud implements Crud{
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement ps = null;
    private Security serSecurity;
    public Icrud() {
        connection = new MySqlConnectionUtil().getConnection();
        serSecurity = new Security();
    }
    @Override
    public List<Phong> findAll(){
        List<Phong> list = new ArrayList<>();
        resultSet = new MySqlConnectionUtil().chonDuLieuTuDTB("select * from Phong");
        try {
            while (resultSet.next()) {
                Phong phong = new Phong();
                phong.setMaPhong(resultSet.getString(1));
                phong.setTenp(resultSet.getString(2));
                phong.setTinhTrang(resultSet.getString(3));
                phong.setMaLP(resultSet.getString(4));
                
                list.add(phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Icrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public List<Phong> findAllOfUser(){
        List<Phong> list = new ArrayList<>();
        resultSet = new MySqlConnectionUtil().chonDuLieuTuDTB("select * from Phong");
        try {
            while (resultSet.next()) {
                Phong phong = new Phong();
                phong.setMaPhong(resultSet.getString(1));
                phong.setTenp(resultSet.getString(2));
                phong.setTinhTrang(resultSet.getString(3));
                phong.setMaLP(resultSet.getString(4));
                
                list.add(phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Icrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Account findByUserNameAndPassword(){
        List<Account> list = new ArrayList<>();
        Account account = new Account();
        resultSet = new MySqlConnectionUtil().chonDuLieuTuDTB("select * from taikhoan where username= 'admin'");
        try {
            while (resultSet.next()) {
              
                account.setTenTK(resultSet.getString(1));
                account.setPassword(resultSet.getString(2));
                list.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Icrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
    @Override
   public String checkQuyen(String userName, String password){
       String sql ="select MaQuyen from TaiKhoan where username= '"+userName+"' and password= '"+password+"' ";
       String role= null;
        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()){
               role= resultSet.getString(1);
            }
            return role;
        } catch (SQLException ex) {
            Logger.getLogger(Icrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   @Override
   public Other findByOther(String username){
       Other other = new Other();
        String sql= "select username,name,email,phone,TenQuyen from user_table,quyen,TaiKhoan where TaiKhoan.id_user = user_table.id_user " +
"                                                                           AND TaiKhoan.MaQuyen = Quyen.MaQuyen " +
"                                                                            AND TaiKhoan.username= '"+username+"';";
        resultSet = new MySqlConnectionUtil().chonDuLieuTuDTB(sql);
        try {
            while (resultSet.next()) {
     
                other.setTenTK(resultSet.getString(1));
                other.setTen(resultSet.getString(2));
                other.setEmail(resultSet.getString(3));
                other.setPhone(resultSet.getString(4));
                other.setTenQuyen(resultSet.getString(5));
        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Icrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return other;
    }
   
    public static void main(String[] args) {
        Date date= new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // java.util.Date; GIVEN
//        String ngaydat= String.
        String ngaydat="01/14/2012 09:29:58";
        String ngayTra= "01/15/2012 10:31:48";       
          SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(ngaydat);
            d2 = format.parse(ngayTra);

            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            long result= diffDays*24+diffHours*1;
           
            System.out.println(result);
                
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   
}
