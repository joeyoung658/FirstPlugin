package England.Origin.FirstPlugin.Data;

import java.util.InputMismatchException;

/**
 * Created by josep on 01/06/2017.
 */
public class StringToFloat {

    public static float String_To_Float_Convert(String a) {
        try {
            float result = Float.parseFloat(a);
            return (result);
        }
        catch (InputMismatchException ex){
            return -1;
        }
    }


}
