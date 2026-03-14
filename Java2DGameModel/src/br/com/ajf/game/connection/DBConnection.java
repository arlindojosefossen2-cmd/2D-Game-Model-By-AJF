package br.com.ajf.game.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DBConnection.
 */
public final class DBConnection
{
	/** The connection. */
	public static Connection connection;
	
	/**
	 * Instantiates a new DB connection.
	 */
	private DBConnection()
	{
		
	}
	
	/**
	 * Gets the connection.
	 *
	 * @param sqliteJDBC the sqlite JDBC
	 * @param url the url
	 * @return the connection
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static Connection getConnection(String sqliteJDBC, String url) throws ClassNotFoundException, SQLException
	{
		Class.forName(sqliteJDBC);
		
		if(connection == null)
		{
			connection = DriverManager.getConnection(url);
		}
		
		return connection;
	}
	
	/**
	 * Close connection.
	 *
	 * @param connection the connection
	 * @throws SQLException the SQL exception
	 */
	public static void closeConnection(Connection connection) throws SQLException
	{
		if(connection != null)
		{
			connection.close();
		}
	}
	
	/**
	 * Close connection.
	 *
	 * @param connection the connection
	 * @param statement the statement
	 * @throws SQLException the SQL exception
	 */
	public static void closeConnection(Connection connection,PreparedStatement statement) throws SQLException
	{
		
		closeConnection(connection);
		
		if(statement != null)
		{
			statement.close();
		}
	}
	
	/**
	 * Close connection.
	 *
	 * @param connection the connection
	 * @param statement the statement
	 * @param result the result
	 * @throws SQLException the SQL exception
	 */
	public static void closeConnection(Connection connection,PreparedStatement statement,ResultSet result) throws SQLException
	{
		closeConnection(connection, statement);
		
		if(result != null)
		{
			result.close();
		}
	}
	
}