package controlador;
import jess.*;
import util.Helper;
import vista.*;

public class EventHandler implements JessListener{
	JFrameAnimales jframe;
	
	  public void eventHappened(JessEvent je){
	    	int defaultMask = JessEvent.DEFRULE_FIRED;
	        int type = je.getType();
	        Rete rete = (Rete)je.getSource();
	        Context context = je.getContext();
	        Helper helper = new Helper(rete);

	        if(type == JessEvent.DEFRULE_FIRED){
	           Fact nodoActual = helper.findFactByTempleteName("MAIN::nodo-actual");
	            if (nodoActual != null){
	                String slotV;
	                Fact nodo = null;
	                try {
	                    slotV = nodoActual.get(0).toString();
	                    nodo = helper.findFactByTemplateName("MAIN::Nodo", "nombre", slotV);
	                    if (nodo != null){
	                        String tipo = nodo.getSlotValue("tipo").stringValue(context);
	                        if (tipo.equals("pregunta")){
	                            String pregunta = nodo.getSlotValue("pregunta").stringValue(context);
	                            jframe.cambiarPregunta(pregunta);
	                        }else if(tipo.equals("respuesta")){
	                            String respuesta = nodo.getSlotValue("respuesta").stringValue(context);
	                            jframe.darRespuesta(""+respuesta);
	                        }
	                    }
	                } catch (JessException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	    }
}
