package mod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Card
{
	private Integer id;
	private String name;
	private String companyName;
	private String email;
	private String phoneNumber;

	public Card(Integer id, String name, String companyName, String email, String phoneNumber)
	{
		this.id = id;
		this.name = name;
		this.companyName = companyName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void save()
	{
		try {
		Statement statement = JDBC.Connexion();
		String stmt;

		if (this.id == null)
		{
			stmt = "INSERT INTO card(name, email, company_name, phone_number) VALUES ('" + this.name + "', '" + this.email + "', '" + this.companyName + "', '" + this.phoneNumber + "') ";
		}
		else
		{
			stmt = "UPDATE card SET name = '" + this.name + "', email = '" + this.email + "', company_name = '" + this.companyName + "', phone_number = '" + this.phoneNumber + "' WHERE id = " + this.id;
		}
		statement.executeQuery(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Card getCardProfile()
	{
		try {
			Statement statement = JDBC.Connexion();

			String stmt = "select * from card WHERE id = " + 1 + "";
			ResultSet result  = statement.executeQuery(stmt);

			while (result.next())
			{
				Card card = new Card(result.getInt("id"), result.getString("name"), result.getString("company_name"), result.getString("email"), result.getString("phone_number"));
				return card;
			}
			result.close();


		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyNae)
	{
		this.companyName = companyNae;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
