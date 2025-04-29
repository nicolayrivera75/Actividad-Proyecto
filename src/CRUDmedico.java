import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDmedico {
        public void insertarMedico(Medico medico) {
        String sql = "INSERT INTO Medico (rm, nombre, apellido) VALUES (?, ?, ?)";

        try (Connection conn = SQLconexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, medico.getRm());
            pstmt.setString(2, medico.getNombre());
            pstmt.setString(3, medico.getApellido());

            pstmt.executeUpdate();
            System.out.println("Médico insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void buscarMedicoPorRm(int rm) {
        String sql = "SELECT * FROM Medico WHERE rm = ?";

        try (Connection conn = SQLconexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rm);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                System.out.println("Médico no encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
