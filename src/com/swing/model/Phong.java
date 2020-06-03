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
public class Phong {
    private String maPhong;
    private String tenp;
    private String tinhTrang;
    private String maLP;

    public Phong(String maPhong, String tenp) {
        this.maPhong = maPhong;
        this.tenp = tenp;
    }

    public Phong() {
        
    }
    

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenp() {
        return tenp;
    }

    public void setTenp(String tenp) {
        this.tenp = tenp;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaLP() {
        return maLP;
    }

    public void setMaLP(String maLP) {
        this.maLP = maLP;
    }

    @Override
    public String toString() {
        return getTenp();
    }
    
    
}
