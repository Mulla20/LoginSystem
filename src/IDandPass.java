import java.util.HashMap;

public class IDandPass {

    //Using a HashMap to take advantage of key/value pairs available with HashMaps
    HashMap<String,String> loginInfo = new HashMap<String, String>(); //created instance of HashMap (for ID & Pass)

    IDandPass (){//Constructor
        loginInfo.put("Individual1", "Secure1");
        loginInfo.put("Individual2", "Secure2");
        loginInfo.put("Individual3", "Secure3");
    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
