/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swing_frame;

import com.swing.model.Phong;
import com.swing.repository.Icrud;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author ADMIN
 */
public class FormHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormHome
     */
    public FormHome() {
        initComponents();
        taoListbutton();
//        btntest.setHorizontalTextPosition( SwingConstants.BOTTOM );
    }

    public void taoListbutton() {
        List<Phong> roomList = new Icrud().findAll();
        for (Phong item : roomList) {
            {
                ImageIcon icon = new ImageIcon("C:\\Household-Heating-Room-icon.png");
                JButton button = new JButton(icon);
                setLayout(new FlowLayout());

                button.setSize(150, 150);
                button.setText(item.getTenp());
                button.setFont(new Font("Arial", Font.BOLD, 12));
                button.setHorizontalAlignment(SwingConstants.CENTER);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                button.setVerticalAlignment((int) TOP_ALIGNMENT);
                button.setVerticalTextPosition((int) BOTTOM_ALIGNMENT);

                if (item.getTinhTrang().equals("Trống")) {
                    button.setBackground(Color.white);
                    button.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            FormDatPhongPlus formDatPhong = new FormDatPhongPlus();
                            formDatPhong.setVisible(true);
                        }
                    });
                } else if (item.getTinhTrang().equals("Phòng bận")) {
                    button.setBackground(Color.red);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            FormThanhToanPlus formThanhToan = new FormThanhToanPlus(item.getMaPhong());
                            formThanhToan.setVisible(true);
                        }
                    });
                } else if (item.getTinhTrang().equals("Đang dọn")) {
                    button.setBackground(Color.GREEN);
                    button.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            FormDonPhongPlus formDonPhong = new FormDonPhongPlus(item.getTenp());
                            formDonPhong.setVisible(true);
                            
                        }
                    });
                } else {
                    button.setBackground(Color.BLACK);
                }
                this.add(button);
            }
        }

//        ImageIcon icon = new ImageIcon("C:\\Household-Heating-Room-icon.png");
//        JButton button = new JButton(icon);
//        setLayout(new FlowLayout());
//        button.setSize(150, 160);
//
//        String item = "Đang dọn";
//        String a = "<html>Phong 22</html>";
//        button.setText(a);
//        button.setFont(new Font("Arial", Font.BOLD, 12));
//        button.setHorizontalAlignment(SwingConstants.CENTER);
//        button.setHorizontalTextPosition(SwingConstants.CENTER);
//        button.setVerticalAlignment((int) TOP_ALIGNMENT);
//        button.setVerticalTextPosition((int) BOTTOM_ALIGNMENT);
//        if (item == "Trống") {
//            button.setBackground(Color.white);
//            button.addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    InsertUser insertUser = new InsertUser();
//                    insertUser.setVisible(true);
//                }
//            });
//        } else if (item == "Phòng bận") {
//            button.setBackground(Color.red);
//            button.addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    InsertUser insertUser = new InsertUser();
//                    insertUser.setVisible(true);
//                }
//            });
//        } else if (item == "Đang dọn") {
//            button.setBackground(Color.GREEN);
//            button.addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    Test insertUser = new Test();
//                    insertUser.setVisible(true);
//                }
//            });
//        }
//
//        this.add(button);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
