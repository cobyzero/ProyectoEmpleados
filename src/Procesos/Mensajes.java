
package Procesos;

import javax.swing.JOptionPane;


public class Mensajes {
    public static void Texto(String msj){
       JOptionPane.showMessageDialog(null, msj);
   } 
   public static String Leer(String msj){
       return JOptionPane.showInputDialog(msj);
   }
   public static int Preguntar(String titulo,String msj){
       return JOptionPane.showConfirmDialog(null,
        msj, titulo, JOptionPane.YES_NO_OPTION);
   }
}
