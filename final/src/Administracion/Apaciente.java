package Administracion;

import entidades.paciente;
import java.io.*;
import java.util.ArrayList;

public class Apaciente {

    public static boolean existePaciente(String ID,ArrayList<paciente>lista) {
        for (paciente paciente : lista) {
            if (paciente.getID().equals(ID)) {
                return true;
            }
        }
        return false;
        }

        public static boolean validarFormatoNSS(String NSS) {
            return NSS.matches("\\d{11}");
        }

        // Validar que el teléfono tenga solo 10 dígitos
        public static boolean validarTelefono(String telefono) {
            return telefono.matches("\\d{10}");
        }

        public static boolean validarCamposPaciente(paciente paciente) {
            return paciente.getID() != null && !paciente.getID().isEmpty()
                && paciente.getNcompleto() != null && !paciente.getNcompleto().isEmpty()
                && paciente.getTelefono() != null && !paciente.getTelefono().isEmpty()
                && paciente.getFechadeadmicion() != null && !paciente.getFechadeadmicion().isEmpty();

    }
}

