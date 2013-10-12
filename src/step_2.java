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
public class step_2 extends JFrame implements ActionListener {

	TextField	Resin_Volume_U = new TextField(10);
	TextField	Column_Diameter_U = new TextField(10);
	TextField	Volummetric_Flow_Rate_U = new TextField(10);	
	TextField	Resin_Volume_L = new TextField(10);
	TextField	Column_Diameter_L = new TextField(10);
	TextField	Volummetric_Flow_Rate_L = new TextField(10);
	double HVU=0,HVL=0,PCU=0,PCL=0,SYC=0,SP=0;
	double TC1=0;
	//double product=0,loadconc=0;
	
	
	public step_2(double HVu,double HVl,double PCu,double PCl,double SY1,double SP1,double TC){
		
		this.setSize(750,250);
		setTitle("Process: Capture");
		Button btn = new Button("Next");
	
		
		Label	l1 = new Label("Resin Volume");		
		Label	l2 = new Label("Column Diameter");
		Label	l3 = new Label("Volummetric_Flow_Rate");			
		Label   UL = new Label("Upper Limit");
		Label   LL = new Label("Lower Limit");
		Label   crapp = new Label("...");
		
		UL.setBounds(300,30,200,20);
		LL.setBounds(500,30,200,20);
		l1.setBounds(100,50,200,20);
		l2.setBounds(100,70,200,20);
		l3.setBounds(100,90,200,20);
		
		Resin_Volume_U.setBounds(300,50,100,20);		
		Column_Diameter_U.setBounds(300,70,100,20);
		Volummetric_Flow_Rate_U.setBounds(300,90,100,20);
		
		
		
		Resin_Volume_L.setBounds(500,50,100,20);
		Column_Diameter_L.setBounds(500,70,100,20);
		Volummetric_Flow_Rate_L.setBounds(500,90,100,20);
		
		add(Resin_Volume_U);
     	add(Column_Diameter_U);
    	add(Volummetric_Flow_Rate_U);
      
	   	add(Resin_Volume_L);
       	add(Column_Diameter_L);
    	add(Volummetric_Flow_Rate_L);
    
    	
    	add(btn);
    	
    	
    	add(LL);
    	add(l1);
    	add(l2);
    	add(l3);
       	add(UL);
    	add(crapp);
    	
    	
    	btn.setBounds(350,130,100,20);
		
		btn.addActionListener(this);
		setVisible(true);	
		HVU=HVu;
		HVL=HVl;
		PCU=PCu;
		PCL=PCl;
		SYC=SY1;
		SP=SP1;
		TC1=TC;
				
	}
	public void actionPerformed(ActionEvent evente)
    {
		 System.out.println("Next Clicked");
		 
		 double RVu = Double.parseDouble(Resin_Volume_U.getText());		 
		 double CDu = Double.parseDouble(Column_Diameter_U.getText());
		 double VFRu = Double.parseDouble(Volummetric_Flow_Rate_U.getText());
		 
		 
		 double RVl = Double.parseDouble(Resin_Volume_L.getText());		 
		 double CDl = Double.parseDouble(Column_Diameter_L.getText());
		 double VFRl = Double.parseDouble(Volummetric_Flow_Rate_L.getText());

		 double ColArea = 3.142*CDl*CDl/4;
		 double LFR = VFRu*60/ColArea;
		 double RBC=1;
		 double SY=1;
		 int flag=0;
		 
		 try
		 {
		
		 PrintWriter out = new PrintWriter(new FileWriter("Output.doc",true));
		 
		 //output to the file a line
		 out.println("***Input for Capture Process***");
		 
		 out.println("---Resin Volume Range Entered---");
		 out.println("Resin Volume Upper Limit : "+RVu);
		 out.println("Resin Volume Lower Limit : "+RVl);
		 out.println("");
		 out.println("Column Diameter Upper Limit :"+CDu);
		 out.println("Column Diameter Lower Limit :"+CDl);
		 out.println("");
		 out.println("Volumetric Flow Rate Upper Limit : "+VFRu);
		 out.println("Volumetric Flow Rate Lower Limit : "+VFRl);
		 out.println("");
		

		 //close the file (VERY IMPORTANT!)
		 out.close();
		 }
		 catch(IOException e)
		 {
		 System.out.println("Error during reading/writing");
		 }
		 
		 if(RVu>RVl && CDu>CDl && VFRu>VFRl)
		 { 
		 
		 
		 if(LFR<=100 && LFR>90)
			 RBC=55;
		 else if(LFR<=90 && LFR>80)
			 RBC=65;
		 else if(LFR<=80 && LFR>70)
			 RBC=75;
		 else if(LFR<=70 && LFR>60)
			 RBC=80;
		 else
			flag=1;
		 
		 if(RBC<=60 && RBC>50)
			 SY=95;
		 else if(RBC<=70 && RBC>60)
			 SY=90;
		 else if(RBC<=80 && RBC>70)
			 SY=85;
		 else
			 flag=1;
		
		 SY=SY/100;
		 	double load_amnt;// res_vol * res_b_c;
		    double load_vol = 0;//load_amnt/load_conc;
			double noc =0;// product/load_amnt;
			double perm_fr = 0;//= vol_fr*60/1000;
			double eq4cv = 0;//4*res_vol/perm_fr;
			double loading =0;// res_vol/perm_fr;
			double washing = 0;//4*res_vol/perm_fr;
			double elution = 0;//3*res_vol/perm_fr;
			double reg2cv = 0;//2*res_vol/perm_fr;
			double total_time =1000;// (eq4cv + loading + washing + elution + reg2cv)*noc;
			double prod = 0;//step_yield/(product*100);*/
			double load_conc=0;
			double time=0;
			
			double oload_amnt;// res_vol * res_b_c;
			double oload_vol ;//load_amnt/load_conc;
			double onoc=0;// product/load_amnt;
			double oeq4cv=0;//4*res_vol/perm_fr;
			double oloading =0;// res_vol/perm_fr;
			double owashing = 0;//4*res_vol/perm_fr;
			double oelution = 0;//3*res_vol/perm_fr;
			double oreg2cv = 0;//2*res_vol/perm_fr;
			double revenue=0;
			double orevenue=0;
			double oRV=0;
			double oHV=0;
			perm_fr = VFRu*60/1000;
			double i;
			double j;
			double k;
			double l;
			double inprod;
			
			j=(RVu-RVl)/10;
			l=(HVU-HVL)/10;
			
			for (k=HVL;k<=HVU;k=k+l)
			{	
				prod=k*PCU;
				prod=prod*SYC;
				load_conc=prod/k;
				for(i=RVl;i<=RVu;i=i+j)
				{
					load_amnt = i*RBC;
					noc=prod/load_amnt;
					load_vol = load_amnt/load_conc;
					eq4cv = (4*i/perm_fr)*noc;
					loading = (load_vol/perm_fr)*noc;
					washing = (4*i/perm_fr)*noc;
					elution = (3*i/perm_fr)*noc;
					// System.out.println("Invalid input SY" +RBC +product +load_conc);
					reg2cv = (2*i/perm_fr)*noc;
		
					time = (eq4cv + loading + washing + elution + reg2cv);
					revenue = (prod*SP)/time;
					
					if (revenue>orevenue)
					{
						total_time=time;
						oRV=i;
						oHV=k;
						oload_amnt =load_amnt;
						oload_vol=load_vol;
						onoc =noc;
						oeq4cv = eq4cv;
						oloading =loading;
						owashing = washing;
					 
						oelution = elution;
						oreg2cv = reg2cv;					
					}
					
				}
			
			}
			inprod=prod;
			prod= prod*SY;
			System.out.println(+loading +"$" +washing +"$" +eq4cv +"&" + elution + "&" + reg2cv +"&" +load_vol +"$"+oHV+"$" +oRV +"$"+prod);
			if (flag==0)
			{
				new step2_out(oRV,oHV,onoc,oeq4cv,oloading,owashing,oelution,oreg2cv,prod,total_time,TC1,inprod,SP);
			}
			else
			{
				new Invalid();
			}
			//new SP4_out(12,12,14,14,5,4,6,9);
			System.out.println("Optimum Time=" +total_time);
	        setVisible(false);
		 }
		 else
		 {
			 new Invalid();
		 }
}
}