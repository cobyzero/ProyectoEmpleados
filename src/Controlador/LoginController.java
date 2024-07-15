
package Controlador;
import AccesoDatos.DAOUsuario;
import Vista.Login;
import Vista.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginController extends DAOUsuario implements ActionListener{
    private final Login login;

    public LoginController(Login login) {
        this.login = login;

        this.login.setLocationRelativeTo(login);
        this.login.setVisible(true);
        login.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login.btnLogin) {
            var user = Login(login.txtusername.getText(), login.txtpassword.getText());

            if (user != null) {
                login.setVisible(false);
                ControlFrmMenu menuController = new ControlFrmMenu(new FrmMenu(), user);
            }

        }

    }
}
