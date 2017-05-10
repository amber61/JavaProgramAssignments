import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TunaFishesDatabaseReader {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionString = "jdbc:mysql://localhost/tunafishes";
		String username = "scott";
		String password = "tiger";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			connection = DriverManager.getConnection(connectionString, username,
					password);
			statement = connection.prepareStatement(
					"SELECT TunaID, GenusName, SpeciesName, CommonName, MaxWeight, IUCNstatus FROM tunas ORDER BY TunaID");
			resultset = statement.executeQuery();
			while (resultset.next()) {
				System.out.printf("%d %s %s %s %d %s%n",
						// new-line
						resultset.getInt("TunaID"),
						resultset.getString("GenusName"),
						resultset.getString("SpeciesName"),
						resultset.getString("CommonName"),
						resultset.getInt("MaxWeight"),
						resultset.getString("IUCNstatus"));
			}
		} catch (SQLException e) {
			System.err.println("Problem accessing database");
			System.err.println(e.getMessage());
		} finally { // most important lines in this entire program!!!
			try {
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}

			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} // close try-catch
	}

}
