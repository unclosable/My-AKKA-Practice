package My_AKKA_Practice.explore.dbaaply.entity.database;

import java.util.List;

public class Table extends BasicDatabase {
	private String tableName;

	public Table(List<BasicDatabase> children, String tableName) {
		for (BasicDatabase child : children) {
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
