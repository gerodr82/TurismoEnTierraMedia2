import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	
	public ArrayList<Usuario> findAll() throws SQLException {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
	Connection connection = ConnectionProvider.getConnection();
	String sql ="select * from usuario;";
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet result = statement.executeQuery();
	while (result.next()) {
	
		/*Usuario usr= new Usuario(result.getInt("idUsuario"),result.getString("nombre"),
				result.getDouble("presupuesto"),result.getDouble("tiempoDisponible") );*/
		
		/*usr.setId(result.getInt("idUsuario"));
		usr.setNombre(result.getString("nombre"));
		usr.setPresupuesto(result.getDouble("presupuesto"));
		usr.setTiempoDisponible(result.getDouble("tiempoDisponible"));*/
		
		usuarios.add(toUser(result));
		
		//System.out.println(usr);
	}
	return usuarios;
}

	private Usuario toUser(ResultSet result) throws SQLException {
		return new Usuario(result.getInt("idUsuario"),result.getString("nombre"),
				result.getDouble("presupuesto"),result.getDouble("tiempoDisponible") );
	}
}
