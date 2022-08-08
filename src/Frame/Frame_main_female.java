package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.Userinfo;

public class Frame_main_female extends JFrame{
	   private JPanel contentPane;
	    Timer tm1,tm2,tm3;
	    // the panels default height = 60
	       Integer pl1 = 60,pl2 = 60,pl3 = 60;
   
   public Frame_main_female(Userinfo u) {
      
      JFrame f = new JFrame("여성 운동");
      
      f.setBounds(500,100,600,800);
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        
        ImageIcon Firstimg=new ImageIcon("여자처음.png");
        JLabel background=new JLabel(Firstimg);
        background.setBounds(150,100,301,456);


        JButton btnUp = new JButton("");
        JButton btnDown = new JButton("");
        JButton btnAll = new JButton("");
        JButton btnBack = new JButton("뒤로가기");
        
        btnUp.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {

            ImageIcon Upimg=new ImageIcon("여자상체.png");
            JLabel background1=new JLabel(Upimg);
             background1.setBounds(150,100,301,456); 
             f.remove(background);
                f.add(background1);
                
                 f.validate();
                 f.invalidate();
                 f.repaint();
         }
         
         public void mouseExited(MouseEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_main_female(u));
            }         
         
        });
        
        btnDown.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            f.remove(background);
            f.validate();
            f.invalidate();
              
      
            ImageIcon Downimg=new ImageIcon("여자하체.png");
            JLabel background=new JLabel(Downimg);
            background.setBounds(150,100,301,456);
               
            f.add(background);
            
                 f.revalidate();
                 f.repaint();

         }
         public void mouseExited(MouseEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_main_female(u));
            }      
        });
           
        btnAll.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            f.remove(background);
            f.validate();
            f.invalidate();
              
      
            ImageIcon Allimg=new ImageIcon("여자전신.png");
            JLabel background=new JLabel(Allimg);
            background.setBounds(150,100,301,456);
               
            f.add(background);
            
                 f.revalidate();
                 f.repaint();

         }
         public void mouseExited(MouseEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_main_female(u));
            }      
        });
        
        
        btnUp.setBounds(330, 120, 80, 40);
        btnDown.setBounds(340, 285, 80, 40); 
        btnAll.setBounds(350, 440, 80, 40); 

        
        btnUp.setBorderPainted(false);
        btnUp.setContentAreaFilled(false);
        btnUp.setFocusPainted(false);
        btnUp.setOpaque(false);
        
        btnDown.setBorderPainted(false);
        btnDown.setContentAreaFilled(false);
        btnDown.setFocusPainted(false);
        btnDown.setOpaque(false);
        
        btnAll.setBorderPainted(false);
        btnAll.setContentAreaFilled(false);
        btnAll.setFocusPainted(false);
        btnAll.setOpaque(false);
    
        f.add(btnUp);
        f.add(btnDown);
        f.add(btnAll);
        f.add(background);
        
    f.setSize(600,800);
   f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setVisible(true);  
   
    
    btnUp.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         Frame_Base.getInstance(new Frame_up(u)); 
         f.dispose();
      }
   });
    
    
    btnDown.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         Frame_Base.getInstance(new Frame_down(u)); 
         f.dispose();
      }
   });
    
    
    btnAll.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         Frame_Base.getInstance(new Frame_all(u)); 
         f.dispose();
      }
   });
    

    ImageIcon backBtn1 = new ImageIcon("back1.jpg");
    ImageIcon backBtn2 = new ImageIcon("back2.jpg");
    
    JButton btnBack1 = new JButton(backBtn1);
    btnBack1.setRolloverIcon(backBtn2);
    
    btnBack1.setSize(45, 45);
    btnBack1.setLocation(5, 700);
    btnBack1.setBorderPainted(false);
    btnBack1.setContentAreaFilled(false);
    btnBack1.setFocusPainted(false);

    
    btnBack1.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         
         Frame_Base.getInstance(new Frame_Cross(u));
         f.dispose();
      }
   });
 
    f.add(btnBack1);
    
    
   }
}