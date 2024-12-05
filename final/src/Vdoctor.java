import METODOS.MDoctor;
import entidades.doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vdoctor extends JFrame {
    private JPanel mipanel;
    private JTextField txtnombredoc;
    private JTextField txtespecialidad;
    private JTextField txttelefonodoc;
    private JTextField txtdisponibilidad;
    private JTextField txtcertificado;
    private JButton btnbuscar;
    private JButton btnagregar;

    public Vdoctor() {
        btnbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MDoctor crud = new MDoctor();
                String cedulaProfesional = txtcertificado.getText();
                doctor a = null;

                try {
                    a = crud.getcertificado(cedulaProfesional);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mipanel, "Error al buscar el doctor: " + ex.getMessage());
                }

                if (a == null) {
                    int respuesta = JOptionPane.showConfirmDialog(
                            mipanel,
                            "No se encuentra este Doctor " + cedulaProfesional + ". ¿Desea ingresarlo?",
                            "Doctor",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (respuesta == JOptionPane.YES_OPTION) {
                        // Dar de alta a un Doctor inexistente
                        btnagregar.setEnabled(true);
                        txtnombredoc.requestFocus();
                    } else {
                        // No quiere dar de alta, limpiar formulario
                        limpiarFormulario();
                    }
                } else {
                    // Se encontró al Doctor
                    txtnombredoc.setText(a.getNombredoc());
                    txtcertificado.setText(a.getCertificado());
                    txttelefonodoc.setText(a.getTelefonodoc());
                    txtdisponibilidad.setText(a.getDisponibilidad());
                    txtespecialidad.setText(a.getEspecialidad());
                }
            }
        });

        btnagregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctor midoctor = new doctor();
                midoctor.setCertificado(txtcertificado.getText());
                midoctor.setNombredoc(txtnombredoc.getText());
                midoctor.setTelefonodoc(txttelefonodoc.getText());
                midoctor.setDisponibilidad(txtdisponibilidad.getText());
                midoctor.setEspecialidad(txtespecialidad.getText());

                // Invocar método para agregar Doctor
                MDoctor crud = new MDoctor();
                try {
                    crud.agregarDoctor(midoctor);
                    JOptionPane.showMessageDialog(mipanel, "Doctor agregado correctamente.");
                    limpiarFormulario();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mipanel, "Error al agregar el doctor: " + ex.getMessage());
                }
            }
        });
    }

    private void limpiarFormulario() {
        txtnombredoc.setText("");
        txtcertificado.setText("");
        txttelefonodoc.setText("");
        txtdisponibilidad.setText("");
        txtespecialidad.setText("");
    }

    public static void main(String[] args) {
        Vdoctor v = new Vdoctor();
        v.setContentPane(v.mipanel);
        v.setSize(500, 500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}


