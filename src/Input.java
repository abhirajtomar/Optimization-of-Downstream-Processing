import java.awt.Button;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
public class Input extends JFrame implements ActionListener{

	TextField harvest_volume_l = new TextField (10);
	TextField product_conc_l = new TextField (10);
	TextField harvest_volume_u = new TextField (10);
	TextField product_conc_u = new TextField (10);
	TextField salesprice= new TextField(10);

public Input()	{
	this.setSize(750,250);
	setTitle("Input Window");
	Button btn = new Button("Next");
	
	Label	l1 = new Label("Harvest Volume");		
	Label	l2 = new Label("Product Concentration");
	Label	l3 = new Label("Sales Price");			
	Label   UL = new Label("Upper Limit");
	Label   LL = new Label("Lower Limit");
	Label   l4 = new Label("...");
	UL.setBounds(300,30,200,20);
	LL.setBounds(500,30,200,20);
	l1.setBounds(100,50,200,20);
	l2.setBounds(100,70,200,20);
	l3.setBounds(100,90,200,20);
	harvest_volume_u.setBounds(300,50,100,20);		
	product_conc_u.setBounds(300,70,100,20);
		
	harvest_volume_l.setBounds(500,50,100,20);
	product_conc_l.setBounds(500,70,100,20);
	salesprice.setBounds(300,90,100,20);
	add(harvest_volume_u);
 	add(product_conc_u);
 	add(harvest_volume_l);
 	add(product_conc_l);
	add(salesprice);
 	add(btn);
	
	
	add(LL);
	add(l1);
	add(l2);
	add(l3);
   	add(UL);
   	add(l4);
   	btn.setBounds(350,130,100,20);
	
	btn.addActionListener(this);
	setVisible(true);
	
	
	
}

public void actionPerformed(ActionEvent evente)
{
	 System.out.println("Next Clicked");
	 double HV_u = Double.parseDouble(harvest_volume_u.getText());
	 double HV_l = Double.parseDouble(harvest_volume_l.getText());
	 double PC_u = Double.parseDouble(product_conc_u.getText());
	 double PC_l = Double.parseDouble(product_conc_l.getText());
	 double SP=Double.parseDouble(salesprice.getText());
	 System.out.println("Next Clicked");
	 if (HV_u>HV_l && PC_u>PC_l)
	 {
	 new step_1(HV_u,HV_l,PC_u,PC_l,SP);
	 try
	 {
	
	 PrintWriter out = new PrintWriter(new FileWriter("Output.doc"));
	 
	 //output to the file a line
	 out.println("***Optimization Process***");
	 
	 out.println("---Harvest Volume Range Entered---");
	 out.println("Harvest Volume Upper Limit : "+HV_u);
	 out.println("Harvest Volume Lower Limit : "+HV_l);
	 out.println("");
	 out.println("Product Concentration Upper Limit :"+PC_u);
	 out.println("Product Concentration Lower Limit :"+PC_l);
	 out.println("");
	

	 //close the file (VERY IMPORTANT!)
	 out.close();
	 }
	 catch(IOException e)
	 {
	 System.out.println("Error during reading/writing");
	 }
	 
	 }
	 else
	 {
		 new Invalid();
		 
	 }
	 setVisible(false);
}
}