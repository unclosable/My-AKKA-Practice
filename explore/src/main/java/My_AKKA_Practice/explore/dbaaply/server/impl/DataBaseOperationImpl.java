package My_AKKA_Practice.explore.dbaaply.server.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import My_AKKA_Practice.explore.dbaaply.entity.database.Table;
import My_AKKA_Practice.explore.dbaaply.entity.query.QueryCondition;
import My_AKKA_Practice.explore.dbaaply.server.BasicDB;
import My_AKKA_Practice.explore.dbaaply.server.DataBaseOperation;
import My_AKKA_Practice.explore.dbaaply.util.SQLStrMaker;

public class DataBaseOperationImpl extends BasicDB implements DataBaseOperation {

	@Override
	public Table singleTableQuery(QueryCondition condition) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection(condition);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQLStrMaker
					.getSingleTableSelectSQL(condition));
			Table re = packagingToRowTable(resultSet);
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private Table packagingToRowTable(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		for (int i = 1; i <= columns; i++) {
			rsmd.getColumnName(i);
			rsmd.getColumnClassName(i);
		}

		return null;
	}

}
