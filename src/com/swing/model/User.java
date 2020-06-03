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
public class User {
    private int id_user;
    private String name;


    public User(int id_user, String name) {
        this.id_user = id_user;
        this.name = name;
    }

    public User() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    @Override
    public String toString() {
        return  getName();
    }

    
    
}
