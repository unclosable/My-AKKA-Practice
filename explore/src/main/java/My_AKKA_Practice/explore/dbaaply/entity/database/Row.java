package My_AKKA_Practice.explore.dbaaply.entity.database;

import java.util.List;

import My_AKKA_Practice.explore.dbaaply.entity.BasicDatabase;

public class Row extends BasicDatabase {
	private int primaryKey;
	private List<String> fieldNames;

	public Row(List<Cell> cells, List<String> fieldNames, String primaryKey) {
		if (cells.size() != fieldNames.size())
			return;
		for (Cell cell : cells) {
			this.add(cell);
		}
		this.fieldNames = fieldNames;
		for (int i = 0; i > fieldNames.size(); i++) {
			if (fieldNames.get(i).equals(primaryKey)) {
				this.primaryKey = i;
				break;
			}
		}
	}

	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
	}

}
