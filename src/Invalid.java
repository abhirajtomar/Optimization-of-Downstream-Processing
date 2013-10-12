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
public class Invalid extends JFrame implements ActionListener{
	
	public Invalid(){
		this.setSize(300,200);
		setTitle ("invalid");
		Button btn = new Button("Ok");
		Label	l1 = new Label("Invalid Input");
		Label l2 = new Label ("...");
		l1.setBounds(110,30,200,20);
		add(l1);
		add(btn);
		add (l2);
		btn.setBounds(90,100,100,20);
		btn.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evente){
		System.exit(0);
	}
}
