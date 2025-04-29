import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir datos del paciente
        System.out.println("Ingrese los datos del paciente:");
        System.out.print("Nombre: ");
        String nombrePaciente = scanner.nextLine();
        
        System.out.print("Edad: ");
        String edadPaciente = scanner.nextLine();
        
        System.out.print("Identificación: ");
        int identificacionPaciente = scanner.nextInt();
        
        scanner.nextLine(); // Limpiar el buffer de Scanner
        
        System.out.print("Género: ");
        String generoPaciente = scanner.nextLine();
        
        System.out.print("Contraseña: ");
        String contraseñaPaciente = scanner.nextLine();

        Paciente paciente = new Paciente(edadPaciente, nombrePaciente, identificacionPaciente, generoPaciente, contraseñaPaciente);
        paciente.setTipoPaciente("General");  // Podrías pedir esto también si lo deseas

        // Pedir datos del médico
        System.out.println("\nIngrese los datos del médico:");
        System.out.print("Nombre: ");
        String nombreMedico = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String apellidoMedico = scanner.nextLine();
        
        System.out.print("Número de Registro Médico (RM): ");
        int rmMedico = scanner.nextInt();
        
        scanner.nextLine(); // Limpiar el buffer de Scanner
        
        Medico medico = new Medico(nombreMedico, apellidoMedico, rmMedico);

        // Pedir datos de la cita
        System.out.println("\nIngrese los datos de la cita:");
        System.out.print("Fecha (AAAA-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fechaSolicitud = LocalDate.parse(fechaStr);
        
        System.out.print("Hora de inicio (HH:MM): ");
        String horaInicioStr = scanner.nextLine();
        LocalTime horaInicio = LocalTime.parse(horaInicioStr);
        
        System.out.print("Hora de fin (HH:MM): ");
        String horaFinStr = scanner.nextLine();
        LocalTime horaFin = LocalTime.parse(horaFinStr);
        
        System.out.print("Número de consultorio: ");
        int numeroConsultorio = scanner.nextInt();
        
        scanner.nextLine(); // Limpiar el buffer de Scanner

        Cita cita = new Cita(fechaSolicitud, horaInicio, horaFin, numeroConsultorio, medico);
        cita.setPaciente(paciente);  // Asignar paciente a la cita
        medico.agregarEnMalla(cita); // Agregar cita a la malla del médico

        // Insertar en la base de datos
        CRUDpaciente crudPaciente = new CRUDpaciente();
        crudPaciente.insertarPaciente(paciente);

        CRUDmedico crudMedico = new CRUDmedico();
        crudMedico.insertarMedico(medico);

        CRUDcita crudCita = new CRUDcita();
        crudCita.insertarCita(cita);

        // Consultar un paciente por ID
        System.out.println("\nConsultando paciente con identificación " + identificacionPaciente + ":");
        crudPaciente.buscarPacientePorId(identificacionPaciente);

        // Consultar un médico por su RM
        System.out.println("\nConsultando médico con RM " + rmMedico + ":");
        crudMedico.buscarMedicoPorRm(rmMedico);

        // Consultar cita por ID
        System.out.println("\nConsultando cita con ID 1:");
        crudCita.buscarCitaPorId(1);

        // Mostrar la malla de citas del médico
        System.out.println("\nMostrando malla de citas del médico:");
        medico.showMallaDeCitas();

        scanner.close(); // Cerrar el scanner
    }
}
