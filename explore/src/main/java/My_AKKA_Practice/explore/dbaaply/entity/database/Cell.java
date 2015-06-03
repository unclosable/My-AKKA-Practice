package My_AKKA_Practice.explore.dbaaply.entity.database;

import My_AKKA_Practice.explore.dbaaply.entity.BasicDatabase;
import My_AKKA_Practice.explore.dbaaply.enums.CellContentType;

public class Cell extends BasicDatabase {
	private CellContentType cellContentType;
	private Object cellContent;

	public Cell(CellContentType type, Object cellContent) {
		this.cellContent = cellContent;
		this.cellContentType = type;
	}

	public CellContentType getCellContentType() {
		return cellContentType;
	}

	public void setCellContentType(CellContentType cellContentType) {
		this.cellContentType = cellContentType;
	}

	public Object getCellContent() {
		return cellContent;
	}

	public void setCellContent(Object cellContent) {
		this.cellContent = cellContent;
	}

}
