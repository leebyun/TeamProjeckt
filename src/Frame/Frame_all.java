package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;

import health.Exercise;
import javaswingdev.GradientDropdownMenu;
import user.Userinfo;

public class Frame_all extends JFrame{
   
   Exercise ex = new Exercise();
    private JPanel contentPane;
    Timer tm1,tm2,tm3;
    // the panels default height = 60
       Integer pl1 = 60,pl2 = 60,pl3 = 60;
       
   public Frame_all(Userinfo u) {
      List<Exercise> exlist = ex.ExList_all();
      JFrame f = new JFrame("전신 운동");
      
      
      f.setBounds(500,100,600,800);
      f.getContentPane().setBackground(Color.white);
      f.setLayout(null);
      f.setLocationRelativeTo(null);
        
       GradientDropdownMenu menu = new GradientDropdownMenu();
      menu.addItem("Home");
      menu.addItem("Features", "Ticker New", "Featured Styles", "Content Blocks");
      menu.applay(this);
      f.add(menu);
      
      


    //Image
      ImageIcon img=new ImageIcon("back1.jpg"); 
      ImageIcon img2=new ImageIcon("back2.jpg"); 
         
      JLabel label=new JLabel(img);
      f.add(label);
      
      JButton jback = new JButton(img);
      jback.setBounds(10, 710, 45, 45);
      jback.setRolloverIcon(img2);
      jback.setBorderPainted(false);
      jback.setContentAreaFilled(false);
      jback.setFocusPainted(false);
     
      f.add(jback);
      
      
      ImageIcon icn_1 = new ImageIcon((exlist.get(0)).ExName+1+".jpg");
      ImageIcon icn_2 = new ImageIcon((exlist.get(1)).ExName+1+".jpg");
      ImageIcon icn_3 = new ImageIcon((exlist.get(2)).ExName+1+".jpg");
      
      ImageIcon icn_11 = new ImageIcon((exlist.get(0)).ExName+2+".jpg");
      ImageIcon icn_22 = new ImageIcon((exlist.get(1)).ExName+2+".jpg");
      ImageIcon icn_33 = new ImageIcon((exlist.get(2)).ExName+2+".jpg");
      
      ImageIcon icn_111 = new ImageIcon((exlist.get(0)).ExName+3+".png");
      ImageIcon icn_222 = new ImageIcon((exlist.get(1)).ExName+3+".png");
      ImageIcon icn_333 = new ImageIcon((exlist.get(2)).ExName+3+".png");
      
      JLabel jlimg1 = new JLabel(icn_111);
      JLabel jlimg2 = new JLabel(icn_222);
      JLabel jlimg3 = new JLabel(icn_333);

      
      ImageIcon backBtn1 = new ImageIcon("back1.jpg");
      ImageIcon backBtn2 = new ImageIcon("back2.jpg");
      
      JButton ex1 = new JButton(icn_1);
      JButton ex2 = new JButton(icn_2);
      JButton ex3 = new JButton(icn_3);
      
      ex1.setRolloverIcon(icn_11);
      ex2.setRolloverIcon(icn_22);
      ex3.setRolloverIcon(icn_33);
      
      ex1.setBorderPainted(false);
      ex1.setContentAreaFilled(false);
      ex1.setFocusPainted(false);
      ex1.setOpaque(false);
      
      ex2.setBorderPainted(false);
      ex2.setContentAreaFilled(false);
      ex2.setFocusPainted(false);
      ex2.setOpaque(false);
      
      ex3.setBorderPainted(false);
      ex3.setContentAreaFilled(false);
      ex3.setFocusPainted(false);
      ex3.setOpaque(false);
      
      
      f.add(ex1);
      ex1.setBounds(310,170,230,65);
      f.add(ex2);
      ex2.setBounds(310,370,230,65);
      f.add(ex3);
      ex3.setBounds(310,570,230,65);
      
      f.add(jlimg1);
      f.add(jlimg2);
      f.add(jlimg3);
      jlimg1.setBounds(30,85,250,250);
      jlimg2.setBounds(30,300,250,250);
      jlimg3.setBounds(30,490,250,250);
      
       f.setSize(600,800);
       f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       f.setVisible(true);
       
       jback.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_main_female(u));     
         }
      });

      ex1.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(0),6));
         }
      });
      
      ex2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
           f.dispose();
            Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(1),6));
         }
      });
      
      ex3.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(2),6));
         }
      });
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setBounds(100, 100, 550, 435);
     contentPane = new JPanel();
     contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
     setContentPane(contentPane);
     contentPane.setLayout(null);
     
     JPanel panel = new JPanel();
     panel.setBounds(490, 11, 85, 40);
     contentPane.add(panel);
     panel.setLayout(null);
     
     ImageIcon icn1 = new ImageIcon("메뉴.jpg");
     JButton btnNewButton = new JButton(icn1);
     
     btnNewButton.setBorderPainted(false);
     btnNewButton.setContentAreaFilled(false);
     btnNewButton.setFocusPainted(false);
     btnNewButton.setOpaque(false);
     btnNewButton.setBackground(Color.ORANGE);
     btnNewButton.setBounds(0, 0, 85, 40);
     panel.add(btnNewButton);
     
     ImageIcon icn2 = new ImageIcon("홈.jpg");
     JButton button = new JButton(icn2);
     button.setBorderPainted(false);
     button.setContentAreaFilled(false);
     button.setFocusPainted(false);
     button.setOpaque(false);
     button.setBackground(Color.ORANGE);
     button.setBounds(0, 40, 85, 40);
     panel.add(button);
     
     ImageIcon icn3 = new ImageIcon("쇼핑.jpg");
     JButton button_1 = new JButton(icn3);
     
     button_1.setBorderPainted(false);
     button_1.setContentAreaFilled(false);
     button_1.setFocusPainted(false);
     button_1.setOpaque(false);
     button_1.setBackground(Color.ORANGE);
     button_1.setBounds(0, 80, 85,40);
     panel.add(button_1);
     
     ImageIcon icn4 = new ImageIcon("스트레칭.jpg");
     JButton button_2 = new JButton(icn4);
     
     button_2.setBorderPainted(false);
     button_2.setContentAreaFilled(false);
     button_2.setFocusPainted(false);
     button_2.setOpaque(false);
     button_2.setBackground(Color.ORANGE);
     button_2.setBounds(0, 120, 85, 40);
     panel.add(button_2);
     
     
     
     JPanel panel_1 = new JPanel();
     panel_1.setLayout(null);
     panel_1.setBounds(160, 11, 85, 40);
     contentPane.add(panel_1);
     

     
    
     JPanel panel_2 = new JPanel();
     panel_2.setLayout(null);
     panel_2.setBounds(42, 11, 85, 40);
     contentPane.add(panel_2);
     

    f.add(panel);
     
     tm1 = new Timer(20, new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
       
       // 300 the maximum height
       if(pl1 > 160)
       {
        tm1.stop();
       }
       else{
        panel.setSize(panel.getWidth(),pl1);
        pl1 += 20;
       }
       
      }
     });
     
         tm2 = new Timer(20, new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
       
       if(pl2 > 240)
       {
        tm2.stop();
       }
       else{
        panel_1.setSize(panel_1.getWidth(),pl2);
        pl2 += 20;
       }
       
      }
     });
         
         tm3 = new Timer(20, new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
       
       if(pl3 > 240)
       {
        tm3.stop();
       }
       else{
        panel_2.setSize(panel_2.getWidth(),pl3);
        pl3 += 20;
       }
       
      }
     });
     
     btnNewButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent arg0) {
       // set the panels to the dafault height
       panel_1.setSize(panel_1.getWidth(), pl2);
       panel_2.setSize(panel_2.getWidth(), pl3);
       tm1.start();
      }
      @Override
      public void mouseExited(MouseEvent e) {
       
       tm1.stop();
       pl1 = 60;
      }
     });
     
     button.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         f.dispose();
         Frame_Base.getInstance(new Frame_Cross(u));
      }
   });
     
     button_1.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         f.dispose();
         Frame_Base.getInstance(new Frame_Category(u));
      }
   });
     
     button_2.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
    	  List<Exercise> exlist = ex.ExList_stretch();
          f.dispose();
          Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(0),7));
            
      }
   });

   }
   
}