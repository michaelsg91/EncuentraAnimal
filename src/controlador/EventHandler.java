package controlador;
import jess.*;
import util.Helper;
import vista.*;

public class EventHandler implements JessListener{
	JFrameAnimales jframe;
	
	public EventHandler(JFrameAnimales jframe){
		this.jframe=jframe;
	}
	
	  public void eventHappened(JessEvent je){
	    	int type=je.getType();
	        Rete rete=(Rete)je.getSource();
	        Helper helper=new Helper(rete);

	        if(type==JessEvent.DEFRULE_FIRED){
	           Fact nodoActual = helper.findFactByTempleteName("MAIN::nodo-actual");
	            if (nodoActual != null){
	                String slotV;
	                Fact nodo = null;
	                try {
	                    slotV = nodoActual.get(0).toString();	                   
	                    QueryResult qr=rete.runQueryStar("buscar-nodo",new ValueVector().add(slotV));
	                    qr.next();                 
                    
                        String tipo=qr.getString("tipo");
                        String nombre_nodo=qr.getString("nombre");
                        if (tipo.equals("pregunta")){
                            String pregunta=qr.getString("pregunta");
                            jframe.cambiarPregunta(pregunta);
                        }else if(tipo.equals("respuesta")){
                            String respuesta=qr.getString("respuesta");
                            jframe.darRespuesta(""+respuesta);                        
                        }
                        
                        if(nombre_nodo.equals("nodo-1")){
                        	jframe.bajo.reiniciar();
                        }
                   
	                } catch (JessException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	    }
}
