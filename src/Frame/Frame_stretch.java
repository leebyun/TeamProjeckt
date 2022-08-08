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

public class Frame_stretch extends JFrame{
   
   Exercise ex = new Exercise();
    private JPanel contentPane;
    Timer tm1,tm2,tm3;
    // the panels default height = 60
       Integer pl1 = 60,pl2 = 60,pl3 = 60;
       
   public Frame_stretch(Userinfo u) {
      List<Exercise> exlist = ex.ExList_stretch();
      JFrame f = new JFrame("스트레칭");
      
      
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
      ImageIcon img=new ImageIcon("back2.png"); 
         
      JLabel label=new JLabel(img);
      f.add(label);
      
      JButton jback = new JButton(img);
      jback.setBounds(10, 710, 40, 40);
      f.add(jback);
      
      JButton ex1 = new JButton(exlist.get(0).ExName);
      JButton ex2 = new JButton(exlist.get(1).ExName);
      JButton ex3 = new JButton(exlist.get(2).ExName);
      
      
      f.add(ex1);
      ex1.setBounds(250,200,200,100);
      f.add(ex2);
      ex2.setBounds(250,400,200,100);
      f.add(ex3);
      ex3.setBounds(250,600,200,100);
      
       f.setSize(600,800);
       f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       f.setVisible(true);
       
       jback.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_Cross(u));     
         }
      });

      ex1.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(0),7));
         }
      });
      
      ex2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
           f.dispose();
            Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(1),7));
         }
      });
      
      ex3.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(2),7));
         }
      });
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setBounds(100, 100, 550, 435);
     contentPane = new JPanel();
     contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
     setContentPane(contentPane);
     contentPane.setLayout(null);
     
     JPanel panel = new JPanel();
     panel.setBounds(490, 11, 85, 50);
     contentPane.add(panel);
     panel.setLayout(null);
     JButton btnNewButton = new JButton("이동");
     btnNewButton.setBackground(Color.ORANGE);
     btnNewButton.setBounds(0, 0, 85, 50);
     panel.add(btnNewButton);
     
     JButton button = new JButton("홈");
     button.setBackground(Color.ORANGE);
     button.setBounds(0, 61, 85, 50);
     panel.add(button);
     
     JButton button_1 = new JButton("상품구매");
     button_1.setBackground(Color.ORANGE);
     button_1.setBounds(0, 122, 85,50);
     panel.add(button_1);
     
     JButton button_2 = new JButton("등등");
     button_2.setBackground(Color.ORANGE);
     button_2.setBounds(0, 183, 85, 50);
     panel.add(button_2);
     
     
     
     JPanel panel_1 = new JPanel();
     panel_1.setLayout(null);
     panel_1.setBounds(211, 11, 85, 50);
     contentPane.add(panel_1);
     

     
    
     JPanel panel_2 = new JPanel();
     panel_2.setLayout(null);
     panel_2.setBounds(42, 11, 85, 50);
     contentPane.add(panel_2);
     

    f.add(panel);
     
     tm1 = new Timer(20, new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
       
       // 300 the maximum height
       if(pl1 > 300)
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
       
       if(pl2 > 300)
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
       
       if(pl3 > 300)
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
         f.dispose();
         Frame_Base.getInstance(new Frame_stretch(u));
         
      }
   });

   }
   
}