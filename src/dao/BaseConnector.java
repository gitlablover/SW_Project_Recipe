package dao;

import java.sql.*;

/**
 * Information for connecting to the specific database. Encapsulated methods for
 * starting, closing database connection and executing sql statements.
 * 
 * @author Hanzhi.Zhuang
 *
 */
class BaseConnector {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/cookbook_group1?useSSL=false";
	private static String user = "root";
	private static String password = "123456";

	/**
	 * generate static database driver for the class.
	 */
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	/**
	 * use given URL, user name and password to make connection to the database.
	 * 
	 * @return connection
	 */
	static Connection startConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * close the database connection with the given connection, statement and result
	 * set.
	 * 
	 * @param conn database connection
	 * @param stmt SQL statement
	 * @param rs   result of the SQL statement given by the database
	 * @throws SQLException
	 */
	static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * Encapsulated method for sending a raw SQL statement with parameters and for
	 * retrieving the results.
	 * 
	 * @param preparedSql
	 * @param param       parameters you want to add to the SQL statement.
	 * @return
	 * @throws ClassNotFoundException
	 */
	public int executeSQL(String preparedSql, Object[] param) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = startConnection();
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			ResultSet num = pstmt.executeQuery();
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			try {
				BaseConnector.closeAll(conn, pstmt, null);
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
		return 0;
	}

}
