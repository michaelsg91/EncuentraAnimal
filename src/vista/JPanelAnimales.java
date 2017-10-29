package vista;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.*;
import javax.swing.*;

class JPanelAlto extends JPanel{
	private JLabel titulo;
	public JPanelAlto(){
		titulo=new JLabel("Adivina el Animal");
		setFont(new Font("Kinnari",Font.BOLD,26));
		setBackground(Color.decode("#3098BA"));
		titulo.setFont(getFont());
		add(titulo);
	}
}

