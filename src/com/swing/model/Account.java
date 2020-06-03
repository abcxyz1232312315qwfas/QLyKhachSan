/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swing.model;

/**
 *
 * @author ADMIN
 */
public class Account {
    private String tenTK;
    private String password;
    private String ten;
    private String email;
    private String maQuyen;

    public Account() {
    }

    public Account(String tenTK, String password, String ten, String email, String maQuyen) {
        this.tenTK = tenTK;
        this.password = password;
        this.ten = ten;
        this.email = email;
        this.maQuyen = maQuyen;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    @Override
    public String toString() {
        return "Account{" + "tenTK=" + tenTK + ", password=" + password + ", ten=" + ten + ", email=" + email + ", maQuyen=" + maQuyen + '}';
    }
    
    
}
