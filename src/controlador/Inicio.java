package controlador;
import vista.*;

public class Inicio {

	public static void main(String[] args) {

	JFrameAnimales jframe=new JFrameAnimales();
	jframe.setVisible(true);
		 
	 MotorController motorController=new MotorController();
	 EventHandler eventHandler=new EventHandler(jframe);
	 
	 jframe.setMotorController(motorController);
	 motorController.addEscuchador(eventHandler);
	 
	 motorController.ejecutar();
		
	 
	}

}
