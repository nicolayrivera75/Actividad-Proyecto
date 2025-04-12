

public class Bebe extends Paciente {
    
    protected Bebe(){
        super();
        setTipoPaciente("Bebé");
    }

    protected Bebe(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Bebé");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}
}
