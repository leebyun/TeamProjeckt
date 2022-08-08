package Frame;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import food.MyMenu;
import Frame.Frame_Base;
import Items.BasketMethod;
import Items.MyItem;
//import Frame.FrameBasket;
//import Frame.FrameStoreSelect;
import user.Userinfo;

public class Frame_Purchase extends JFrame{

   public Frame_Purchase(int sum,Userinfo u) {
      
      JFrame f=new JFrame("결제 화면");

       f.getContentPane().setBackground(Color.white);
      f.setLayout(null);
      f.setSize(600, 800);
      f.setLocationRelativeTo(null);
      
      JLabel name[]=new JLabel[16];
      JLabel price[]=new JLabel[16];
      JLabel count[]=new JLabel[16];
      JLabel total[]=new JLabel[16];
      
      int value[]=new int[16];
      
      
      setBounds(500,100,600,800);
      setBackground(Color.white);
      setLayout(null);
      setLocationRelativeTo(null);
      
      setBackground(new Color(255,255,255)); //배경색 
      setLayout(null);
      setSize(600,800);
      
      /*
      int total =0;
      for(int i = 0 ; i< MyMenu.buylist.size(); i++) {
         total += MyMenu.buylist.get(i).getPrice() * MyMenu.buylist.get(i).getCount();
      }
      */
      
      //폰트 
      Font font = (new Font("MONOSPACED", Font.BOLD , 15));
      
      //결제내역
      
      JPanel buyList = new JPanel(); 
      buyList.setLayout(null);
      buyList.setBounds(40, 20, 500, 290); 
      buyList.setBackground(new Color(255,255,255));
      buyList.setBorder(
         new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "주문내역", 
         TitledBorder.LEADING, 
         TitledBorder.TOP, 
         new Font("MONOSPACED", Font.BOLD , 17), 
         new Color(000, 000, 000) ));
         add(buyList);

         
         if(!MyItem.buylist.isEmpty()) {

          for(int i=0; i<MyItem.buylist.size(); i++) {
                   
                value[i]=0;
                value[i] += MyItem.buylist.get(i).getCount();
                name[i]=new BasketMethod().getName(i);   
                price[i]=new BasketMethod().getPrice(i);   
                count[i]=new BasketMethod().getCount(i);   
                total[i]=new BasketMethod().getTotal(value[i],i);   
                
                name[i].setFont(new Font("MONOSPACED", Font.BOLD , 12));
                price[i].setFont(new Font("MONOSPACED", Font.BOLD , 12));
                count[i].setFont(new Font("MONOSPACED", Font.BOLD , 12));
                total[i].setFont(new Font("MONOSPACED", Font.BOLD , 12));
                
                name[i].setBounds(40, -50+16*i, 220, 200);
                price[i].setBounds(200,-50+16*i,110,200);
                count[i].setBounds(300,-50+16*i,60,200);
                total[i].setBounds(400,-50+16*i,100,200);
                
             buyList.add(name[i]);
             buyList.add(price[i]);
             buyList.add(count[i]);
             buyList.add(total[i]);
             
          }
       }
     
         JLabel list = new JLabel("상품명                판매가격      수량          총 금액");
       list.setBounds(50, -70, 500, 200);
       list.setFont(new Font("MONOSPACED", Font.BOLD , 13));
       buyList.add(list);
         
       
      //배송지 입력
      
      JPanel address = new JPanel(); // 배송지 패널 생성
      address.setLayout(new GridLayout(5, 5));
      address.setBounds(40, 340, 500, 180); // , ,가로넓이
      address.setBackground(new Color(255,255,255));
      address.setBorder(
         new TitledBorder( new TitledBorder(new LineBorder(Color.LIGHT_GRAY)), //테두리없음
         "배송정보", //내용
         TitledBorder.LEADING, //텍스트 정렬방식:양쪽정렬
         TitledBorder.TOP, //텍스트 표시 위치 : 상단
         new Font("MONOSPACED", Font.BOLD , 20), //폰트 지정안함
         new Color(000, 000, 000) )); //색상
         add(address);
         
      // 주소
            JLabel lb = new JLabel("기본 배송지");
            address.add(lb);   
            JLabel deAdd = new JLabel(u.getUserAdd());
            address.add(deAdd);
            
      // 전화번호       
           
            
            address.add(new JLabel("새 주소"));
            
            JLabel j12 = new JLabel(u.getUserAdd());
            
