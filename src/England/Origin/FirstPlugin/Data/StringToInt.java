package England.Origin.FirstPlugin.Data;

import java.util.InputMismatchException;

/**
 * Created by josep on 13/02/2017.
 */
public class StringToInt {
    public static int String_To_Int_Convert(String a) {
        try {
            int result = Integer.parseInt(a);
            return (result);
        }
        catch (InputMismatchException ex){
            return 0;
        }
    }
}
