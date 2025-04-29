import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDpaciente {
      public void insertarPaciente(Paciente paciente) {
        String sql = "INSERT INTO Paciente (identificacion, nombre, edad, genero, tipoPaciente, contraseña) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = SQLconexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, paciente.getIdentificacion());
            pstmt.setString(2, paciente.getNombre());
            pstmt.setString(3, paciente.getEdad());
            pstmt.setString(4, paciente.getGenero());
            pstmt.setString(5, paciente.getTipoPaciente());
            pstmt.setString(6, paciente.getContraseña());

            pstmt.executeUpdate();
            System.out.println("Paciente insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void buscarPacientePorId(int id) {
        String sql = "SELECT * FROM Paciente WHERE identificacion = ?";

        try (Connection conn = SQLconexion.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Edad: " + rs.getString("edad"));
                System.out.println("Género: " + rs.getString("genero"));
                System.out.println("Tipo: " + rs.getString("tipoPaciente"));
            } else {
                System.out.println("Paciente no encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