            ImageIcon address1=new ImageIcon("address1.png");
            ImageIcon address2=new ImageIcon("address2.png");
           JButton btnAdress = new JButton(address1);
           btnAdress.setRolloverIcon(address2);
         
           btnAdress.setSize(108, 40);
           btnAdress.setBorderPainted(false);
          btnAdress.setContentAreaFilled(false);
          btnAdress.setFocusPainted(false);
        
           address.add(btnAdress);
           
            btnAdress.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               // TODO Auto-generated method stub
               String ss;
               ss = JOptionPane.showInputDialog("주소지를 입력해주세요.");
               j12.setText(ss);
               
            }
         });
            
            
            
         
      // 결제수단 
            JPanel paymentHow = new JPanel(); 
            paymentHow.setLayout(new FlowLayout());
            paymentHow.setBounds(40, 540, 500, 70);
            paymentHow.setBackground(new Color(255,255,255));
            paymentHow.setBorder(
                  new TitledBorder( new TitledBorder(new LineBorder(Color.LIGHT_GRAY)), //테두리없음
                  "결제수단", //내용
                  TitledBorder.LEADING, //텍스트 정렬방식:양쪽정렬
                  TitledBorder.TOP, //텍스트 표시 위치 : 상단
                  new Font("MONOSPACED", Font.BOLD , 20), 
                  new Color(000, 000, 000)));
                  add(paymentHow);
            
            Label laber3 = new Label("결제수단");
            CheckboxGroup group = new CheckboxGroup();
            Checkbox card = new Checkbox("Card", group,true);
            Checkbox Gynpay = new Checkbox("GymPay",group,false);
            Checkbox bluepay = new Checkbox("KakaoPay",group,false);
         
            
            Font font2 = (new Font("MONOSPACED", Font.BOLD , 25));
         
            paymentHow.add(card);
            paymentHow.add(Gynpay);
            paymentHow.add(bluepay);
            
            paymentHow.setVisible(true);
            
           JLabel l1=new JLabel();
          l1.setText("결제 금액 : "+sum+"원");
          l1.setBounds(330,590,300,80);
          l1.setFont(l1.getFont().deriveFont(22.0f));
          f.add(l1);
      
      //뒤로가기 버튼
            
          ImageIcon backBtn1 = new ImageIcon("back1.jpg");
           ImageIcon backBtn2 = new ImageIcon("back2.jpg");
           
           JButton btnBack = new JButton(backBtn1);
           btnBack.setRolloverIcon(backBtn2);
           
           btnBack.setSize(45, 45);
           btnBack.setLocation(5, 700);
           btnBack.setBorderPainted(false);
           btnBack.setContentAreaFilled(false);
           btnBack.setFocusPainted(false);

        
        btnBack.addActionListener(new ActionListener() {   
           @Override
           public void actionPerformed(ActionEvent e) {

              f.dispose();
              Frame_Base.getInstance(new Frame_Basket(u));
              
           }
        });
          
          ImageIcon Orderbtn1 = new ImageIcon("pay1.jpg");
          ImageIcon Orderbtn2 = new ImageIcon("pay2.jpg");
          
          JButton btnOrder = new JButton(Orderbtn1);
         btnOrder.setRolloverIcon(Orderbtn2);
         
         btnOrder.setSize(70, 70);
         btnOrder.setLocation(480, 680);
         btnOrder.setBorderPainted(false);
         btnOrder.setContentAreaFilled(false);
         btnOrder.setFocusPainted(false);
         
         
         
         address.add(j12);
          
          btnOrder.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                String finalAdress="";
                 
                 if(!deAdd.getText().equals(j12)) {
                    finalAdress=j12.getText();
                 }else
                    finalAdress=u.getUserAdd();
                 JOptionPane.showMessageDialog(
                       
                             null , "    결제 금액 : "+sum+"원"
                                   + "\n    결제 수단 : "+group.getSelectedCheckbox().getLabel()
                                   + "\n    배송 주소 : "+finalAdress
                                   + "\n    주문이 완료 되었습니다.");
                               f.dispose();
                         Frame_Base.getInstance(new Frame_Category(u));
                }
             });
          //장바구니버튼
          f.add(buyList);
          f.add(address);
          f.add(paymentHow);
          f.add(btnBack); //처음버튼
          f.add(btnOrder); //결제버튼

                     
          f.setVisible(true);      

   }//생성자/


   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   }
   
   