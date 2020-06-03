/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swing.repository;

import com.swing.model.Account;
import com.swing.model.Other;
import com.swing.model.Phong;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface Crud {
    public List<Phong> findAll();
    List<Phong> findAllOfUser();
    Account findByUserNameAndPassword();
    public String checkQuyen(String userName, String password);
    Other findByOther(String username);
}
