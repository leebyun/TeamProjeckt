package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import Items.Item;
import Items.MyItem;
import health.Exercise;
import user.Userinfo;

public class Frame_ExerciseInfo extends JFrame{
   
   Frame_ExerciseInfo(Userinfo u, Exercise e, int i){
      JFrame f = new JFrame();
      
      f.setBounds(500,100,600,800);
      f.getContentPane().setBackground(Color.white);
      f.setLayout(null);
      f.setLocationRelativeTo(null);
      
      Exercise ex = new Exercise();
      List<Exercise> exlist = ex.ExList_stretch();
      
      String exName=((Exercise) e).getExName();
      if(exName.contains("여자")) {
         exName=exName.replace("여자","");
      }
      
      JLabel exerciseName=new JLabel(exName);
      exerciseName.setBounds(110,30,400,30);
      exerciseName.setFont(new Font("HY견고딕", Font.BOLD, 30));
      exerciseName.setHorizontalAlignment(JLabel.CENTER);
      f.add(exerciseName);
      
      String str="";
      
      if(((Exercise) e).getExName().equals("랫풀다운")||((Exercise) e).getExName().equals("여자랫풀다운")||((Exercise) e).getExName().equals("시티드로우"))
         str="광배근";
      else if(((Exercise) e).getExName().equals("풀업"))
         str="광배근, 대원근";
      else if(((Exercise) e).getExName().equals("벤치프레스"))
         str="삼두근, 전면삼각근";
      else if(((Exercise) e).getExName().equals("체스트프레스")||((Exercise) e).getExName().equals("여자체스트프레스")||((Exercise) e).getExName().equals("체스트프레스")||((Exercise) e).getExName().equals("팩덱플라이"))
         str="대흉근";
      else if(((Exercise) e).getExName().equals("스쿼트")||((Exercise) e).getExName().equals("여자스쿼트")||((Exercise) e).getExName().equals("레그프레스"))
             str="둔근";
      else if(((Exercise) e).getExName().equals("레그익스텐션"))
         str="대퇴사두근";
      else if(((Exercise) e).getExName().equals("사이드레터럴레이즈"))
         str="삼각근";
      else if(((Exercise) e).getExName().equals("런지"))
         str="둔근, 척추기립근";
      else if(((Exercise) e).getExName().equals("스탠딩사이드레그레이즈"))
         str="소두분근";
      else if(((Exercise) e).getExName().equals("데드리프트")||((Exercise) e).getExName().equals("푸쉬업")
            ||((Exercise) e).getExName().equals("플랭크"))
         str="전신";
      
      if(!str.equals("")) {
      JLabel exercisePart=new JLabel("운동 부위 : "+str);
      exercisePart.setBounds(180,80,250,30);
      exercisePart.setFont(new Font("맑은고딕코딩", Font.BOLD, 17));
      exercisePart.setHorizontalAlignment(JLabel.CENTER);
      f.add(exercisePart);
      }
      
      
      
        JTextArea story=new JTextArea(
            e.toString(),
            30, 0);
      story.setSize(500,270);
      story.setLocation(50, 400);
      story.setBackground(Color.white);
      story.setFont(new Font("맑은고딕코딩", Font.BOLD, 15));
      story.setEditable(false);
      story.setLineWrap(true);
      
        f.add(story);
        
        
        f.setSize(600,800);
      f.setTitle("운동 소개");
       f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       f.setVisible(true);
       
      
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

      
      //----------------------------------------------------
       if(((Exercise) e).getExName().equals("스트레칭1")||((Exercise) e).getExName().equals("스트레칭2")||
             ((Exercise) e).getExName().equals("스트레칭3")) {
       
          ImageIcon ex1 = new ImageIcon(((Exercise) e).getExName()+".png");
             JLabel lblex1 = new JLabel(ex1);
             lblex1.setSize(400, 200);
             lblex1.setLocation(100, 130);
             f.add(lblex1);
          
       }else {
      ImageIcon ex1 = new ImageIcon(((Exercise) e).getExName()+1+".png");
      JLabel lblex1 = new JLabel(ex1);
      lblex1.setSize(200, 200);
      lblex1.setLocation(100, 130);
      f.add(lblex1);

      ImageIcon ex2 = new ImageIcon(((Exercise) e).getExName()+2+".png");
      JLabel lblex2 = new JLabel(ex2);
      lblex2.setBounds(lblex1.getBounds());
      lblex2.setLocation((int) lblex1.getLocation().getX()+ 200, // 버튼위치
            (int) lblex1.getLocation().getY() );  
      f.add(lblex2);
       }
      if(((Exercise) e).getExName().equals("스트레칭1")||((Exercise) e).getExName().equals("스트레칭2")||
            ((Exercise) e).getExName().equals("스트레칭3")) {
         
      ImageIcon btnnext1 = new ImageIcon("next1.jpg");
      ImageIcon btnnext2 = new ImageIcon("next2.jpg");
      
      JButton btnNext = new JButton(btnnext1);
      btnNext.setRolloverIcon(btnnext2);
      
      btnNext.setSize(45, 45);
      btnNext.setLocation(540, 700);
      btnNext.setBorderPainted(false);
      btnNext.setContentAreaFilled(false);
      btnNext.setFocusPainted(false);
      
     f.add(btnNext);
      
     
      if(((Exercise) e).getExName().equals("스트레칭1")) {
         
         btnNext.addActionListener(new ActionListener() {   
                @Override
                public void actionPerformed(ActionEvent e) {

                   f.dispose();
                    Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(1),7));
                    
                   }
             });
         
      }
      
      if(((Exercise) e).getExName().equals("스트레칭2")) {
         
         btnNext.addActionListener(new ActionListener() {   
                @Override
                public void actionPerformed(ActionEvent e) {

                   f.dispose();
                    Frame_Base.getInstance(new Frame_ExerciseInfo(u,exlist.get(2),7));
                    
                   }
             });
         
      }
      
   if(((Exercise) e).getExName().equals("스트레칭3")) {
     
     btnNext.addActionListener(new ActionListener() {   
            @Override
            public void actionPerformed(ActionEvent e) {

               if(u.getUserGender().equals("M")) {
                    Frame_Base.getInstance(new Frame_main_male(u));
                    f.dispose();
                    }else {
                       Frame_Base.getInstance(new Frame_main_female(u));
                       f.dispose();
                    }
               }
         });

}      

      }
      
    
      //---------------------------------------------------
      
      btnBack.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(i==1) {
               Frame_Base.getInstance(new Frame_Chest(u));
               f.dispose();
            }else if(i==2) {
               Frame_Base.getInstance(new Frame_back(u));
               f.dispose();
            }else if(i==3) {
               Frame_Base.getInstance(new Frame_leg(u));
               f.dispose();
            }else if(i==4) {
               Frame_Base.getInstance(new Frame_up(u));
               f.dispose();
            }
            else if(i==5) {
               Frame_Base.getInstance(new Frame_down(u));
               f.dispose();
            }
            else if(i==6) {
               Frame_Base.getInstance(new Frame_all(u));
               f.dispose();
            }else if(i==7) {
               Frame_Base.getInstance(new Frame_Cross(u));
               f.dispose();
            }
         }
      });
   }
   
   
   
   public static String addstring(String[] s) {
      String str= null;
      
      for(int i=0;i<s.length;i++) {
         str+=s[i]+"\n";
      }
      
      return str;
   }
   

}