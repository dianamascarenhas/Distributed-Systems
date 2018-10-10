package clock1;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lamport implements ActionListener
{
Frame f;
common c1,c2,c3;
lamport()
{
f=new Frame("PROJECT PROBLEM-1");
c1=new common("Process: A");
c2=new common("Process: B");
c3=new common("Process: C");
f.setLayout(null);
c1.setBounds(30,100,300,400);
c2.setBounds(350,100,300,400);
c3.setBounds(670,100,300,400);
f.add(c1);
f.add(c2);
f.add(c3);
c1.b1.addActionListener(this);
c2.b1.addActionListener(this);
c3.b1.addActionListener(this);
c1.list1.add("Process B");
c1.list1.add("Process C");
c2.list1.add("Process A");
c2.list1.add("Process C");
c3.list1.add("Process A");
c3.list1.add("Process B");
c1.tick=6;c2.tick=8;c3.tick=10;
f.setVisible(true);
f.setSize(1000,600);
f.setBackground(Color.BLACK);
c1.th.start();
c2.th.start();
c3.th.start();
}





public static void main(String arg[])
{
lamport lp=new lamport();

}
public void actionPerformed(ActionEvent ae)
{
String temp1,temp2,temp3;
if(ae.getActionCommand().equals("send"))
{

if(ae.getSource().equals(c1.b1))
{
temp1=c1.t1.getText();
temp2=c1.t2.getText();

// Sending message from Process A to Process B
if(c1.list1.getSelectedItem().equals("Process B"))
{
temp3=c2.t1.getText();
if(Integer.parseInt(temp1)>Integer.parseInt(temp3)) 
c2.t1.setText(temp1);
c2.t3.setText(temp2+","+temp1);
}
//Sending message from Process A to Process C
else if(c1.list1.getSelectedItem().equals("Process C"))
{
temp3=c3.t1.getText();
if(Integer.parseInt(temp1)>Integer.parseInt(temp3)) 
c3.t1.setText(temp1);
c3.t3.setText(temp2+","+temp1);
}
}
//Sending message from Process B to Process A
else if(ae.getSource().equals(c2.b1))
{
temp1=c2.t1.getText();
temp2=c2.t2.getText();
if(c2.list1.getSelectedItem().equals("Process A"))
{
temp3=c1.t1.getText();
if(Integer.parseInt(temp1)>Integer.parseInt(temp3)) 
c1.t1.setText(temp1);
c1.t3.setText(temp2+","+temp1);
}
//Sending message from Process B to Process C
else if(c2.list1.getSelectedItem().equals("Process C"))
{
temp3=c3.t1.getText();
if(Integer.parseInt(temp1)>Integer.parseInt(temp3)) 
c3.t1.setText(temp1);
c3.t3.setText(temp2+","+temp1);
}
}
else if(ae.getSource().equals(c3.b1))
{
temp1=c3.t1.getText();
temp2=c3.t2.getText();
//Sending message from Process C to Process B
if(c3.list1.getSelectedItem().equals("Process B"))
{
temp3=c2.t1.getText();
if(Integer.parseInt(temp1)>Integer.parseInt(temp3))
c2.t1.setText(temp1);
c2.t3.setText(temp2+","+temp1);

}
//Sending message from Process C to Process A
else if(c3.list1.getSelectedItem().equals("Process A"))
{
temp3=c1.t1.getText();
if(Integer.parseInt(temp1)>Integer.parseInt(temp3))
c1.t1.setText(temp1);
c1.t3.setText(temp2+","+temp1);
}
}
}
}}
