package controlador;
import vista.*;

public class Inicio {

	public static void main(String[] args) {
	 MotorController motorController=new MotorController();
	 motorController.ejecutar();
		
	 JFrameAnimales jframe=new JFrameAnimales();
	 jframe.setVisible(true);
	 
	 
	}

}
