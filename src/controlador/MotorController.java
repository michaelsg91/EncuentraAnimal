package controlador;
import jess.JessEvent;
import jess.JessException;
import jess.Rete;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class MotorController {
	Rete motor;
	public MotorController(){
		try{
			motor=new Rete();
			motor.reset();
			motor.batch("/clips/auto.clp");
			
		}catch(JessException e){
			Logger.getLogger(MotorController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void afirmar(String hecho) throws JessException{
		motor.assertString(hecho);
		motor.run();
	}
	
	public void addEscuchador(EventHandler eventController){
		//motor.addJessListener(eventController);
		motor.setEventMask(motor.getEventMask() | JessEvent.DEFRULE_FIRED);
		
	}
	
	public void ejecutar(){
		try{
			this.motor.run();
		}catch(JessException e){
			Logger.getLogger(MotorController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
