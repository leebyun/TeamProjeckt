package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Items.BasketMethod;
import Items.Item;
import Items.ItemCollect;
import Items.MyItem;
import Frame.Frame_Base;
import Frame.Frame_Basket;
import user.Userinfo;


public class Frame_Basket extends JFrame{
   
   public Frame_Basket(Userinfo u) {
      
      JFrame f=new JFrame("장바구니");

      f.setBackground(Color.white);
      f.setLayout(null);
      f.setSize(600, 800);
      f.setLocationRelativeTo(null);
      f.getContentPane().setBackground(Color.white);
      
      Font font1 = (new Font("MONOSPACED", Font.BOLD , 15));
      Font font2 = (new Font("MONOSPACED", Font.BOLD , 17));
      
      //장바구니 틀
      JPanel basket = new JPanel(); 
      basket.setLayout(null);
      basket.setBounds(10, 10, 560, 550); 
      basket.setBackground(Color.white);
      basket.setBorder(new TitledBorder( null, "장바구니", TitledBorder.CENTER, TitledBorder.TOP, new Font("MONOSPACED", Font.BOLD , 25), new Color(000, 000, 000) ));

      JLabel list = new JLabel("    상품명          판매가격    수량    총 금액");
      list.setBounds(50, -40, 500, 200);
      list.setFont(font2);
      basket.add(list);
      
      JLabel name[]=new JLabel[16];
      JLabel price[]=new JLabel[16];
      JLabel count[]=new JLabel[16];
      JLabel total[]=new JLabel[16];
      
      JSpinner s = new JSpinner();
      s.setSize(40,20);
      
      int value[]=new int[16];
      
      JCheckBox c=new JCheckBox();
      c.setSize(20,20);
      
      JCheckBox jb[]=new JCheckBox[16];
      JSpinner js[]=new JSpinner[16];

      
      if(!MyItem.buylist.isEmpty()) {

         for(int i=0; i<MyItem.buylist.size(); i++) {
                  
               value[i]=0;
               value[i] += MyItem.buylist.get(i).getCount();
               name[i]=new BasketMethod().getName(i);   
               price[i]=new BasketMethod().getPrice(i);   
               count[i]=new BasketMethod().getCount(i);   
               total[i]=new BasketMethod().getTotal(value[i],i);   

               jb[i]=new BasketMethod().getJb(i);
               js[i]=new BasketMethod().getJs(value[i],i);   
               
            int j=i;
            js[i].addChangeListener(new ChangeListener() {      
               
               @Override
               public void stateChanged(ChangeEvent e) {
                  if(!e.getSource().equals(0)) {
               MyItem.buylist.get(j).setCount((int)((JSpinner)e.getSource()).getValue());
               count[j].setText(((JSpinner)e.getSource()).getValue().toString()+"개");
               total[j].setText((int)(((JSpinner)e.getSource()).getValue())*MyItem.buylist.get(j).getPrice()+"원");   
                  }
               }
            });
            
            basket.add(name[i]);
            basket.add(price[i]);
            basket.add(count[i]);
            basket.add(total[i]);
            
            basket.add(jb[i]);
            basket.add(js[i]);
         }
      }
      

      ImageIcon deleteall1 = new ImageIcon("all1.png");
       ImageIcon deleteall2 = new ImageIcon("all2.png");
      
      JButton btnDeleteAll = new JButton(deleteall1);
      

      btnDeleteAll.setRolloverIcon(deleteall2);

       btnDeleteAll.setBorderPainted(false);
        btnDeleteAll.setContentAreaFilled(false);
        btnDeleteAll.setFocusPainted(false);
      
      btnDeleteAll.setFont(font2);
      btnDeleteAll.setBackground(new Color(255, 255, 255));
      btnDeleteAll.setBounds(300, 570, 130, 40);
      btnDeleteAll.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            
            for(int i=0;i<MyItem.buylist.size();i++) {
               MyItem.buylist.get(i).setCount(1);
               }   
            MyItem.buylist.clear();
               
            basket.removeAll();
            basket.revalidate();
            basket.repaint();
            }
      });
      ImageIcon deleteselect1 = new ImageIcon("select1.png");
       ImageIcon deletetselect2 = new ImageIcon("select2.png");

       JButton btnDeleteSelect = new JButton(deleteselect1);
       btnDeleteSelect.setRolloverIcon(deletetselect2);
       
      btnDeleteSelect.setFont(font2);
      btnDeleteSelect.setBackground(new Color(255, 255, 255));
      btnDeleteSelect.setBounds(440, 570, 130, 40);
      
       btnDeleteSelect.setBorderPainted(false);
        btnDeleteSelect.setContentAreaFilled(false);
        btnDeleteSelect.setFocusPainted(false);
      
      btnDeleteSelect.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {

               for(int i=MyItem.buylist.size()-1;i>=0;) {
                  if(jb[i].isSelected()) {
                  MyItem.buylist.get(i).setCount(1);
                  MyItem.buylist.remove(i);
                  i--;
                  }else
                     i--;         
            }
               f.dispose();
                  Frame_Base.getInstance(new Frame_Basket(u));
   }
      });
      
      
      f.add(btnDeleteAll);
      f.add(btnDeleteSelect);

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
            Frame_Base.getInstance(new Frame_Category(u));
            
         }
      });
      
       ImageIcon btnPay1 = new ImageIcon("next1.jpg");
         ImageIcon btnPay2 = new ImageIcon("next2.jpg");
         JButton btnPay = new JButton(btnPay1);
         btnPay.setRolloverIcon(btnPay2);
         
         btnPay.setSize(45, 45);
         btnPay.setLocation(540, 700);
         btnPay.setBorderPainted(false);
         btnPay.setContentAreaFilled(false);
         btnPay.setFocusPainted(false);

      
      btnPay.addActionListener(new ActionListener() {   
         @Override
         public void actionPerformed(ActionEvent e) {
            int sum=0;
            for(int i=0;i<MyItem.buylist.size();i++)          {
               String str=total[i].getText();
               String restr=str.replaceAll("[^0-9]","");
            sum+=Integer.parseInt(restr);
            }
            
            f.dispose();
            Frame_Base.getInstance(new Frame_Purchase(sum,u));
            }
      });
      
   
      f.add(basket); //장바구니버튼
      f.add(btnBack); //뒤로가기 버튼
      f.add(btnPay); //결제버튼

      f.setVisible(true);
      
   }
}
      