import METODOS.MDoctor;
import METODOS.MPaciente;
import entidades.doctor;
import entidades.paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class cita extends JFrame {
    private JPanel mipanel;
    private JComboBox cmbdoctor;
    private JComboBox cmbdia;
    private JComboBox cmbmes;
    private JComboBox cmbaño;
    private JTextArea txtmotivo;
    private JButton btningreso;
    private JButton btncancelar;
    private JComboBox cmbpaciente;
    private JTextField txtpaciente;
    ArrayList<paciente> lista;

    public boolean VFecha(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public cita() {
        try {
            FileInputStream leer = new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            lista = (ArrayList<paciente>) o;

            for (paciente p : lista) {
                cmbpaciente.addItem(p.getID());
            }
            lectorObjetos.close();
            leer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream leer = new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<doctor> lista = (ArrayList<doctor>) o;

            for (doctor d : lista) {
                cmbdoctor.addItem(d.getNombredoc());
            }
            lectorObjetos.close();
            leer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        cmbpaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MPaciente crud = new MPaciente();
                String numero = cmbpaciente.getSelectedItem().toString();
                String Ncompleto;
                try {
                    paciente a = crud.getID(numero);
                    Ncompleto = a.getNcompleto();
                    txtpaciente.setText(Ncompleto);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cmbdoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MDoctor crudDoctor = new MDoctor();
                String nombreDoctor = cmbdoctor.getSelectedItem().toString();
                String especialidad;

                doctor doctor = null;
                try {
                    doctor = crudDoctor.getInfoDoctorPorNombre(nombreDoctor);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btningreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cmbdia.getSelectedItem().toString() + "/" +
                        cmbmes.getSelectedItem().toString() + "/" +
                        cmbaño.getSelectedItem().toString();

                boolean resultado = validaFecha(fecha);
                if (resultado) {
                    JOptionPane.showMessageDialog(mipanel, "Correcto");
                } else {
                    JOptionPane.showMessageDialog(mipanel, "Error fecha");
                }
                dispose();

            }
        });

        btncancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        mipanel,
                        "¿Te gustaría salir?",
                        "Confirmado",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private boolean validaFecha(String fecha) {
        return VFecha(fecha);
    }

    public static void main(String[] args) {
        cita c = new cita();
        c.setContentPane(c.mipanel);
        c.setSize(500, 500);
        c.setTitle("Citas");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
    }
}
