import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame{
    private JPanel miPanel;
    private JTextField txtusuario;
    private JPasswordField txtcontraseña;
    private JButton btnentrar;
    private JButton btncancelar;

    public Inicio() {
        btnentrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //harcodear
                String password = String.valueOf(txtcontraseña.getPassword());
                if (txtusuario.getText().equals("jefe") && password.equals("0987")) {
                    //bievenida
                    //JOptionPane.showMessageDialog(miPanel,"Bienvenido admin");
                    dispose();
                    String[] tipoUsuario={"jefe"};
                    VPaciente.main(tipoUsuario);
                }else if (txtusuario.getText().equals("usuario") && password.equals("1234")){
                    //si es usuario
                    JOptionPane.showMessageDialog(miPanel,"Bienvenido usuario");
                }else{
                    //usuario o contraseña no validas
                    JOptionPane.showMessageDialog(miPanel,"Usuario o contraseña incorrectos", "Login",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btncancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación
            }
        });

    }

    public static void main(String[] args) {
        Inicio vlogin = new Inicio();
        vlogin.setContentPane(vlogin.miPanel);
        vlogin.setSize(300, 300);
        vlogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vlogin.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}