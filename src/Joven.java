

public class Joven extends Paciente{

    protected Joven(){
        super();
        setTipoPaciente("Joven adulto");
    }

    protected Joven(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Joven");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}
    

}
