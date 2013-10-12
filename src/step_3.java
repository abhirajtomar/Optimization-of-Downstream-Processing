
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class step_3 extends JFrame implements ActionListener{
	
	TextField	StepYield = new TextField(5);
	TextField	LoadPPN = new TextField(5);
	TextField	RunTime = new TextField(5);
	TextField	ProdConc = new TextField(5);
	
	double prod_in=0,TCap=0,TCent=0;
	double inproduct=0;
	double sp=0;
	public step_3(double prod, double Tcap, double Tcent, double inprod,double SP){
		
		
		this.setSize(750,250);
		setTitle("Process: Filtration");
		Button btn = new Button("Next");	
		
		Label	process = new Label("FILTRATION");
		Label	l1 = new Label("Step Yield");
		Label	l2 = new Label("Load ppn");
		Label	l3 = new Label("Run Time");
		Label	l4 = new Label("Product Concentration");
		Label   c = new Label("...");
		
		
		process.setBounds(200,30,200,20);
		StepYield.setBounds(300,50,70,20);
		LoadPPN.setBounds(300,70,70,20);
		RunTime.setBounds(300,90,70,20);
		ProdConc.setBounds(300,110,70,20);
	    l1.setBounds(100,50,200,20);
		l2.setBounds(100,70,200,20);
		l3.setBounds(100,90,200,20);
		l4.setBounds(100,110,200,20);
		
		add(btn);
    	
    	
    
    	add(l1);
    	add(l2);
    	add(l3);
    	add(l4);
    	add(StepYield);
    	add(LoadPPN);
    	add(RunTime);
    	add(ProdConc);
    	add(c);
    	
    	btn.setBounds(250,150,100,20);
		
		btn.addActionListener(this);
		setVisible(true);
		
		prod_in = prod;
		TCap=Tcap;
		TCent=Tcent;
		inproduct=inprod;
		sp = SP;
	}
	
	 public void actionPerformed(ActionEvent evente)
     {
		 System.out.println("Next Clicked");
		 float SY = Float.parseFloat(StepYield.getText());
		 float PC = Float.parseFloat(ProdConc.getText());
		 float TF = Float.parseFloat(RunTime.getText());
		 double product = (prod_in*SY)/100;
		 double prodvol = product/PC;
		 new step_4(prod_in,PC,TCap,TCent,TF,inproduct,sp);
		 System.out.println("Product Volume== " +prodvol);
		 setVisible(false);
     }

}
