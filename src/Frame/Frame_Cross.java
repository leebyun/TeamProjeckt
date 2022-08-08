package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import health.Exercise;
import user.Userinfo;

public class Frame_Cross extends JFrame{

   public Frame_Cross(Userinfo u) {
      
      JFrame f = new JFrame();
      
      Exercise ex = new Exercise();
      List<Exercise> exlist = ex.ExList_stretch();

      
      f.setBounds(500,100,600,800);
      f.getContentPane().setBackground(Color.white);
      f.setLayout(null);
      f.setLocationRelativeTo(null);
      f.setTitle("메인");
      
      
      //Image 
      ImageIcon img=new ImageIcon("secondimage.png");
      
      JLabel label=new JLabel(img);
      label.setBounds(40,570,500,100);
      f.add(label);
      
      //운동하기
      ImageIcon exerciseImg=new ImageIcon("운동하기.png");
      ImageIcon exerciseImg2=new ImageIcon("B운동하기.png");
      
      JButton exercise = new JButton(exerciseImg); //340*102
      exercise.setRolloverIcon(exerciseImg2);
      
      exercise.setBorderPainted(false); //테두리 지우기
      exercise.setContentAreaFilled(false); //안에 내용지우
      exercise.setFocusPainted(false); //입력됐을 때 모양 없애기
      exercise.setBorder(null);
      
      //구매하기
      ImageIcon purchaseImg=new ImageIcon("쇼핑하기.png");
      ImageIcon purchaseImg2=new ImageIcon("B쇼핑하기.png");
      
      JButton purchase = new JButton(purchaseImg);
      purchase.setRolloverIcon(purchaseImg2);
      purchase.setBorderPainted(false);
      purchase.setContentAreaFilled(false);
      purchase.setFocusPainted(false);
      purchase.setBorder(null);
      
      //스트레칭
      ImageIcon stretchImg=new ImageIcon("스트레칭.png"); //340*103
      ImageIcon stretchImg2=new ImageIcon("B스트레칭.png");
      
      JButton stretch = new JButton(stretchImg);
      stretch.setRolloverIcon(stretchImg2);
      
      stretch.setBorderPainted(false);
      stretch.setContentAreaFilled(false);
      stretch.setFocusPainted(false);
      stretch.setBorder(null);
      
      stretch.setBounds(120,100,340,102);
      exercise.setBounds(120,250,340,102);
      purchase.setBounds(120,400,340,102);
      
      
      f.add(exercise);
      f.add(purchase);
      f.add(stretch);
      
      
      f.setVisible(true);
      
      
      exercise.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(u.getUserGender().equals("M")) {
            Frame_Base.getInstance(new Frame_main_male(u));
            f.dispose();
            }else {
               Frame_Base.getInstance(new Frame_main_female(u));
               f.dispose();
            }
         }
      });
      
      
      purchase.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_Category(u));
         }
      });
      
      stretch.addActionListener(new ActionListener() {
             @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
            Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(0),7));
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
           Frame_Base.getInstance(new Frame_login());
           
        }
     });
   }
}