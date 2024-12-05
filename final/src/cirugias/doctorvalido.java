package cirugias;

import entidades.doctor;
import java.io.*;
import java.util.ArrayList;

public class doctorvalido {
    // Validar si un doctor con la misma cédula ya existe
    public static boolean existeDoctor(String cedula, ArrayList<doctor> lista) {
        for (doctor doctor : lista) {
            if (doctor.getCertificado().equals(cedula)) {
                return true; // Existe un doctor con esta cédula
            }
        }
        return false;
    }

    // Validar cédula profesional
    public static boolean validarFormatoCedula(String cedula) {
        return cedula.matches("[A-Za-z0-9]+");
    }

    // Validar que el teléfono tenga solo 10 dígitos
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }

    // Validar que los campos no estén vacíos
    public static boolean validarCamposDoctor(doctor doctor) {
        return doctor.getCertificado() != null && !doctor.getCertificado().isEmpty()
                && doctor.getNombredoc() != null && !doctor.getNombredoc().isEmpty()
                && doctor.getEspecialidad() != null && !doctor.getEspecialidad().isEmpty()
                && doctor.getTelefonodoc() != null && !doctor.getTelefonodoc().isEmpty()
                && doctor.getDisponibilidad() != null && !doctor.getDisponibilidad().isEmpty();

    }
}
