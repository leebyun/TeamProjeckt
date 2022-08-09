package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import user.Userinfo;

public class Frame_joinmember extends JFrame{
   
   public Frame_joinmember() {
      
      JFrame f = new JFrame();
      
      f.setBounds(500,100,600,800);
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        Font font=new Font("맑은고딕", Font.BOLD, 18);
        
        
        //Image
        ImageIcon img=new ImageIcon("secondimage.png");
        
        JLabel label=new JLabel(img);
        label.setBounds(40,30,500,100);
        f.add(label);
        
        
      // JLabel을 이용해 기입사항 내용 표기
      JLabel name = new JLabel("이름 :");   
        JLabel id = new JLabel("아이디 :");
        JLabel pwd = new JLabel("패스워드 :");
        JLabel add = new JLabel("주소 :");
        JLabel gender = new JLabel("성별 :");
        
        // JFrame에 생성한 라벨들 추가
        name.setFont(font);
        f.add(name);
        id.setFont(font);
        f.add(id);
        pwd.setFont(font);
        f.add(pwd);
        add.setFont(font);
        f.add(add);
        gender.setFont(font);
        f.add(gender);
        
        
        //기입할 내용 작성
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        
        
        // 성별은 둘 중에 하나를 기입해야 하므로 
        // JRadioButton으로 생성
        JRadioButton male = new JRadioButton("남자");
        JRadioButton female = new JRadioButton("여자");
        ButtonGroup gdbtn = new ButtonGroup();
        gdbtn.add(male);
        gdbtn.add(female);
        
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        
        f.add(male);
        f.add(female);
        
        // 버튼 암호화를 위해 표기 변경
        t3.setEchoChar('*');
        
        
        
        //register button
        ImageIcon joinImg=new ImageIcon("join.jpg"); 
        ImageIcon joingImg2=new ImageIcon("bjoin.jpg");
        
        JButton register = new JButton(joinImg);
        register.setRolloverIcon(joingImg2);

        register.setBorderPainted(false);   //테두리지우기
        register.setContentAreaFilled(false);   //안의 내용지우기
        register.setFocusPainted(false);       //입력됐을 때 모양 없애기
        register.setBorder(null);
        
        
        //cancel button
        ImageIcon cancelImg=new ImageIcon("cancel.jpg"); 
        ImageIcon cancelImg2=new ImageIcon("bcancel.jpg");
      
        
        JButton cancel = new JButton(cancelImg);
        cancel.setRolloverIcon(cancelImg2);
        
        cancel.setBorderPainted(false);   //테두리지우기
        cancel.setContentAreaFilled(false);   //안의 내용지우기
        cancel.setFocusPainted(false);       //입력됐을 때 모양 없애기
        cancel.setBorder(null);
                
        
           
        f.add(register);
        f.add(cancel);
        name.setBounds(50, 200, 100, 40);
        id.setBounds(50, 250, 100, 40);
        pwd.setBounds(50,300,100,40);
        add.setBounds(50, 350, 100, 40);
        gender.setBounds(50, 400, 100, 40);
        t1.setBounds(170, 200, 300, 40);
        t2.setBounds(170, 250, 300, 40);
        t3.setBounds(170, 300, 300, 40);
        t4.setBounds(170, 350, 300, 40);
        
        male.setBackground(new Color(255,255,255));
        male.setBounds(170,400,50,50);
        female.setBackground(new Color(255,255,255));
        female.setBounds(220,400,50,50);
        
        register.setBounds(185, 450, 108, 40);
        cancel.setBounds(315, 450, 108, 40); 
       
        
        f.setSize(600,600);
        f.setTitle("회원가입");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    
    
    //회원가입 버튼 눌렀을 때 내용 실행
   register.addActionListener(new ActionListener() {
   
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      try{
         //회원가입 진행 
         Userinfo user = new Userinfo();//유저 내용을 담기 위해 유저 인스턴스 생성
         Map<String, Userinfo> map = user.userlist();// 맵 구조로 아이디 저장
         
         if(map.containsKey(t2.getText())) {//map 안에 동일한 key
            //즉 동일한 아이디가 존재할 경우 아이디 가입 진행 안함
            JOptionPane.showMessageDialog(null, "아이디가 존재합니다. 다른 아이디를 입력해주세요.");
         } else {// 동일한 아이디가 없을 경우
         //파일 입출력을 통해 유저정보 저장
         BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt",true)); 
            // bufferedwriter가 추가 한다라는 뜻으로 보시면 되시는데 회원명단 텍스트 파일에 이름 아이디 패스워드 주소 를 넣겠다고 보시면 되세요
            //더 쉽게 말씀드리면 bufferedwriter를 사용하여 회원 가입으로 입력된 정보를 bufferedwriter를 통하여 텍스트 파일에 저장한다고 보시면 될거에요
         bos.write(t1.getText()+"/");
         bos.write(t2.getText()+"/");
         bos.write(t3.getText()+"/");
         bos.write(t4.getText()+"/");
         if(male.isSelected()) {
            bos.write("M"+"\n");   
         }else {
            bos.write("F"+"\n");
         }
         
         bos.close();
         JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
         f.dispose();
         Frame_Base.getInstance(new Frame_login());
      }
      }catch (Exception ex){
         JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
      }
      
         }
         });
   
   
   cancel.addActionListener(new ActionListener() {
   
   @Override
   public void actionPerformed(ActionEvent e) {
      f.dispose();
       Frame_Base.getInstance(new Frame_login());
      
      }
      });
   
   
   }//생성자
   
   
   
}
