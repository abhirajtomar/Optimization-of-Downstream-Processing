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
public class step_1 extends JFrame implements ActionListener{
	TextField Step_Y = new TextField(5);
	TextField TimeC= new TextField(5);
	double HVl=0,HVu=0,PCl=0,PCu=0,SP1=0;
	
public step_1(double HV_u,double HV_l,double PC_u,double PC_l,double SP){
	
	this.setSize(750,250);
	setTitle("Process: Centrifugation");
	Button btn = new Button("Next");
	Label	l1 = new Label("Step Yield for Centrifugation:");
	Label l3= new Label("Time for Centrifugation");
	Label   l2 = new Label("...");
	l1.setBounds(100,50,200,20);
	l3.setBounds(100,70,200,20);
	//l2.setBounds(100,70,200,20);
	Step_Y.setBounds(300,50,100,20);
	TimeC.setBounds(300,70,100,20);
	add (Step_Y);
	add(TimeC);
	add (l1);
	add(l3);
	add (btn);
	add(l2);
	
	btn.setBounds(350,130,100,20);
	setVisible(true);
	btn.addActionListener(this);
	HVu=HV_u;
	HVl=HV_l;
	PCu=PC_u;
	PCl=PC_l;
	SP1=SP;
	setVisible(true);
}
	
public void actionPerformed(ActionEvent evente)
{
	double SY1 = Double.parseDouble(Step_Y.getText());
	double TC = Double.parseDouble(TimeC.getText());
	 System.out.println("Next Clicked" +SY1);
	 setVisible(false);
	 SY1=SY1/100;
	 if (SY1>1)
	 {
		 new Invalid();
	 }
	 else
	 {
	 new step_2(HVu,HVl,PCu,PCl,SY1,SP1,TC);
	 }
}
}
