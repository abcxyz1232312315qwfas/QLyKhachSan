/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.swing.model.Account;
import com.swing.repository.Icrud;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ADMIN
 */
public class Security {
//     public static void main(String[] args)  {
//  
//         System.out.println(new Security().encode("admin"));
//         System.out.println(new Security().decryption("admin","$2a$12$oa.5BKQlO9tMpNlbYog70OFvRL9E1Gy/JQpyj05sClIojze9fGLUe"));
//    }
    public boolean decryption(String password,String encode){
        if(BCrypt.checkpw(password, encode))
            return true;
        return false;
    }
    public String encode(String password){
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return hash;
    }
    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException {
   
    
  }
}
