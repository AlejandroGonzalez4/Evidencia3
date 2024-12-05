package entidades;


import java.io.Serializable;

public class doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getNombredoc() {
        return nombredoc;
    }

    public void setNombredoc(String nombredoc) {
        this.nombredoc = nombredoc;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefonodoc() {
        return telefonodoc;
    }

    public void setTelefonodoc(String telefonodoc) {
        this.telefonodoc = telefonodoc;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    private String certificado;
    private String nombredoc;
    private String especialidad;
    private String telefonodoc;
    private String disponibilidad;


}
