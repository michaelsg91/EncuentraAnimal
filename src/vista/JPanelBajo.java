package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class JPanelBajo extends JPanel implements Runnable{
	private Thread hilo;
	private JLabel tseg,tmin,pun1,tpunt,tmax;
	private int puntaje;
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
		tpunt=new JLabel("Tu puntaje:");
		tmax=new JLabel("0");
		puntaje=0;
		
		b=false;
		
		
		tmin.setBounds(20, 20, 30, 25);
		tseg.setBounds(50, 20, 30, 25);
		pun1.setBounds(50, 20, 5, 25);
		
		tpunt.setBounds(430,20,120,25);
		tmax.setBounds(530,20,50,25);
		
		tmin.setHorizontalAlignment(JLabel.CENTER);
		tseg.setHorizontalAlignment(JLabel.CENTER);
		
		pun1.setFont(getFont());
		tmin.setFont(getFont());
		tseg.setFont(getFont());
		tmax.setFont(getFont());
		tpunt.setFont(getFont());
		
			
		hilo=new Thread(this);
		hilo.start();
		add(tseg);add(tmin);add(pun1);add(tpunt);add(tmax);

		
	}
	
	public void saca_puntaje(int seg,int preguntas){
		puntaje=(seg*-25)+(preguntas*100);
		tmax.setText(""+puntaje);
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
