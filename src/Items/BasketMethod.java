package Items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BasketMethod {

	final int size=20;
	
   JLabel name[]=new JLabel[size];
   JLabel price[]=new JLabel[size];
   JLabel count[]=new JLabel[size];
   JLabel total[]=new JLabel[size];
   
   JCheckBox c=new JCheckBox();
   
   JCheckBox jb[]=new JCheckBox[size];
   JSpinner js[]=new JSpinner[size];
   
   JSpinner s = new JSpinner();
   
   Font font1 = (new Font("MONOSPACED", Font.BOLD , 15));
   Font font2 = (new Font("MONOSPACED", Font.BOLD , 17));
   
   public JLabel getName(int i) {
      name[i] = new JLabel(MyItem.buylist.get(i).getName()); 
      name[i].setFont(font1);
      name[i].setBounds(40, 15+25*i, 220, 200);
      return name[i];
   }

   public JLabel getCount(int i) {
      count[i] = new JLabel(MyItem.buylist.get(i).getCount()+"개");
      count[i].setFont(font1);
      count[i].setBounds(360,15+25*i,60,200);
      return count[i];
   }

   public void setCount(JLabel[] count) {
      this.count = count;
   }

   public void setName(JLabel[] name) {
      this.name = name;
   }

   public JLabel getPrice(int i) {
      price[i] = new JLabel(MyItem.buylist.get(i).getPrice()+"원"); 
      price[i].setFont(font1);
      price[i].setBounds(250,15+25*i,110,200);
      return price[i];
   }

   public void setPrice(JLabel[] price) {
      this.price = price;
   }

   public JLabel getTotal(int value,int i) {
      total[i] = new JLabel(value*MyItem.buylist.get(i).getPrice()+"원");
      total[i].setFont(font1);
      total[i].setBounds(430,15+25*i,100,200);
      return total[i];
   }

   public void setTotal(JLabel[] total) {
      this.total = total;
   }

   public JCheckBox getJb(int i) {
      jb[i]=new JCheckBox();
      jb[i].setSize(20,20);
      jb[i].setLocation(12,105+25*i);
      
      return jb[i];
   }

   public void setJb(JCheckBox[] jb) {
      this.jb = jb;
   }

   public JSpinner getJs(int value,int i) {
      js[i] = new JSpinner(new SpinnerNumberModel(1,1,9,1));
      js[i].setValue(value);
      js[i].setLocation(500, 105+25*i);
      js[i].setSize(40,20);
      
      return js[i];
   }

   public void setJs(JSpinner[] js) {
      this.js = js;
   }

      
   public BasketMethod() {
   }

   public void BasketAddMethod(JPanel p,int i) {

      int value[]=new int[size];
      
      value[i] += MyItem.buylist.get(i).getCount();
      
      
      
      JSpinner s = new JSpinner();
      s.setSize(40,20);
      
      name[i] = new JLabel(MyItem.buylist.get(i).getName()); 
      price[i] = new JLabel(MyItem.buylist.get(i).getPrice()+"원"); 
      count[i] = new JLabel(MyItem.buylist.get(i).getCount()+"개");
      total[i] = new JLabel(value[i]*MyItem.buylist.get(i).getPrice()+"원");
                     
      name[i].setFont(font1);
      price[i].setFont(font1);
      count[i].setFont(font1);
      total[i].setFont(font1);
      
      c.setSize(20,20);
      
      p.add(name[i]);
      p.add(price[i]);
      p.add(count[i]);
      p.add(total[i]);
      
      name[i].setBounds(40, 15+25*i, 220, 200);
      price[i].setBounds(250,15+25*i,110,200);
      count[i].setBounds(360,15+25*i,60,200);
      total[i].setBounds(430,15+25*i,100,200);
      
      jb[i]=new JCheckBox();
      jb[i].setSize(c.getSize());
      jb[i].setLocation(12,105+25*i);
      p.add(jb[i]);
      
      js[i] = new JSpinner(new SpinnerNumberModel(1,1,9,1));
      js[i].setValue(value[i]);
      js[i].setLocation(500, 105+25*i);
      js[i].setSize(s.getSize());
      p.add(js[i]);
      
      js[i].addChangeListener(new ChangeListener() {               
         @Override
         public void stateChanged(ChangeEvent e) {
            if(!e.getSource().equals(0)) {
         MyItem.buylist.get(i).setCount((int)((JSpinner)e.getSource()).getValue());
         count[i].setText(((JSpinner)e.getSource()).getValue().toString()+"개");
         total[i].setText((int)(((JSpinner)e.getSource()).getValue())*MyItem.buylist.get(i).getPrice()+"원");   
            }
         }
      });
   }
   
   public JButton getplusbutton(int num, JLabel j) {

      JButton plusCount = new JButton();
      ImageIcon i = new ImageIcon("up1.png");
      ImageIcon i2 = new ImageIcon("up2.png");
      plusCount = new JButton(i);
      plusCount.setRolloverIcon(i2);
      
      plusCount.setBorderPainted(false);
      if (num == 1) {
         plusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count1 + 1) >= 10) {
                  JOptionPane.showMessageDialog(null, "한 번에 9개 까지 가능합니다.");
               } else {
                  MyItem.count1 += 1;
                  j.setText(Integer.toString(MyItem.count1));
               }
            }
         });

      } else if (num == 2) {
         plusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count2 + 1) >= 10) {
                  JOptionPane.showMessageDialog(null, "한 번에 9개 까지 가능합니다.");
               } else {
                  MyItem.count2 += 1;
                  j.setText(String.valueOf(MyItem.count2));
               }
            }
         });
      } else if (num == 3) {
         plusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count3 + 1) >= 10) {
                  JOptionPane.showMessageDialog(null, "한 번에 9개 까지 가능합니다.");
               } else {
                  MyItem.count3 += 1;
                  j.setText(String.valueOf(MyItem.count3));
               }
            }
         });
      } else if (num == 4) {
         plusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count4 + 1) >= 10) {
                  JOptionPane.showMessageDialog(null, "한 번에 9개 까지 가능합니다.");
               } else {
                  MyItem.count4 += 1;
                  j.setText(String.valueOf(MyItem.count4));
               }
            }
         });
      }else if (num == 5) {
         plusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count5 + 1) >= 10) {
                  JOptionPane.showMessageDialog(null, "한 번에 9개 까지 가능합니다.");
               } else {
                  MyItem.count5 += 1;
                  j.setText(String.valueOf(MyItem.count5));
               }
            }
         });
      }
      return plusCount;

   }// getplusbutton

   public JButton getminusbutton(int num, JLabel j) {
      JButton MinusCount = new JButton();
      ImageIcon i = new ImageIcon("down1.png");
      ImageIcon i2 = new ImageIcon("down2.png");
      
      MinusCount = new JButton(i);
      MinusCount.setRolloverIcon(i2);
      
      MinusCount.setBorderPainted(false);
      if (num == 1) {
         MinusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count1 - 1) <= 0) {
                  JOptionPane.showMessageDialog(null, "최소 1개 이상 주문하셔야 합니다.");
               } else {
                  MyItem.count1 -= 1;
                  j.setText(String.valueOf(MyItem.count1));
               }
            }
         });
      } else if (num == 2) {
         MinusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count2 - 1) <= 0) {
                  JOptionPane.showMessageDialog(null, "최소 1개 이상 주문하셔야 합니다.");
               } else {
                  MyItem.count2 -= 1;
                  j.setText(String.valueOf(MyItem.count2));
               }
            }
         });

      } else if (num == 3) {
         MinusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count3 - 1) <= 0) {
                  JOptionPane.showMessageDialog(null, "최소 1개 이상 주문하셔야 합니다.");
               } else {
                  MyItem.count3 -= 1;
                  j.setText(String.valueOf(MyItem.count3));
               }
            }
         });
      } else if (num == 4) {
         MinusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count4 - 1) <= 0) {
                  JOptionPane.showMessageDialog(null, "최소 1개 이상 주문하셔야 합니다.");
               } else {
                  MyItem.count4 -= 1;
                  j.setText(String.valueOf(MyItem.count4));
               }
            }
         });
         
      }else if (num == 5) {
         MinusCount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if ((MyItem.count5 - 1) <= 0) {
                  JOptionPane.showMessageDialog(null, "최소 1개 이상 주문하셔야 합니다.");
               } else {
                  MyItem.count5 -= 1;
                  j.setText(String.valueOf(MyItem.count5));
               }
            }
         });
      }
      return MinusCount;
   }

   public JLabel getCountLabel() {
      Font f = new Font("monospaced", Font.BOLD, 22);
      JLabel j = new JLabel("1",JLabel.CENTER);
      j.setFont(f);
      return j;
   }

   public JButton getbuyButton(int num, JLabel j, ArrayList<Item> it) {
      ImageIcon bas = new ImageIcon("담기.jpg");
      JButton btnBuy = new JButton(bas);
      
      btnBuy.setToolTipText("장바구니에 담습니다");
      if (num == 1) {
         btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (MyItem.buylist.isEmpty()) {
                  it.get(num - 1).setCount(MyItem.count1);
                  MyItem.add(it.get(num - 1));
                  MyItem.count1 = 1;
                  j.setText(String.valueOf(MyItem.count1));
               } else if (!MyItem.buylist.isEmpty()) {
                  for (int i = 0; i < MyItem.buylist.size(); i++) {
                     if (MyItem.buylist.get(i).getName().equals(it.get(num - 1).getName())) {
                        JOptionPane.showMessageDialog(null, "이미 담겨있는 상품 입니다.\n수량 변경은 장바구니에서 가능합니다.");
                        MyItem.count1 = 1;
                        j.setText(String.valueOf(MyItem.count1));
                        break;
                     }
                  } if (!MyItem.buylist.contains(it.get(num - 1))) {
                        it.get(num - 1).setCount(MyItem.count1);
                        MyItem.add(it.get(num - 1));
                        MyItem.count1 = 1;
                        j.setText(String.valueOf(MyItem.count1));
                     }
                   
               }
            }
            
         });
      } else if (num == 2) {
         btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (MyItem.buylist.isEmpty()) {
                  it.get(num - 1).setCount(MyItem.count2);
                  MyItem.add(it.get(num - 1));
                  MyItem.count2 = 1;
                  j.setText(String.valueOf(MyItem.count2));
               } else if (!MyItem.buylist.isEmpty()) {
                  for (int i = 0; i < MyItem.buylist.size(); i++) {
                     if (MyItem.buylist.get(i).getName().equals(it.get(num - 1).getName())) {
                        JOptionPane.showMessageDialog(null, "이미 담겨있는 상품 입니다.\n수량 변경은 장바구니에서 가능합니다.");
                        MyItem.count2 = 1;
                        j.setText(String.valueOf(MyItem.count2));
                     }
                  } if (!MyItem.buylist.contains(it.get(num - 1))) {
                        it.get(num - 1).setCount(MyItem.count2);
                        MyItem.add(it.get(num - 1));
                        MyItem.count2 = 1;
                        j.setText(String.valueOf(MyItem.count2));
                     }
                   
               }
            }
            
         });
      } else if (num == 3) {
         btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (MyItem.buylist.isEmpty()) {
                  it.get(num - 1).setCount(MyItem.count3);
                  MyItem.add(it.get(num - 1));
                  MyItem.count3 = 1;
                  j.setText(String.valueOf(MyItem.count3));
               } else if (!MyItem.buylist.isEmpty()) {
                  for (int i = 0; i < MyItem.buylist.size(); i++) {
                     if (MyItem.buylist.get(i).getName().equals(it.get(num - 1).getName())) {
                        JOptionPane.showMessageDialog(null, "이미 담겨있는 상품 입니다.\n수량 변경은 장바구니에서 가능합니다.");
                        MyItem.count3 = 1;
                        j.setText(String.valueOf(MyItem.count3));
                     }
                  } if (!MyItem.buylist.contains(it.get(num - 1))) {
                        it.get(num - 1).setCount(MyItem.count3);
                        MyItem.add(it.get(num - 1));
                        MyItem.count3 = 1;
                        j.setText(String.valueOf(MyItem.count3));
                     }
                   
               }
            }
            
         });
      } else if (num == 4) {
         btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (MyItem.buylist.isEmpty()) {
                  it.get(num - 1).setCount(MyItem.count4);
                  MyItem.add(it.get(num - 1));
                  MyItem.count4 = 1;
                  j.setText(String.valueOf(MyItem.count4));
               } else if (!MyItem.buylist.isEmpty()) {
                  for (int i = 0; i < MyItem.buylist.size(); i++) {
                     if (MyItem.buylist.get(i).getName().equals(it.get(num - 1).getName())) {
                        JOptionPane.showMessageDialog(null, "이미 담겨있는 상품 입니다.\n수량 변경은 장바구니에서 가능합니다.");
                        MyItem.count4 = 1;
                        j.setText(String.valueOf(MyItem.count4));
                     }
                  } if (!MyItem.buylist.contains(it.get(num - 1))) {
                        it.get(num - 1).setCount(MyItem.count4);
                        MyItem.add(it.get(num - 1));
                        MyItem.count4 = 1;
                        j.setText(String.valueOf(MyItem.count4));
                     }
                   
               }
            }
            
         });
      }
      else if (num == 5) {
         btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (MyItem.buylist.isEmpty()) {
                  it.get(num - 1).setCount(MyItem.count5);
                  MyItem.add(it.get(num - 1));
                  MyItem.count5 = 1;
                  j.setText(String.valueOf(MyItem.count5));
               } else if (!MyItem.buylist.isEmpty()) {
                  for (int i = 0; i < MyItem.buylist.size(); i++) {
                     if (MyItem.buylist.get(i).getName().equals(it.get(num - 1).getName())) {
                        JOptionPane.showMessageDialog(null, "이미 담겨있는 상품 입니다.\n수량 변경은 장바구니에서 가능합니다.");
                        MyItem.count5 = 1;
                        j.setText(String.valueOf(MyItem.count5));
                     }
                  } if (!MyItem.buylist.contains(it.get(num - 1))) {
                        it.get(num - 1).setCount(MyItem.count5);
                        MyItem.add(it.get(num - 1));
                        MyItem.count5 = 1;
                        j.setText(String.valueOf(MyItem.count5));
                     }	
                   
               }
            }
            
         });
      }
      return btnBuy;
   }

}