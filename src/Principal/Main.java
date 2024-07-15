
package Principal;

import Controlador.LoginController;
import Vista.Login;

public class Main {
    
    public static void main(String[] args) {
        
        LoginController cfi = new LoginController(new Login());
    }
    
}
