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

public class FirstWindow extends JFrame{

	public FirstWindow() {
		   setTitle("Start");
		   new JFrame();
		  // this.setSize(400,400);
		   //setLayout(new BorderLayout ());
		    addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        System.exit(0);
		      }
		    });
		  }
	public static void main(String[] args){
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	    
	    FirstWindow mf = new FirstWindow(); 
	    Button b1 = new Button("START");
	    Label l1 = new Label ("---DOWNSTREAM PROCESSING of INSULIN---");
	    Label l3 = new Label ("OPTIMIZING REVENUE");
	    Label l4 = new Label ("Click START to Begin");
	    Label l2 = new Label("...");
	    	mf.add(b1);
	    	mf.add(l1);
	    	mf.add(l3);
	    	mf.add(l4);
	    	mf.add(l2);
	    l1.setBounds(80,10,400,20);
	    l3.setBounds(140,40,400,20);
	    l4.setBounds(140,70,400,20);
	    b1.setBounds(140,110,100,30);
	    mf.addWindowListener(
                new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {

                                // This closes the window and terminates the
                                // Java Virtual Machine in the event that the
                                // Frame is closed by clicking on X.
                                System.out.println("Exit via windowClosing.");
                                System.exit(0);
                        }
                }
        );
	    ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        System.out.println("Start clicked.");
		        new Input();
		      }
		    };
		    b1.addActionListener(actionListener);
		    
		    //mf.pack();
		    //mf.show();
		    mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    mf.setVisible(true);
		    mf.setSize(400,200);
	}
}
