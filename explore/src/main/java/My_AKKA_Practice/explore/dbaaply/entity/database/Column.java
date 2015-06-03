package My_AKKA_Practice.explore.dbaaply.entity.database;

import java.util.List;

import My_AKKA_Practice.explore.dbaaply.entity.BasicDatabase;

public class Column extends BasicDatabase {
	private String columnName;

	public Column(List<Cell> cells, String columnName) {
		for (Cell cell : cells) {
			this.add(cell);
		}
		this.columnName = columnName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

}
