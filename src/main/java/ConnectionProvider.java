import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
		
		private static Connection connection ;
		
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:sqlite:TierraMedia2.db";
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}
	
	public static void close() throws SQLException
	{
		connection.close();
	}
}
