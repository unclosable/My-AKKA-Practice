package My_AKKA_Practice.explore.dbaaply.entity.query;

import java.util.ArrayList;
import java.util.List;

import My_AKKA_Practice.explore.dbaaply.Iterator.FeildIterator;
import My_AKKA_Practice.explore.dbaaply.Iterator.impl.FeildIteratorImpl;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public class Table {
	private String tableName;
	private List<Feild> feilds;

	public Table(String tableName) {
		this.tableName = tableName;
		this.feilds = new ArrayList<Feild>();
	}

	public void addFeild(Feild feild) {
		this.feilds.add(feild);
	}

	public String toString() {
		return this.tableName;
	}

	public List<String> getFeildsString() {
		List<String> feilds = new ArrayList<String>();
		if (!this.feilds.isEmpty())
			for (Feild feild : this.feilds) {
				feilds.add(tableName + "." + feild.getFeildName());
			}
		return feilds;
	}

	private String getQueryFeildsName(Feild feild) {
		return tableName + "." + feild.getQueryStr();
	}

	public List<Feild> getFeildIterms() {
		List<Feild> feilds = new ArrayList<Feild>();
		feilds.addAll(this.feilds);
		return feilds;
	}

	private FeildIterator getIterator(QueryFeildType feildType) {
		return new FeildIteratorImpl(feildType, this);
	}

	public String getQueryString(QueryFeildType feildType) {
		FeildIterator iterator = getIterator(feildType);
		String str = "";
		boolean first = true;
		while (iterator.hasNext()) {
			Feild feild = iterator.next();
			if (!first)
				str += ",";
			str += getQueryFeildsName(feild);
			first &= false;
		}
		return str;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Feild> getFeilds() {
		return feilds;
	}

	public void setFeilds(List<Feild> feilds) {
		this.feilds = feilds;
	}
}
