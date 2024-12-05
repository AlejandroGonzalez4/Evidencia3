package METODOS;
import entidades.doctor;

import java.io.*;
import java.util.ArrayList;

public class MDoctor {

    private doctor[] listaDoctores;

    public void agregarDoctor(doctor d) {
        //leer lista desde el archivo
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            Object o = lectorObjetos.readObject();
            ArrayList<doctor> lista = (ArrayList<doctor>) o;

            //2) Agregar alumno a la lista
            lista.add(d);
            lectorObjetos.close();
            leer.close();

            //3) Escribir lista al archivo
            FileOutputStream escribir =
                    new FileOutputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);
            escritorObjetos.writeObject(lista);
            escritorObjetos.flush();

            escritorObjetos.close();
            escribir.close();

        }catch(FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public doctor getcertificado(String certificacion){
        //leer el archivo y traerse la lista de alumnos
        FileInputStream leer;
        try {
            leer = new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object miLista = miStream2.readObject();
            ArrayList<doctor> listaDoctor = (ArrayList<doctor>) miLista;
            doctor k;
            for(int i=0; i<listaDoctor.size();i++)
            {
                k = listaDoctor.get(i);
                if(certificacion.equals(k.getCertificado()))
                {
                    leer.close();
                    return k;
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            leer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void actualizarDoctor(doctor d) {
        try {
            // Leer lista desde el archivo
            FileInputStream leer = new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            ArrayList<doctor> lista = (ArrayList<doctor>) lectorObjetos.readObject();

            // Buscar y actualizar al doctor
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCertificado().equals(d.getCertificado())) {
                    lista.set(i, d); // Actualiza el doctor
                    break;
                }
            }

            lectorObjetos.close();
            leer.close();

            // Escribir lista actualizada en el archivo
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor.txt");
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


    public void eliminarDoctor(String CedulaProfesional) {
        try {
            // Leer lista desde el archivo
            FileInputStream leer = new FileInputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor.txt");
            ObjectInputStream lectorObjetos = new ObjectInputStream(leer);
            ArrayList<doctor> lista = (ArrayList<doctor>) lectorObjetos.readObject();

            // Buscar y eliminar al Doctor
            lista.removeIf(p -> p.getCertificado().equals(CedulaProfesional));

            lectorObjetos.close();
            leer.close();

            // Escribir lista actualizada en el archivo
            FileOutputStream escribir = new FileOutputStream("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor.txt");
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(escribir);


            escritorObjetos.flush();
            escritorObjetos.close();
            escribir.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //leer y mostrar el contenido del archivo
        final String FILE_PATH = ("C:\\Users\\Thekr\\IdeaProjects\\final\\Doctor.txt");
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

    public doctor getInfoDoctorPorNombre(String nombreDoctor) throws IOException, ClassNotFoundException {
        for (doctor doctor : listaDoctores) { // listaDoctores debe estar correctamente inicializada
            if (doctor.getNombredoc().equals(nombreDoctor)) {
                return doctor; // Devuelve el doctor si encuentra el nombre
            }
        }
        return null;
    }
}