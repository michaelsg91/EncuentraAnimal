package vista;

import java.awt.Font;
import javax.swing.*;

public class JPanelMedio extends JPanel{
	public JLabel pregunta,respuesta;
	private ButtonGroup grupo;
	public JRadioButton yes;
	public JRadioButton no;
	public JButton ok;

	
	public JPanelMedio(){
		setLayout(null);
		setFont(new Font("Kinnari",Font.BOLD,18));
		pregunta=new JLabel("Pregunta");
		respuesta=new JLabel("");
		yes=new JRadioButton("Si",true);
		no=new JRadioButton("No",false);
		
	
		
		grupo=new ButtonGroup();
		grupo.add(yes);
		grupo.add(no);
		
		ok=new JButton("Aceptar");
		
		pregunta.setBounds(20,20,560,40);
		yes.setBounds(20,80,50,30);
		no.setBounds(100,80,50,30);
		ok.setBounds(230,80,100,30);
		respuesta.setBounds(20,150,400,40);
		
		pregunta.setFont(getFont());
		respuesta.setFont(getFont());
		ok.setFont(getFont());
		yes.setFont(getFont());
		no.setFont(getFont());
		
		
		
		add(pregunta);add(yes);add(no);add(ok);add(respuesta);
		
		
	}
}
