import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class CRUDcita {
      public void insertarCita(Cita cita) {
        String sql = "INSERT INTO Cita (fechaSolicitud, hora_inicio, hora_fin, numeroConsultorio, disponibilidad, medico_rm, paciente_identificacion) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = SQLconexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, Date.valueOf(cita.getFechaSolicitud()));
            pstmt.setTime(2, Time.valueOf(cita.getHora_inicio()));
            pstmt.setTime(3, Time.valueOf(cita.getHora_fin()));
            pstmt.setInt(4, cita.getNumeroConsultorio());
            pstmt.setBoolean(5, cita.getdisponibilidad());
            pstmt.setInt(6, cita.getMedicoAsignado().getRm());

            if (cita.getPaciente() != null) {
                pstmt.setInt(7, cita.getPaciente().getIdentificacion());
            } else {
                pstmt.setNull(7, java.sql.Types.INTEGER);
            }

            pstmt.executeUpdate();
            System.out.println("Cita insertada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void buscarCitaPorId(int id) {
        String sql = "SELECT * FROM Cita WHERE id = ?";

        try (Connection conn = SQLconexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Fecha: " + rs.getDate("fechaSolicitud"));
                System.out.println("Hora inicio: " + rs.getTime("hora_inicio"));
                System.out.println("Hora fin: " + rs.getTime("hora_fin"));
                System.out.println("Consultorio: " + rs.getInt("numeroConsultorio"));
                System.out.println("Disponible: " + rs.getBoolean("disponibilidad"));
            } else {
                System.out.println("Cita no encontrada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
