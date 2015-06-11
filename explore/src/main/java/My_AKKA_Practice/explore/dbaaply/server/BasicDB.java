package My_AKKA_Practice.explore.dbaaply.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import My_AKKA_Practice.explore.dbaaply.entity.query.QueryCondition;

public abstract class BasicDB {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
		}
	}

	/**
	 * 创建与广州经济技术开发区数据库的链接
	 * 
	 * @return
	 */
	protected Connection getConnection(QueryCondition condition) throws SQLException {
		return DriverManager.getConnection(condition.getHost() + ":"
				+ condition.getPort(), condition.getUserName(),
				condition.getPassWord());
	}

	/**
	 * 执行插入操作
	 * 
	 * @param sql
	 * @return
	 */
	protected boolean executeInsert(String sql, QueryCondition condition) {
		Connection connection = null;
		Statement statement = null;
		boolean re;
		try {
			connection = getConnection(condition);
			statement = connection.createStatement();
			re = statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		} finally {
			closeConnection(statement, connection);
		}
		return re;
	}

	/**
	 * 数据库的改
	 * 
	 * @param sql
	 * @return
	 */
	protected boolean executeUpdate(String sql, QueryCondition condition) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection(condition);
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(statement, connection);
		}
		return true;
	}

	/**
	 * 关闭连接
	 * 
	 * @param connection
	 */
	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
		}
	}

	/**
	 * 
	 * 
	 * @param statement
	 * @param connection
	 */
	public static void closeConnection(Statement statement,
			Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
