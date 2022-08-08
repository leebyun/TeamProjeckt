package Main;

import java.awt.Container;
import java.awt.Panel;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MouseEvent extends JFrame implements MouseListener {

 public MouseEvent(){
  Container ct = getContentPane();
  JPanel pa = new JPanel();
  JLabel la = new JLabel("레이블에 마우스를 갖다대봐~ㅋㅋ");
  la.addMouseListener(this);
  pa.add(la);
  ct.add(pa);

  setSize(300,200);
  setVisible(true);
 }
 
 public static void main(String[] args) {
  
  MouseEvent me = new MouseEvent();
  
 }

 @Override
 public void mouseEntered(java.awt.event.MouseEvent arg0) {
  System.out.println("설마 넌 지금 마우스앞???");
  
 }

 @Override
 public void mouseClicked(java.awt.event.MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseExited(java.awt.event.MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mousePressed(java.awt.event.MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseReleased(java.awt.event.MouseEvent e) {
  // TODO Auto-generated method stub
  
 }


}