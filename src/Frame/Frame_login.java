package Frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import user.Userinfo;

public class Frame_login extends JFrame{
   
   
   public Frame_login(){
      
      JFrame f = new JFrame("로그인");
      
      f.setBounds(500,100,600,800);
      f.getContentPane().setBackground(Color.white);
      f.setLayout(null);
      f.setLocationRelativeTo(null);
      
      Font font=new Font("맑은고딕", Font.BOLD, 18);
      
      //Image
      ImageIcon img=new ImageIcon("firstimage.png"); 
      
      JLabel label=new JLabel(img);    
         label.setBounds(40, 10, 500, 550);
         f.add(label);
      
      
      JLabel b2= new JLabel("아이디 :");
      b2.setFont(font);
      f.add(b2);
      JLabel b3= new JLabel("비밀번호 :");
      b3.setFont(font);
      f.add(b3);
      TextField b4 = new TextField();
      f.add(b4);
      TextField b5 = new TextField();
      f.add(b5);
      b5.setEchoChar('*');//암호화
      b4.setFocusTraversalKeysEnabled(false);
      b4.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
         if(e.getKeyCode()== KeyEvent.VK_TAB) {
            b5.requestFocus();
         }
      }
      });
      
      
      //Login button
      ImageIcon loginImg=new ImageIcon("login.jpg"); 
      ImageIcon loginImg2=new ImageIcon("blogin.jpg");

      JButton b6 = new JButton(loginImg);
      b6.setRolloverIcon(loginImg2);
      
      JRootPane rootp = rootPane.getRootPane();
      rootp.setDefaultButton(b6);
         b6.setBorderPainted(false);   //테두리지우기
         b6.setContentAreaFilled(false);   //안의 내용지우기
         b6.setFocusPainted(false);       //입력됐을 때 모양 없애기
         b6.setBorder(null);
         f.add(b6);
         

      //join button
      ImageIcon joinImg=new ImageIcon("join.jpg");  
      ImageIcon joinImg2=new ImageIcon("bjoin.jpg");
      
      JButton register = new JButton(joinImg);
      register.setRolloverIcon(joinImg2);
      
         register.setBorderPainted(false);   //테두리지우기
         register.setContentAreaFilled(false);   //안의 내용지우기
         register.setFocusPainted(false);       //입력됐을 때 모양 없애기
         register.setBorder(null);   
         f.add(register);
      
      
      
      b2.setBounds(50, 600, 100, 40);
      b3.setBounds(50, 650, 100, 40);
      b4.setBounds(180, 600, 200, 40);
      b5.setBounds(180, 650, 200, 40);
      b6.setBounds(410, 600, 108, 40);
      register.setBounds(410, 650, 108, 40);
      
      //벡터는 이제 잘 안 쓰는 객체
      //
      
      List<Component> order = new ArrayList<>();
      order.add(b4);
      order.add(b5);
      order.add(b6);
      order.add(register);
      
      
      
      f.setSize(600, 800);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setTitle("로그인 화면 ");
      f.setVisible(true);
      
      
      
      b6.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e2) {//로그인 할때 
            Userinfo user = new Userinfo();
            
            Map<String,Userinfo> map = user.userlist();
            
            
               
               if(!map.containsKey(b4.getText())){
                  JOptionPane.showMessageDialog(null, "입력하신 아이디가 존재하지 않습니다.");
               }else{
                  if(map.get(b4.getText()).getUserPwd().equals(b5.getText())) {
                     JOptionPane.showMessageDialog(null, "로그인이 되었습니다.");
                     
                     Frame_Base.getInstance(new Frame_Cross(map.get(b4.getText())));
                     f.dispose();
                  }else {
                     JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
                  }
               } 
               
            
         }
      });// 버튼 b6
      
      
      register.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            f.dispose();
            Frame_joinmember fj = new Frame_joinmember();      
            }
      });
      
      
      
   }
   
   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      
      if(key==KeyEvent.VK_ENTER) {
         Toolkit.getDefaultToolkit().beep();
      
      }
   }
   

}