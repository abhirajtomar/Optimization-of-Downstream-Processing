import java.awt.Button;
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
public class step_4 extends JFrame implements ActionListener {
	
	
	TextField	Resin_Volume_U = new TextField(10);
	TextField	Column_Diameter_U = new TextField(10);
	TextField	Volummetric_Flow_Rate_U = new TextField(10);	
	TextField	Resin_Volume_L = new TextField(10);
	TextField	Column_Diameter_L = new TextField(10);
	TextField	Volummetric_Flow_Rate_L = new TextField(10);
	
	double TT=0;
	double load_conc=0;
	double product=0;
	double inproduct=0;
	double sp=0;
	public step_4(double product_in,double loadconc,double Tcap,double Tcent,double TF,double inprod,double SP) {
		this.setSize(750,250);
		setTitle("Process: Intermediate");
		Button btn = new Button("Next");
		
		TT=Tcap + Tcent + TF;
		Label	l1 = new Label("Resin Volume");		
		Label	l2 = new Label("Column Diameter");
		Label	l3 = new Label("Volummetric_Flow_Rate");			
		Label   UL = new Label("Upper Limit");
		Label   LL = new Label("Lower Limit");
		Label   cp = new Label("...");
		
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
    	add(cp);
    	
    	
    	btn.setBounds(350,130,100,20);
		
		btn.addActionListener(this);
		setVisible(true);
	load_conc = loadconc;	
	product=product_in;	
	inproduct=inprod;
	sp=SP;
	}
	
	
	
	
	 public void actionPerformed(ActionEvent evente)
     {
		 System.out.println("Next Clicked");
		 
		 float RVu = Float.parseFloat(Resin_Volume_U.getText());		 
		 float CDu = Float.parseFloat(Column_Diameter_U.getText());
		 float VFRu = Float.parseFloat(Volummetric_Flow_Rate_U.getText());
		 
		 
		 float RVl = Float.parseFloat(Resin_Volume_L.getText());		 
		 float CDl = Float.parseFloat(Column_Diameter_L.getText());
		 float VFRl = Float.parseFloat(Volummetric_Flow_Rate_L.getText());

		 double ColArea = 3.142*CDl*CDl/4;
		 double LFR = VFRu*60/ColArea;
		 double RBC=1;
		 double SY=1;
		 int flag=0;
		 
		 try
		 {
		
		 PrintWriter out = new PrintWriter(new FileWriter("Output.doc",true));
		 
		 //output to the file a line
		 out.println("***Input for Intermediate Process***");
		 
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
		 
		 
		 
		 if(LFR<=80 && LFR>70)
			 RBC=21;
		 else if(LFR<=70 && LFR>60)
			 RBC=23;
		 else if(LFR<=60 && LFR>50)
			 RBC=26;
		 else if(LFR<=50 && LFR>40)
			 RBC=29;
		 else
			 flag=1;
		 
		 if(RBC<=23 && RBC>20)
			 SY=95;
		 else if(RBC<=26 && RBC>23)
			 SY=90;
		 else if(RBC<=30 && RBC>26)
			 SY=85;
		 else
			flag=1;
		 
		 SY=SY/100;
			 
			 
		 
		 
		 System.out.println("YOYO");
		 System.out.println("RV=" +RVu);
		 
		    double load_amnt;// res_vol * res_b_c;
		    double load_vol = 0;//load_amnt/load_conc;
			double noc =0;// product/load_amnt;
			double perm_fr = 0;//= vol_fr*60/1000;
			double eq4cv = 0;//4*res_vol/perm_fr;
			double loading =0;// res_vol/perm_fr;
			double washing = 0;//4*res_vol/perm_fr;
			double elution = 0;//3*res_vol/perm_fr;
			double reg2cv = 0;//2*res_vol/perm_fr;
			double total_time =10000;// (eq4cv + loading + washing + elution + reg2cv)*noc;
			double prod = 0;//step_yield/(product*100);*/
			double time=0;
			
			double oload_amnt=0;
			double oload_vol=0 ;
			double onoc=0;
			double oeq4cv=0;
			double oloading =0;
			double owashing = 0;
			double oelution = 0;
			double oreg2cv = 0;
			double oRV=0;
					
				
			
			perm_fr = VFRu*60/1000;
			float i;
			float j;
			
			
			j=(RVu-RVl)/10;
			 System.out.println("Invalid input SY" +j);
			for(i=RVl;i<=RVu;i=i+j)
			{
				load_amnt = i*RBC;
				noc=product/load_amnt;
				load_vol = load_amnt/load_conc;
				eq4cv = (4*i/perm_fr)*noc;
				loading = (load_vol/perm_fr)*noc;
				washing = (4*i/perm_fr)*noc;
				elution = (10*i/perm_fr)*noc;
				//System.out.println("input SY" +RBC +product +load_conc);
				reg2cv = (2*i/perm_fr)*noc;
	
				time = (eq4cv + loading + washing + elution + reg2cv);
					if(time<total_time)
						{
						total_time=time;
						oload_amnt =load_amnt;
						oload_vol=load_vol;
						onoc =noc;
						oeq4cv = eq4cv;
						oloading =loading;
						owashing = washing;
					 System.out.println("time=" +time +"$"+i +"$"+loading +"$" +washing +"$" +eq4cv +"&" + elution + "&" + reg2cv +"&" +load_vol);
						oelution = elution;
						oreg2cv = reg2cv;
						oRV=i;
						}
			}
			product= product*SY;
			TT= TT + total_time;
			if (flag==0)
			{
		new step4_out(oRV,onoc,oeq4cv,oloading,owashing,oelution,oreg2cv,product,total_time,TT,inproduct,sp);
		//new SP4_out(12,12,14,14,5,4,6,9);
			}
			else
			{
				new Invalid();
			}
			 System.out.println("Optimum Time=" +total_time);
           setVisible(false);
     }
		 else
		 {
			 new Invalid();
		 }
}
		 

}

