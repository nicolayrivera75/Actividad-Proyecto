
public class Adulto extends Paciente {
    
    protected Adulto(){
        super();
        setTipoPaciente("Adulto");
    }

    protected Adulto(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Adulto");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

}
