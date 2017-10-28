package util;
import jess.Fact;
import jess.JessException;
import jess.Rete;
import jess.Value;

import java.util.Iterator;


public class Helper {
    Rete motor;

    public Helper(Rete motor) {
        this.motor=motor;
    }
    
    public Fact findFactByTempleteName(String templateName){
        Fact f = null;
        Iterator iterator = motor.listFacts();

        while (iterator.hasNext()){
            Fact faux = (Fact)iterator.next();
            if(faux.getName().equals(templateName)){
                f = faux;
                break;
            }
        }
        return f;
    }

    public Fact findFactByTemplateName(String templateName, String slotName, String slotValue){
        Fact f = null;
        Iterator iterator = motor.listFacts();

        while (iterator.hasNext()){
            Fact faux = (Fact)iterator.next();
            if(faux.getName().equals(templateName)){
                String slotV;
                try {
                    Value value = faux.getSlotValue(slotName);
                    slotV = value.stringValue(motor.getGlobalContext());
                } catch (JessException e) {
                    return null;
                }
                if(slotV.equals(slotValue)){
                    f = faux;
                    break;
                }
            }
        }
        return f;
    }
}