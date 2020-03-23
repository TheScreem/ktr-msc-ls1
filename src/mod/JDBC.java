package mod;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
