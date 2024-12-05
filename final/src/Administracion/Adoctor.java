package Administracion;


import java.io.Serializable;
public class Adoctor implements  Serializable {
    private  static  final long serialVersionUID = 1L;

    public Adoctor() {

    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefonoDoc() {
        return telefonoDoc;
    }

    public void setTelefonoDoc(String telefonoDoc) {
        this.telefonoDoc = telefonoDoc;
    }

    public String getDisponibiliad() {
        return disponibiliad;
    }

    public void setDisponibiliad(String disponibiliad) {
        this.disponibiliad = disponibiliad;
    }

    private String nombreDoc;
    private String especialidad;
    private String telefonoDoc;
    private String disponibiliad;
}
