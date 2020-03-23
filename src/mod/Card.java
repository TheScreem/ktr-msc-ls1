package mod;

import java.sql.SQLException;
import java.sql.Statement;

public class Card
{
	private int id;
	private String name;
	private String companyName;
	private String email;
	private String phoneNumber;

	public Card(String name, String companyName, String email, String phoneNumber)
	{
		this.name = name;
		this.companyName = companyName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void save()
	{
		try {
		Statement statement = JDBC.Connexion();
		String stmt = "INSERT INTO card(name, email, company_name, phone_number) VALUES ('" + this.name + "', '" + this.email + "', '" + this.companyName + "', '" + this.phoneNumber + "') ";
		statement.executeQuery(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
