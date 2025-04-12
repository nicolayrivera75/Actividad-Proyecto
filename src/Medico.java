import java.util.ArrayList;


public class Medico {
    private String nombre;
    private String apellido;
    private int rm;     //número de registro médico (RM).
    private ArrayList<Cita> mallaDeCitas;

    public Medico(String nombre, String apellido, int rm) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rm = rm;
        this.mallaDeCitas = new ArrayList<>();
    }
    
    
    public void agregarEnMalla(Cita cita) {
            mallaDeCitas.add(cita);
    }

    public ArrayList<Cita> getMallaDeCitas() {
        return mallaDeCitas;
    }

    public void showMallaDeCitas() {
        System.out.println("\nAgenda de Citas del Médico " + this.nombre + " " + this.apellido + ":");
        
        if (mallaDeCitas.isEmpty()) {
            System.out.println("No hay citas programadas.");
        } else {
            for (Cita cita : mallaDeCitas) {
                System.out.println("Fecha: " + cita.getFechaSolicitud() + 
                                   " | Hora: " + cita.getHora_inicio() + " - " + cita.getHora_fin() + 
                                   " | Paciente: " + cita.getPaciente().getNombre() + 
                                   " | Consultorio: " + cita.getNumeroConsultorio());
            }
        }
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }


    public int getRm() {
        return rm;
    }


}
