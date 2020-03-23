package mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC
{
	private static final String user = "postgres";
	private static final String passwd = "root";
	private static final String url = "jdbc:postgresql://localhost:5432/CardManager";

    public static Statement Connexion()
    {
    	Statement statement = null;
        try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url,user,passwd);
	        statement = connection.createStatement();
	        System.out.println("Connected");
		}
        catch (ClassNotFoundException | SQLException e)
        {
			e.printStackTrace();
		}

        return statement;
    }

    public static int Login(String email, String password)
    {
    	try {
			Statement statement = JDBC.Connexion();

			String stmt = "select id from card WHERE email = '" + email + "' AND password = MD5('" + password + "')";
			ResultSet result  = statement.executeQuery(stmt);

			while (result.next())
			{
				return result.getInt("id");
			}
			result.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
    	return -1;
    }
}
