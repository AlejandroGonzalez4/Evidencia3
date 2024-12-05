package cirugias;

import entidades.paciente;
import java.io.*;
import java.util.ArrayList;

public class pacientevalido {

    // Validar si un doctor con la misma cédula ya existe
    public static boolean existePaciente(String NSS, ArrayList<paciente> lista) {
        for (paciente paciente : lista) {
            if (paciente.getID().equals(NSS)) {
                return true; // Existe un doctor con esta cédula
            }
        }
        return false;
    }

    // Validar numero de seguridad social
    public static boolean validarFormatoNSS(String NSS) {
        return NSS.matches("\\d{11}");
    }

    // Validar que el teléfono tenga solo 10 dígitos
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }
    // Validar que los campos no estén vacíos
    public static boolean validarCamposPaciente(paciente paciente) {
        return paciente.getID() != null && !paciente.getID().isEmpty()
                && paciente.getNcompleto() != null && !paciente.getNcompleto().isEmpty()
                && paciente.getGenero() != null && !paciente.getGenero().isEmpty()
                && paciente.getTelefono() != null && !paciente.getTelefono().isEmpty()
                && paciente.getTemergencia() != null && !paciente.getTemergencia().isEmpty()
                && paciente.getDireccion() != null && !paciente.getDireccion().isEmpty();
    }

}
