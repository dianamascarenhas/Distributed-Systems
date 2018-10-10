package clock1;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class common extends Panel implements Runnable
{
public Label l1,l2,l3,l4,l5;
public TextField t1,t2,t3;
public Button b1;
public int tick;
public java.awt.List list1;
public Thread th;
Boolean flag;
public common(String str)
{
flag=true;
th=new Thread(this); 
l1=new Label("time");
l2=new Label("message");
l3=new Label("to:");
l4=new Label("received");
l5=new Label(str);
t1=new TextField("0");
t2=new TextField();
t3=new TextField();
b1=new Button("send");
list1=new java.awt.List();
this.setVisible(true);
this.setLayout(null);
l5.setBounds(100,15,100,30);
l1.setBounds(50,70,100,20);
l2.setBounds(50,120,100,20);
l3.setBounds(50,180,100,20);
l4.setBounds(50,240,100,20);
t1.setBounds(150,70,100,20);
t2.setBounds(150,120,100,20);
t3.setBounds(150,240,100,20);
list1.setBounds(150,180,100,40);
b1.setBounds(150,350,100,20);
t1.setEditable(false);
this.add(l5);
this.add(l1);
this.add(t1);
this.add(l2);
this.add(t2);
this.add(l3);
this.add(list1);
this.add(l4);
this.add(t3);
this.add(b1);
this.setSize(300,400);
this.setBackground(Color.GRAY);
}
public void run()
{
try{
while(flag)
{
t1.setText((Integer.parseInt(t1.getText())+this.tick)+"");
Thread.sleep(500);

}
}catch(Exception e){;}

}

}