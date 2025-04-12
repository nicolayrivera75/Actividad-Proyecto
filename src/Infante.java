

public class Infante extends Paciente {

    protected Infante(){
        super();
        setTipoPaciente("Infante");
    }

    protected Infante(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Infante");
    }

    // metodo getter

    protected String getTipoPaciente() {return super.getTipoPaciente();}


}
