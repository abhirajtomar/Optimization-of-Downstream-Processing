import java.awt.Button;
import java.io.*;
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
public class step2_out extends JFrame implements ActionListener{
	TextField oeq4cv = new TextField(5);;//4*res_vol/perm_fr;
	TextField oloading = new TextField(5);// res_vol/perm_fr;
	TextField owashing = new TextField(5);//4*res_vol/perm_fr;
	TextField oelution = new TextField(5);//3*res_vol/perm_fr;
	TextField oreg2cv = new TextField(5);//2*res_vol/perm_fr;
	TextField ototal_time = new TextField(5);
	TextField oProd = new TextField(5);
	TextField oNOC = new TextField(5);
	TextField oHAV= new TextField(5);
	TextField oRSV= new TextField(5);
	double prod=0,Tcent=0,Tcap=0;
	double inproduct=0;
	double sp=0;
	public step2_out(double oHV,double oRV,double NOC,double eq4cv,double loading,double washing,double elution,double reg2cv,double product,double time,double TC1,double inprod,double SP)
	{	this.setSize(500,350);
		setTitle("Capture output");
		prod=product;
		Label NC = new Label("no. of cycles:");
		Label EV = new Label("Equilibration 4 CVs:");
		Label LD = new Label("loading time:");
		Label WH = new Label ("washing time:");
		Label ET = new Label("elution 3 CV's time:");
		Label RV = new Label("Regeneration 2 CV's time:");
		Label Pro = new Label("Product of this Process:");
		Label TM = new Label ("total time:");
		Label Hvol = new Label ("optimum Harvest Volume:");
		Label Rvol = new Label ("optimum Resin Volume:");
		Hvol.setBounds(100,30,200,20);
		Rvol.setBounds(100,10,200,20);
		NC.setBounds(100,50,200,20);
		EV.setBounds(100,70,200,20);
		LD.setBounds(100,90,200,20);
		WH.setBounds(100,110,200,20);
		ET.setBounds(100,130,200,20);
		RV.setBounds(100,150,200,20);
		Pro.setBounds(100,170,200,20);
		TM.setBounds(100,190,200,20);
		
		oHAV.setBounds(300,10,70,20);
		oRSV.setBounds(300,30,70,20);
		oNOC.setBounds(300,50,70,20);
		oeq4cv.setBounds(300,70,70,20);
		oloading.setBounds(300,90,70,20);
		owashing.setBounds(300,110,70,20);
		oelution.setBounds(300,130,70,20);
		oreg2cv.setBounds(300,150,70,20);
		oProd.setBounds(300,170,70,20);
		ototal_time.setBounds(300,190,70,20);
		Label d = new Label("..");
		Button btn = new Button("Next");
		btn.setBounds(200,230,100,20);
		add(btn);
		add(Hvol);
		add(Rvol);
		add(NC);
		add(EV);
		add(LD);
		add(WH);
		add(ET);
		add(RV);
		add(Pro);
		add(TM);
		add(oHAV);
		add(oRSV);
		add(oNOC);
		add(oeq4cv);
		add(oloading);
		add(owashing);
		add(oelution);
		add(oreg2cv);
		add(oProd);
		add(ototal_time);
		add(d);
		String sHvol= Double.toString(oHV);
		oHAV.setText(sHvol);
		String sRvol=Double.toString(oRV);
		oRSV.setText(sRvol);
		String sNOC = Double.toString(NOC);		
		oNOC.setText(sNOC);
		String seq4cv = Double.toString(eq4cv);
		oeq4cv.setText(seq4cv);
		String sloading = Double.toString(loading);
		oloading.setText(sloading);
		String swashing=Double.toString(washing);
		owashing.setText(swashing);
		String selution=Double.toString(elution);
		oelution.setText(selution);
		String sreg2cv = Double.toString(reg2cv);
		oreg2cv.setText(sreg2cv);
		String sproduct = Double.toString(product);
		oProd.setText(sproduct);
		String  stime = Double.toString(time);
		ototal_time.setText(stime);
		btn.addActionListener(this);
		Tcent=TC1;
		Tcap=time;
		prod=product;
		inproduct=inprod;
		sp = SP;
		setVisible(true);
		
		
		try
			 {
			
			 PrintWriter out = new PrintWriter(new FileWriter("Output.doc",true));
			 
			 //output to the file a line
			 out.println("***OUTPUT of CAPTURE Process***");
			 out.println("Optimum Harvest Volume:"+oRV);
			 out.println("Optimum Resin Volume:"+oHV);
			 out.println("No. of cycles:"+NOC);
			 out.println("Equilibration 4 CVs:"+eq4cv);
			 out.println("loading time:"+loading);
			 out.println("washing time:"+washing);
			 out.println("elution 3 CV's time:"+elution);
			 out.println("Regeneration 2 CV's time:"+reg2cv);
			 out.println("Product of this Process:"+product);
			 out.println("Total Time:"+time);
			 out.println("");
			

			 //close the file (VERY IMPORTANT!)
			 out.close();
			 }
			 catch(IOException e)
			 {
			 System.out.println("Error during reading/writing");
			 }

	}
public void actionPerformed(ActionEvent evente)
{
	new step_3(prod,Tcap,Tcent,inproduct,sp);
	setVisible(false);
}

}



