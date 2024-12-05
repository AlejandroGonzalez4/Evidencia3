package METODOS;
import entidades.paciente;
import java.io.*;
import java.util.ArrayList;

public class MPaciente {

    public void agregarPaciente(paciente p) {
        //leer lista desde el archivo
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<paciente> lista = (ArrayList<paciente>) o;
            //Agregar paciente
            lista.add(p);
            lectorObjetos.close();
            leer.close();
            //Escribir lista en el archivo
            FileOutputStream escribir =
                    new FileOutputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);

            escritorObjetos.flush();
            escritorObjetos.close();
            escribir.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public paciente getID(String credencial) throws IOException, ClassNotFoundException {
        //leer el archivo y traer la lista de pacientes
        FileInputStream leer;
        try {
            leer = new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object miLista = miStream2.readObject();
            ArrayList<paciente> listaPaciente = (ArrayList<paciente>) miLista;
            paciente H;
            for (int i = 0; i < listaPaciente.size(); i++) {
                H = listaPaciente.get(i);
                if (credencial.equals(H.getID())) {

                    leer.close();
                    return H;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void actualizarPaciente(paciente p) {
        try {
            // Leer lista desde el archivo
            FileInputStream leer = new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            ArrayList<paciente> lista = (ArrayList<paciente>) lectorObjetos.readObject();

            // Buscar y actualizar al paciente
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getID().equals(p.getID())) {
                    lista.set(i, p); // Actualiza el paciente
                    break;
                }
            }

            lectorObjetos.close();
            leer.close();

            // Escribir lista actualizada en el archivo
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);

            escritorObjetos.flush();
            escritorObjetos.close();
            escribir.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarPaciente(String numeroDeSeguridadSocial) {
        try {
            // Leer lista desde el archivo
            FileInputStream leer = new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            ArrayList<paciente> lista = (ArrayList<paciente>) lectorObjetos.readObject();

            // Buscar y eliminar al paciente
            lista.removeIf(p -> p.getID().equals(numeroDeSeguridadSocial));

            lectorObjetos.close();
            leer.close();

            // Escribir lista actualizada en el archivo
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);

            escritorObjetos.flush();
            escritorObjetos.close();
            escribir.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //leer y mostrar el contenido del archivo
        final String FILE_PATH = ("C:\\Users\\Thekr\\IdeaProjects\\final\\Paciente.txt");
        {
            File archivo = new File(FILE_PATH);
            if (!archivo.exists()) {
                System.out.println("El archivo no existe.");
                return;
            }

            try (FileReader fr = new FileReader(archivo);
                 BufferedReader br = new BufferedReader(fr)) {

                String linea;
                System.out.println("Contenido del archivo:");
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }

            } catch (IOException e) {
                throw new RuntimeException("Error al leer el archivo: " + e.getMessage(), e);
            }
        }
    }
}
