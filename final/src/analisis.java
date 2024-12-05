import entidades.doctor;
import METODOS.MDoctor;

public class analisis {

    public static void main(String[] args) {
        MDoctor aluCRUD = new MDoctor();
        doctor resultado = aluCRUD.getcertificado("AE010665");
        if(resultado==null)
        {
            System.out.println("No se encuentra esa cedula profesional");
        }else{
            System.out.println(resultado.getCertificado());
            System.out.println(resultado.getNombredoc());
            System.out.println(resultado.getEspecialidad());
            System.out.println(resultado.getTelefonodoc());
            System.out.println(resultado.getDisponibilidad());
        }

    }
}