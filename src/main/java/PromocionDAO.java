import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PromocionDAO {

	public ArrayList<Promocion> findAll() throws SQLException {

		ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * from promocion;";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while (result.next()) {

			Promocion promocion = new Promocion(result.getInt("id"), result.getString("nombre"),
					result.getString("tipo"), result.getDouble("descuento"), result.getDouble("precio"));

			promocion.setAtracciones(findAtracciones(result.getInt("id")));
			promocion.setTiempoTot(findTiempo(result.getInt("id")));
			promociones.add(promocion);

		}
		return promociones;

	}

	private double findTiempo(int id) throws SQLException {
		double tiempo = -1;

		Connection connection = ConnectionProvider.getConnection();
		String sql = " select sum(atraccion.duracion) as tiempo2 from promocion_atraccion INNER JOIN promocion on\r\n"
				+ " promocion_atraccion.promocion_id = promocion.id INNER JOIN atraccion on atraccion.idAtraccion= promocion_atraccion.atraccion_id\r\n"
				+ " where promocion.id = ?;";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, id);
		ResultSet result = statement.executeQuery();

		while (result.next()) {

			tiempo = result.getDouble("tiempo2");

		}

		if (id == 5 || id == 6) {

			String sql2 = " select sum(atraccion.duracion) as tiempo3 from gratuita_promocionAXB INNER JOIN promocion on\r\n"
					+ "	 gratuita_promocionAXB.promocion_id = promocion.id INNER JOIN atraccion on atraccion.idAtraccion= gratuita_promocionAXB.atraccion_id\r\n"
					+ "	 where promocion.id = ?;";

			statement = connection.prepareStatement(sql2);
			statement.setDouble(1, id);
			result = statement.executeQuery();

			while (result.next()) {
				tiempo += result.getDouble("tiempo3");

			}

		}

		return tiempo;
	}

	public ArrayList<Atraccion> findAtracciones(int id) throws SQLException {

		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		Connection connection = ConnectionProvider.getConnection();
		String sql = "select atraccion.* from promocion_atraccion INNER JOIN promocion on\r\n"
				+ " promocion_atraccion.promocion_id = promocion.id INNER JOIN atraccion on atraccion.idAtraccion= promocion_atraccion.atraccion_id\r\n"
				+ " where promocion.id = ?;";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			atracciones.add(extracted(result));

		}

		if (id == 5 || id == 6) {

			String sql2 = " select atraccion.* from gratuita_promocionAXB INNER JOIN promocion on\r\n"
					+ "	 gratuita_promocionAXB.promocion_id = promocion.id INNER JOIN atraccion on atraccion.idAtraccion= gratuita_promocionAXB.atraccion_id\r\n"
					+ "	 where promocion.id = ?;";

			statement = connection.prepareStatement(sql2);
			statement.setInt(1, id);
			result = statement.executeQuery();

			while (result.next()) {
				atracciones.add(extracted(result));

			}

		}
		return atracciones;

	}

	private Atraccion extracted(ResultSet result) throws SQLException {
		return new Atraccion(result.getInt("idAtraccion"), result.getString("nombre"), result.getDouble("costo"),
				result.getDouble("duracion"), result.getInt("cupo"));
	}

}