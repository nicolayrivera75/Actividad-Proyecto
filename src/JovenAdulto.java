
public class JovenAdulto extends Paciente {
    
    protected JovenAdulto(){
        super();
        setTipoPaciente("Joven adulto");
    }

    protected JovenAdulto(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Joven adulto");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

}
