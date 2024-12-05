import METODOS.MPaciente;
import entidades.paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VPaciente extends JFrame {
    private JPanel mipanel;
    private JTextField txtNcompleto;
    private JTextField txtID;
    private JTextField txtedad;
    private JTextField txtgenero;
    private JTextField txttelefono;
    private JTextField txtTemergencia;
    private JTextField txtdireccion;
    private JButton btnagregar;
    private JButton btnBuscar;

    public VPaciente() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MPaciente crud = new MPaciente();
                String ID = txtID.getText();
                paciente a = null;
                try {
                    a = crud.getID(ID);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                if (a == null) {
                    int respuesta = JOptionPane.showConfirmDialog(
                            mipanel,
                            "No se encuentra ese Paciente " + ID + ". ¿Desea ingresarlo?",
                            "Paciente",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (respuesta == 0) {
                        // Dar de alta a un Paciente inexistente
                        btnagregar.setEnabled(true);
                        txtNcompleto.requestFocus();
                    } else if (respuesta == 1) {
                        // No quiere dar de alta, limpiar formulario
                    }
                } else {
                    // Se encontró al Paciente
                    txtID.setText(a.getID());
                    txtNcompleto.setText(a.getNcompleto());
                    txtTemergencia.setText(a.getTemergencia());
                    txttelefono.setText(a.getTelefono());
                    txtedad.setText(String.valueOf(a.getEdad()));
                    txtgenero.setText(a.getGenero());
                    txtdireccion.setText(a.getDireccion());
                }

                btnagregar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        paciente miPaciente = new paciente();
                        miPaciente.setID(txtID.getText());
                        miPaciente.setNcompleto(txtNcompleto.getText());
                        miPaciente.setTelefono(txttelefono.getText());
                        miPaciente.setTemergencia(txtTemergencia.getText());
                        miPaciente.setEdad(Integer.parseInt(txtedad.getText()));
                        miPaciente.setDireccion(txtdireccion.getText());

                        // Invocar método para agregar Paciente
                        MPaciente crud = new MPaciente();
                        crud.agregarPaciente(miPaciente);
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        VPaciente v = new VPaciente();
        v.setContentPane(v.mipanel);
        v.setSize(500, 500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
