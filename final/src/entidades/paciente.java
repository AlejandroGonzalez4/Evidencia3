package entidades;

import java.io.Serializable;

public class paciente implements Serializable {


    private String ID;

    public String getNcompleto() {
        return Ncompleto;
    }

    public void setNcompleto(String ncompleto) {
        Ncompleto = ncompleto;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTemergencia() {
        return Temergencia;
    }

    public void setTemergencia(String temergencia) {
        Temergencia = temergencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechadeadmicion() {
        return fechadeadmicion;
    }

    public void setFechadeadmicion(String fechadeadmicion) {
        this.fechadeadmicion = fechadeadmicion;
    }

    private String Ncompleto;
    private String genero;
    private String telefono;
    private String Temergencia;
    private String direccion;
    private String fechadeadmicion;
    private int edad;

}
