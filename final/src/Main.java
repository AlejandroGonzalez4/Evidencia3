import entidades.paciente;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<paciente> listaDoctor = new ArrayList<paciente>();

            paciente d1 = new paciente();
            d1.setID("27485");
            d1.setNcompleto("Alejandro");
            d1.setEdad(Integer.parseInt("32"));
            d1.setGenero("Hombre");
            d1.setTelefono("789456123");
            d1.setTemergencia("123456789");
            d1.setDireccion("Mexico");

            paciente d2 = new paciente();
            d2.setID("AE010665");
            d2.setNcompleto("Luciana");
            d2.setEdad(Integer.parseInt("23"));
            d2.setGenero("Jose");
            d2.setTelefono("Cardiología");
            d2.setTemergencia("558010238");
            d2.setDireccion("Martes/Jueves/Sabado");

            paciente d3 = new paciente();
            d3.setID("AE011266");
            d3.setNcompleto("Santiago");
            d3.setEdad(Integer.parseInt("43"));
            d3.setGenero("Jose");
            d3.setTelefono("Cirugía General");
            d3.setTemergencia("5545219263");
            d3.setDireccion("Martes/Mierloscles/Juves/Domingo");

            listaDoctor.add(d1);
            listaDoctor.add(d2);
            listaDoctor.add(d3);

            FileOutputStream escribir = new FileOutputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(listaDoctor);
            miStream.flush();
            miStream.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}