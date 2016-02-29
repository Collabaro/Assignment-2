package DecConverter;

import javax.swing.JFrame;

public class CalDemo extends JFrame
{
  public static void main(String[] args)
  {   
   calculator cal = new calculator();
   cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   cal.setSize(600,200);
   cal.setVisible(true);
   
   }
  }