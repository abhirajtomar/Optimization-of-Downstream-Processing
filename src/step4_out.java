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
public class step4_out extends JFrame implements ActionListener{
	TextField oeq4cv = new TextField(5);;//4*res_vol/perm_fr;
	TextField oloading = new TextField(5);// res_vol/perm_fr;
	TextField owashing = new TextField(5);//4*res_vol/perm_fr;
	TextField oelution = new TextField(5);//3*res_vol/perm_fr;
	TextField oreg2cv = new TextField(5);//2*res_vol/perm_fr;
	TextField ototal_time = new TextField(5);
	TextField oProd = new TextField(5);
	TextField oNOC = new TextField(5);
	TextField ResV = new TextField(5);
	double TT=0;
	double prod=0;
	double loadconc=0;
	double inproduct=0;
	double sp=0;
	public step4_out(double oRV,double NOC,double eq4cv,double loading,double washing,double elution,double reg2cv,double product,double time,double tt,double inprod, double SP){
		
		this.setSize(500,350);
		setTitle("Intermediate Output");
		
		Label NC = new Label("no. of cycles:");
		Label EV = new Label("Equilibration 4 CVs:");
		Label LD = new Label("loading time:");
		Label WH = new Label ("washing time:");
		Label ET = new Label("elution 3 CV's time:");
		Label RV = new Label("Regeneration 2 CV's time:");
		Label Pro = new Label("Product of this Process:");
		Label TM = new Label ("total time:");
		Label Rvol = new Label("optimum resin volume:");
		NC.setBounds(100,30,200,20);
		EV.setBounds(100,50,200,20);
		LD.setBounds(100,70,200,20);
		WH.setBounds(100,90,200,20);
		ET.setBounds(100,110,200,20);
		RV.setBounds(100,130,200,20);
		Pro.setBounds(100,150,200,20);
		TM.setBounds(100,170,200,20);
		Rvol.setBounds(100,190,200,20);
		
		oNOC.setBounds(300,30,70,20);
		oeq4cv.setBounds(300,50,70,20);
		oloading.setBounds(300,70,70,20);
		owashing.setBounds(300,90,70,20);
		oelution.setBounds(300,110,70,20);
		oreg2cv.setBounds(300,130,70,20);
		oProd.setBounds(300,150,70,20);
		ototal_time.setBounds(300,170,70,20);
		ResV.setBounds(300,190,70,20);
		Label d = new Label("..");
		Button btn = new Button("Next");
		btn.setBounds(200,230,100,20);
		add(btn);
		add(Rvol);
		add(ResV);
		add(NC);
		add(EV);
		add(LD);
		add(WH);
		add(ET);
		add(RV);
		add(Pro);
		add(TM);
		
		add(oNOC);
		add(oeq4cv);
		add(oloading);
		add(owashing);
		add(oelution);
		add(oreg2cv);
		add(oProd);
		add(ototal_time);
		add(d);
		TT = tt;
		sp=SP;
		inproduct=inprod;
		prod=product;
		loadconc=product/0.6;
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
		String sRvol= Double.toString(oRV);
		ResV.setText(sRvol);
		btn.addActionListener(this);
		setVisible(true);
		
		try
		 {
		
		 PrintWriter out = new PrintWriter(new FileWriter("Output.doc",true));
		 
		 //output to the file a line
		 out.println("***OUTPUT of Intermediate Processing Stage***");
		 out.println("Optimum Resin Volume:"+oRV);
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
		new step_5(prod,loadconc,TT,inproduct,sp);
		setVisible(false);
	}
}
