import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PromocionDAO {
	
	public ArrayList<Promocion> findAll() throws SQLException {

		ArrayList<Promocion> promociones = new ArrayList<Promocion>();
		
	Connection connection = ConnectionProvider.getConnection();
	String sql ="select * from promocion;";
	
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet result = statement.executeQuery();
	
	while (result.next()) {
	
		Promocion promocion= new Promocion (result.getInt("id"),result.getString("nombre"),
				result.getString("tipo"),result.getDouble("descuento"),
                result.getDouble("precio") );
		
		/*promocion.setId(result.getInt("id"));
		promocion.setNombre(result.getString("nombre"));
		promocion.setTipo(result.getString("tipo"));
		promocion.setDescuento(result.getDouble("descuento"));
		promocion.setTot(result.getDouble("precio"));*/
		
		promociones.add(promocion);
		
		//System.out.println(usr);
	}
	return promociones;
}
}