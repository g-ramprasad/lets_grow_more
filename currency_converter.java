import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class CurrencyConverter extends Applet implements ActionListener
{
  double tot;
int amount;
Choice c1=new Choice();
Choice c2=new Choice();
TextField t1=new TextField(10);
TextField t2=new TextField(10);
Label l1=new Label("Currency Converter");
Label l2=new Label("Enter Amount");
Label l3=new Label("Select 1st Country");
Label l4=new Label("Select 2nd Country");
Button b=new Button("Convert");
public void init()
{
add(l1);
add(l2);
add(t1);
add(l3);
c1.addItem("INR");
c1.addItem("USD");
c1.addItem("EUR");
add(c1);
add(l4);
c2.addItem("INR");
c2.addItem("USD");
c2.addItem("EUR");
add(c2);
add(b);
b.addActionListener(this);
add(t2);
t2.setEditable(false);

}
public void paint(Graphics g)
{
l1.setBounds(100,0,120,30);
l2.setBounds(10,30,120,30);
t1.setBounds(150,30,100,25);
l3.setBounds(10,70,100,30);
c1.setBounds(150,70,100,30);
l4.setBounds(10,110,120,30);
c2.setBounds(150,110,100,30);
b.setBounds(100,150,100,30);
t2.setBounds(100,190,100,30);
}
public void actionPerformed(ActionEvent e)
{
amount=Integer.parseInt(t1.getText());
if(c1.getSelectedItem()=="INR" && c2.getSelectedItem()=="USD")
{
tot=(amount*0.012);
t2.setText("Dollar"+(tot));
}

else if(c1.getSelectedItem()=="INR" && c2.getSelectedItem()=="EUR")
{
tot=(amount*0.011);
t2.setText("Euro"+(tot));
}

else if(c1.getSelectedItem()=="USD" && c2.getSelectedItem()=="INR")
{
tot=(amount*82.93);
t2.setText("INR"+(tot));
}

else if(c1.getSelectedItem()=="USD" && c2.getSelectedItem()=="EUR")
{
tot=(amount*0.94);
t2.setText("INR"+(tot));
}

else if(c1.getSelectedItem()=="EUR" && c2.getSelectedItem()=="INR")
{
tot=(amount*87.67);
t2.setText("INR"+(tot));
}

else if(c1.getSelectedItem()=="EUR" && c2.getSelectedItem()=="USD")
{
tot=(amount*1.06);
t2.setText("INR"+(tot));
}
}
public static void main(String args[]){
  
}
}
/*
<html>
<applet code="CurrencyConverter.class" width="300" height="300"></applet>
</html>
*/