import java.time.LocalDate;
import java.time.LocalTime;

public class sistema {
    public static void main(String[] args) {
        // Crear pacientes
        Adulto adulto = new Adulto("30", "Juan Pérez", 123456, "Masculino", "password123");
        Joven joven = new Joven("20", "María López", 654321, "Femenino", "securepass");

        // Crear médico
        Medico medico = new Medico("Carlos", "González", 7890);

        // Crear cita médica para el adulto
        Cita citaAdulto = new Cita(LocalDate.of(2025, 4, 10), 
                                   LocalTime.of(10, 0), 
                                   LocalTime.of(10, 30), 
                                   5, 
                                   medico);

        // Crear cita médica para el joven
        Cita citaJoven = new Cita(LocalDate.of(2025, 4, 12), 
                                  LocalTime.of(11, 0), 
                                  LocalTime.of(11, 30), 
                                  8, 
                                  medico);

        // Asignar las citas a los pacientes
        citaAdulto.setPaciente(adulto);
        citaJoven.setPaciente(joven);

        // Agregar las citas a la agenda del médico
        medico.agregarEnMalla(citaAdulto);
        medico.agregarEnMalla(citaJoven);

        // Mostrar información en consola
        System.out.println("Paciente: " + adulto.getNombre() + " (" + adulto.getTipoPaciente() + ")");
        System.out.println("Cita: " + citaAdulto.getFechaSolicitud() + " de " + citaAdulto.getHora_inicio() + " a " + citaAdulto.getHora_fin());
        System.out.println("Médico: " + medico.getNombre() + " " + medico.getApellido());
        System.out.println("Consultorio: " + citaAdulto.getNumeroConsultorio());

        System.out.println("\nPaciente: " + joven.getNombre() + " (" + joven.getTipoPaciente() + ")");
        System.out.println("Cita: " + citaJoven.getFechaSolicitud() + " de " + citaJoven.getHora_inicio() + " a " + citaJoven.getHora_fin());
        System.out.println("Médico: " + medico.getNombre() + " " + medico.getApellido());
        System.out.println("Consultorio: " + citaJoven.getNumeroConsultorio());

        System.out.println("\nLista de citas del médico:");
        medico.showMallaDeCitas(); 
    }
}
