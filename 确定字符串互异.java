import java.util.*;

public class Different {
    public boolean checkDifferent(String iniString) {
        // write code here
        for(int i = 0; i < iniString.length(); i++)
        {
            if(iniString.substring(i + 1).indexOf(iniString.charAt(i)) != -1){
            	return false;
            }
    }
        return true;
}
}