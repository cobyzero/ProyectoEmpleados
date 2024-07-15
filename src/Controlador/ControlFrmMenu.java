
package Controlador;
import Modelo.DTOUsuario;
import Vista.*;
import Vista.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlFrmMenu implements ActionListener{
    private final FrmMenu menuView;
    private DTOUsuario usuario;

    public ControlFrmMenu(FrmMenu _menuView, DTOUsuario _usuario) {
        this.menuView = _menuView;
        this.usuario = _usuario;
        menuView.setLocationRelativeTo(menuView);
        menuView.setVisible(true);
        menuView.btnEmp.addActionListener((ActionListener) this);
        menuView.btnAct.addActionListener((ActionListener) this);
    }
@Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menuView.btnEmp) {
            var addEmp = new FrmEmp();
            var contro = new ControlFrmEmp(addEmp);

            menuView.dspEscritorio.add(addEmp);
        }

        if (e.getSource() == menuView.btnAct) {
            var addAct = new FrmAct();
            addAct.setVisible(true);
            menuView.dspEscritorio.add(addAct);
        }
    }
}
