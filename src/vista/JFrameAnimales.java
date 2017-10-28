package vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
public class JFrameAnimales extends JFrame{
	private JPanelAnimales titulo;
	private JPanelMedio medio;
	private JPanelBajo bajo;
	public JFrameAnimales(){
		setTitle("Animales");
		setPreferredSize(new Dimension(500,350));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		setResizable(false);
		setFont(new Font("Kinnari",Font.PLAIN,16));
		pack();
		setLocationRelativeTo(null);
		
		titulo=new JPanelAnimales();
		medio=new JPanelMedio();
		bajo=new JPanelBajo();
		
		add(titulo,BorderLayout.NORTH);
		add(medio,BorderLayout.CENTER);
		add(bajo,BorderLayout.SOUTH);
		
	}

}
