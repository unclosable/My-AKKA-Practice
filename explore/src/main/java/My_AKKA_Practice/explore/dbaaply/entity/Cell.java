package My_AKKA_Practice.explore.dbaaply.entity;

import My_AKKA_Practice.explore.dbaaply.enums.CellContentType;

public class Cell {
	private CellContentType cellContentType;
	private Object cellContent;

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
