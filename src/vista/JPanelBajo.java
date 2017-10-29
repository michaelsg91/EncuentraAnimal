package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class JPanelBajo extends JPanel implements Runnable{
	public Thread hilo;
	public JLabel tseg,tmin,pun1,tpunt;
	public byte seg,min;
	private boolean b;
	
	public JPanelBajo(){
		setLayout(null);
		setFont(new Font("Kinnari",Font.BOLD,18));
		setBackground(Color.decode("#3098BA"));
		setPreferredSize(new Dimension(500,60));;
		
		tseg=new JLabel("00");
		tmin=new JLabel("00");
		pun1=new JLabel(":");

		b=false;
		
		
		tmin.setBounds(20, 22, 30, 15);
		tseg.setBounds(50, 22, 30, 15);
		pun1.setBounds(50, 22, 5, 15);
		
		tmin.setHorizontalAlignment(JLabel.CENTER);
		tseg.setHorizontalAlignment(JLabel.CENTER);
		
		pun1.setFont(getFont());
		tmin.setFont(getFont());
		tseg.setFont(getFont());
		
			
		hilo=new Thread(this);
		hilo.start();
		add(tseg);add(tmin);add(pun1);

		
	}
	
	public void iniciar(){
		if(b){
			seg++;
			if(seg==60){
				seg=0;
				min++;
			}			
		}
		
		tmin.setText(""+min);
		tseg.setText(""+seg);
	}
	public void reiniciar(){
		seg=0;
		min=0;
		b=true;
		
	}
	public void parar(){
		b=false;
	}
	public void run(){
		Thread ct=Thread.currentThread();
		while(ct==hilo){
			iniciar();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
