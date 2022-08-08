package Frame;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import user.Userinfo;

public class Frame_main_male extends JFrame{
   
	   private JPanel contentPane;
	    Timer tm1,tm2,tm3;
	    // the panels default height = 60
	       Integer pl1 = 60,pl2 = 60,pl3 = 60;

   public Frame_main_male(Userinfo u) {
      
      JFrame f = new JFrame("남성 운동");
      
      f.setBounds(500,100,600,800);
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        
        
        ImageIcon Firstimg=new ImageIcon("남자처음.png");
        JLabel background=new JLabel(Firstimg);
        background.setBounds(150,100,301,456);


        JButton Chest = new JButton("");
        JButton Back = new JButton("");
        JButton Leg = new JButton("");

        Chest.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {

            ImageIcon Chestimg=new ImageIcon("남자가슴.png");
            JLabel background1=new JLabel(Chestimg);
             background1.setBounds(150,100,301,456); 
             f.remove(background);
                f.add(background1);
                
                 f.validate();
                 f.invalidate();
                 f.repaint();
         }
         
         public void mouseExited(MouseEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_main_male(u));
            }         
         
        });
        
        Back.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            f.remove(background);
            f.validate();
            f.invalidate();
              
      
            ImageIcon Backimg=new ImageIcon("남자등.png");
            JLabel background=new JLabel(Backimg);
            background.setBounds(150,100,301,456);
               
            f.add(background);
            
                 f.revalidate();
                 f.repaint();

         }
         public void mouseExited(MouseEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_main_male(u));
            }      
        });
           
        Leg.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            f.remove(background);
            f.validate();
            f.invalidate();
              
      
            ImageIcon Legimg=new ImageIcon("남자하체.png");
            JLabel background=new JLabel(Legimg);
            background.setBounds(150,100,301,456);
               
            f.add(background);
            
                 f.revalidate();
                 f.repaint();

         }
         public void mouseExited(MouseEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_main_male(u));
            }      
        });
        
        
        Chest.setBounds(340, 165, 80, 40);
        Back.setBounds(330, 265, 80, 40); 
        Leg.setBounds(360, 400, 80, 40); 
 
        
        Chest.setBorderPainted(false);
        Chest.setContentAreaFilled(false);
        Chest.setFocusPainted(false);
        Chest.setOpaque(false);
        
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.setFocusPainted(false);
        Back.setOpaque(false);
        
        Leg.setBorderPainted(false);
        Leg.setContentAreaFilled(false);
        Leg.setFocusPainted(false);
        Leg.setOpaque(false);
        
        f.add(Chest);
        f.add(Back);
        f.add(Leg);
 
        
        f.add(background);
        
       
    

        
    f.setSize(600,800);
   f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setVisible(true);        
   
   Chest.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         Frame_Base.getInstance(new Frame_Chest(u)); 
         
         f.dispose();
      }
   });
   
   Back.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         Frame_Base.getInstance(new Frame_back(u)); 
         
         f.dispose();
      }
   });
   
   Leg.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         Frame_Base.getInstance(new Frame_leg(u)); 
         
         f.dispose();
      }
   });
   
    
    
    ImageIcon backBtn1 = new ImageIcon("back1.jpg");
    ImageIcon backBtn2 = new ImageIcon("back2.jpg");
    
    JButton btnBack = new JButton(backBtn1);
    btnBack.setRolloverIcon(backBtn2);
    
    btnBack.setSize(45, 45);
    btnBack.setLocation(5, 700);
    btnBack.setBorderPainted(false);
    btnBack.setContentAreaFilled(false);
    btnBack.setFocusPainted(false);
    f.add(btnBack);
   
   btnBack.addActionListener(new ActionListener() {   
      @Override
      public void actionPerformed(ActionEvent e) {

         f.dispose();
         Frame_Base.getInstance(new Frame_Cross(u));
         
      }
   });
    
   
   
   }
}