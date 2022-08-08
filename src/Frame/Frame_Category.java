package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Items.FoodCategory;
import Items.FoodInformation;
import Items.Item;
import Items.ItemCollect;
import user.Userinfo;

public class Frame_Category extends JFrame{
   
   public Frame_Category(Userinfo u) {
      
       JFrame f=new JFrame("상품 카테고리 선택");
        
       f.setBounds(500,100,600,800);
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
       
        //보충제
        
      ImageIcon protein = new ImageIcon("보충제.png");
      JButton btnProtein = new JButton(protein);
      btnProtein.setName("보충제");
      
      btnProtein.setSize(170,160);
      btnProtein.setLocation(82,110);
      btnProtein.setBorderPainted(false);
      btnProtein.setContentAreaFilled(false);
      btnProtein.setFocusPainted(false);      
      f.add(btnProtein);
      
      btnProtein.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            
            ArrayList a1=ItemCollect.getProtein();
            f.dispose();
            Frame_Base.getInstance(new Frame_ItemsInfo(u,a1));
            
         }
      });
      
      //----------------------------------------------------
      //간식
      ImageIcon snack = new ImageIcon("간식.png");
      JButton btnSnack = new JButton(snack);
      btnSnack.setName("간식");

      btnSnack.setSize(160,160);
      btnSnack.setLocation(330,110);
      btnSnack.setBorderPainted(false);
      btnSnack.setContentAreaFilled(false);
      btnSnack.setFocusPainted(false);
      f.add(btnSnack);
      
      btnSnack.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            
            ArrayList a1=ItemCollect.getSnack();
            f.dispose();
            Frame_Base.getInstance(new Frame_ItemsInfo(u,a1));
            
         }
      });
      
      //----------------------------------------------------
      //닭가슴살 
      ImageIcon chicken = new ImageIcon("닭가슴살.png");
      JButton btnChicken = new JButton(chicken);
      btnChicken.setName("닭가슴살");

      btnChicken.setSize(160,160);
      btnChicken.setLocation(82,340);
      btnChicken.setBorderPainted(false);
      btnChicken.setContentAreaFilled(false);
      btnChicken.setFocusPainted(false);
      f.add(btnChicken);
      
      btnChicken.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {

            ArrayList a1=ItemCollect.getChicken();
            f.dispose();
            Frame_Base.getInstance(new Frame_ItemsInfo(u,a1));
            
         }
      });
      
      //----------------------------------------------------
      //샐러드
      
      ImageIcon salad = new ImageIcon("샐러드.png");
      JButton btnSalad = new JButton(salad);
      btnSalad.setName("샐러드");

      btnSalad.setSize(160,160);
      btnSalad.setLocation(330,340);
      btnSalad.setBorderPainted(false);
      btnSalad.setContentAreaFilled(false);
      btnSalad.setFocusPainted(false);
      f.add(btnSalad);
      
      btnSalad.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {

            ArrayList a1=ItemCollect.getSalad();
            f.dispose();
            Frame_Base.getInstance(new Frame_ItemsInfo(u,a1));
            
         }
      });
      
      // 하단
      JPanel bottomSet = new JPanel();

      bottomSet.setBounds(0, 660, 600, 100);
      bottomSet.setLayout(null);
      bottomSet.setBackground(Color.white);

        ImageIcon backBtn = new ImageIcon("back1.jpg");
         ImageIcon backBtn2 = new ImageIcon("back2.jpg");
         JButton btnBack = new JButton(backBtn);
         btnBack.setRolloverIcon(backBtn2);
         
         btnBack.setSize(45, 45);
         btnBack.setLocation(40, 0);
         btnBack.setBorderPainted(false);
         btnBack.setContentAreaFilled(false);
         btnBack.setFocusPainted(false);
         bottomSet.add(btnBack);
         
         btnBack.addActionListener(new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent e) {
               f.dispose();
               Frame_Base.getInstance(new Frame_Cross(u));
               
            }
         });
         
         ImageIcon btnBasker = new ImageIcon("cart1.jpg");
         ImageIcon btnBasker2 = new ImageIcon("cart2.jpg");
         JButton btnToBasker = new JButton(btnBasker);
         btnToBasker.setRolloverIcon(btnBasker2);

         btnToBasker.setSize(60, 60);
         btnToBasker.setLocation(480, 0);
         btnToBasker.setBorderPainted(false);
         btnToBasker.setContentAreaFilled(false);
         btnToBasker.setFocusPainted(false);    
         bottomSet.add(btnToBasker);
         
         btnToBasker.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                 f.dispose();
               Frame_Base.getInstance(new Frame_Basket(u));
               
               
            }
         });
         bottomSet.add(btnToBasker);
         f.add(bottomSet, BorderLayout.SOUTH);
         f.setVisible(true);
         
      }
   }