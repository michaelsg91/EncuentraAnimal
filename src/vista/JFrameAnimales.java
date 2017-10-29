package vista;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import jess.JessException;
import controlador.*;

public class JFrameAnimales extends JFrame{
	 
    private JPanelAlto titulo;
	public JPanelMedio medio;
	public JPanelBajo bajo;
	private MotorController motorController;
    public JFrameAnimales() {
       
        setTitle("Animales");
		setPreferredSize(new Dimension(600,350));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		setResizable(false);
		setFont(new Font("Kinnari",Font.PLAIN,16));
		pack();
		setLocationRelativeTo(null);
		
		titulo=new JPanelAlto();
		medio=new JPanelMedio();
		bajo=new JPanelBajo();
		
		
		
		medio.ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				 try{
		              if(medio.yes.isSelected() || medio.ok.getText().equals("Otra vez")){
		                motorController.afirmar("(respuesta si)");
		                    

		              }else if(medio.no.isSelected()){
		                motorController.afirmar("(respuesta no)");
		              }
		              
			        }catch(JessException ex){
			                Logger.getLogger(JFrameAnimales.class.getName()).log(Level.SEVERE, null, ex);
			        }
			}
		});
		
		//bajo.reiniciar();
		
		add(titulo,BorderLayout.NORTH);
		add(medio,BorderLayout.CENTER);
		add(bajo,BorderLayout.SOUTH);
    }
    
    public void setMotorController(MotorController motorController){
        this.motorController = motorController;
    }
    public void cambiarPregunta(String pregunta){
        medio.pregunta.setText(pregunta);
        medio.no.setVisible(true);
        medio.yes.setVisible(true);
        medio.ok.setText("Aceptar");
        medio.respuesta.setText("");
    }
    
    public void darRespuesta(String respuesta){
        medio.no.setVisible(false);
        medio.yes.setVisible(false);
        medio.ok.setText("Otra vez");
        medio.respuesta.setText(respuesta);
        bajo.parar();
    }


}
