package vista;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.*;
import javax.swing.*;

class JPanelAnimales extends JPanel{
	private JLabel titulo;
	public JPanelAnimales(){
		titulo=new JLabel("Adivina el Animal");
		setFont(new Font("Kinnari",Font.BOLD,26));
		setBackground(Color.decode("#3098BA"));
		titulo.setFont(getFont());
		add(titulo);
	}
}

class JPanelMedio extends JPanel{
	public JLabel pregunta,respuesta;
	private ButtonGroup grupo;
	public JRadioButton yes;
	public JRadioButton no;
	public JButton ok;

	
	public JPanelMedio(){
		setLayout(null);
		setFont(new Font("Kinnari",Font.BOLD,16));
		pregunta=new JLabel("Pregunta");
		respuesta=new JLabel("");
		yes=new JRadioButton("Yes",true);
		no=new JRadioButton("No",false);
		
	
		
		grupo=new ButtonGroup();
		grupo.add(yes);
		grupo.add(no);
		
		ok=new JButton("Aceptar");
		
		pregunta.setBounds(20,20,560,40);
		yes.setBounds(20,70,50,30);
		no.setBounds(100,70,50,30);
		ok.setBounds(200,70,100,30);
		respuesta.setBounds(20,150,400,40);
		
		pregunta.setFont(getFont());
		respuesta.setFont(getFont());
		ok.setFont(getFont());
		yes.setFont(getFont());
		no.setFont(getFont());
		
		
		
		add(pregunta);add(yes);add(no);add(ok);add(respuesta);
		
		
	}
	
	
}

class JPanelBajo extends JPanel{
	public JPanelBajo(){
		setBackground(Color.decode("#3098BA"));
		setPreferredSize(new Dimension(500,60));;
		
	}
}