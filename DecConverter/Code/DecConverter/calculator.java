package DecConverter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class calculator extends JFrame
{
 private final JTextField textField1;
 private final JPanel buttonJPanel;
 private final JButton button;
 private final JButton button2;
 private final JButton button3;
 private final JButton button4;
 private final JTextField textField2;
 
  public calculator()
  {
    super ("Calculator");
    buttonJPanel = new JPanel();
    buttonJPanel.setLayout(new GridLayout());

    button= new JButton( "Decimal >> IEEE-754 Single");
    buttonJPanel.add(button);
     
    button2= new JButton("Decimal >> IEEE-754 Double");
    buttonJPanel.add(button2);
     
    button3= new JButton( "IEEE-754 Single >> Decimal");
    buttonJPanel.add(button3);
    
    button4= new JButton( "IEEE-754 Double >> Decimal");
    buttonJPanel.add(button4);
    
    textField1=new JTextField("Enter Decimal Number",20);
    add(textField1,BorderLayout.NORTH);
    
    textField2 = new JTextField(20);
    add(textField2,BorderLayout.SOUTH);
    textField2.setEditable(false);
    
    add(buttonJPanel);
     
    textField1.addMouseListener(new MouseAdapter() {
    	  @Override
    	  public void mouseClicked(MouseEvent e) {
    	    textField1.setText("");
    	  }
    	});
    
    button.addMouseListener(new MouseAdapter() {
  	  @Override
  	  public void mouseClicked(MouseEvent e) {
  		  float single = Float.parseFloat(textField1.getText());
  	      int bin = Float.floatToIntBits(single);
         if(single !=0){
  	      if(single>0){
  	    	textField2.setText("0"+Integer.toBinaryString(bin));
  	      }else
  	      textField2.setText(Integer.toBinaryString(bin));}
         else textField2.setText("00000000000000000000000000000000");
  	  }
  	});
    
    button2.addMouseListener(new MouseAdapter() {
    	  @Override
    	  public void mouseClicked(MouseEvent e) {
    		  double dbl = Double.parseDouble(textField1.getText());
    	      long bin = Double.doubleToLongBits(dbl);
          if(dbl!=0){
    	      if(dbl>0){
    	      textField2.setText("0"+Long.toBinaryString(bin));}
    	      else
    	    	  textField2.setText(Long.toBinaryString(bin));}
          else textField2.setText("0000000000000000000000000000000000000000000000000000000000000000");  
    	  }
    	});
    
     button3.addMouseListener(new MouseAdapter() {
  	  @Override
  	  public void mouseClicked(MouseEvent e) {
  		int convert;
  		 if(Integer.parseInt(textField1.getText().substring(0,1))==1){
  			convert = Integer.parseInt("0"+textField1.getText().substring(1),2);
  	  		float number = Float.intBitsToFloat(convert);
  	  		 textField2.setText("-"+Float.toString(number));
  		 }else{
  		
  		convert = Integer.parseInt(textField1.getText(),2);
  		float number = Float.intBitsToFloat(convert);
  		 textField2.setText(Float.toString(number));}}
  	  
  	});
   
   button4.addMouseListener(new MouseAdapter() {
  	  @Override
  	  public void mouseClicked(MouseEvent e) {
  		long convert;
  		 if(Integer.parseInt(textField1.getText().substring(0,1))==1){
  			convert = Long.parseLong("0"+textField1.getText().substring(1),2);
  	  		double number = Double.longBitsToDouble(convert);
  	  		 textField2.setText("-"+Double.toString(number));
  		 }else{
  		
  		convert = Long.parseLong(textField1.getText(),2);
  		double number = Double.longBitsToDouble(convert);
  		 textField2.setText(Double.toString(number));}}
  	  
  	});

   
    }
  }