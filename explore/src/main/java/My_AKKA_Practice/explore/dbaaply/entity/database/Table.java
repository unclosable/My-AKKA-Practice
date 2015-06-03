package My_AKKA_Practice.explore.dbaaply.entity.database;

import java.util.List;

import My_AKKA_Practice.explore.dbaaply.entity.BasicDatabase;

public class Table<T extends BasicDatabase> extends BasicDatabase {
	private String tableName;

	public Table(List<T> children, String tableName) {
		for (T child : children) {
			this.add(child);
		}
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
