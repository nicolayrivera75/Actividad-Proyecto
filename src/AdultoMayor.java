
public class AdultoMayor extends Paciente {

    protected AdultoMayor(){
        super();
        setTipoPaciente("Adulto Mayor");
    }

    protected AdultoMayor(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Adulto Mayor");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

    

}
