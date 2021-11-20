import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class atraccionDAO {
	
	public ArrayList<Atraccion> findAll() throws SQLException {

		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		
	Connection connection = ConnectionProvider.getConnection();
	String sql ="select * from atraccion;";
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet result = statement.executeQuery();
	while (result.next()) {
	
		//Atraccion atr= extracted(result);
		
		/*usr.setId(result.getInt("idUsuario"));
		usr.setNombre(result.getString("nombre"));
		usr.setPresupuesto(result.getDouble("presupuesto"));
		usr.setTiempoDisponible(result.getDouble("tiempoDisponible"));*/
		
		atracciones.add(extracted(result));
		
		//System.out.println(usr);
	}
	
	return atracciones;
}

	private Atraccion extracted(ResultSet result) throws SQLException {
		return new Atraccion(result.getInt("idAtraccion"),result.getString("nombre"),
				result.getDouble("costo"),result.getDouble("duracion"), result.getInt("cupo") );
	}

}
