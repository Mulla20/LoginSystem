public class Main {
    public static void main(String[] args) {

        IDandPass idandPassword = new IDandPass(); //instance of IDandPass class

        UserLogin userLogin = new UserLogin(idandPassword.getLoginInfo()); //instance of login page, in which we call the idandPassword class to get login info from our getter we set up



    }
}