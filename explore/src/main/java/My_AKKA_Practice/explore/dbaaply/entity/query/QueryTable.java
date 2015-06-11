package My_AKKA_Practice.explore.dbaaply.entity.query;

import java.util.ArrayList;
import java.util.List;

import My_AKKA_Practice.explore.dbaaply.Iterator.FeildIterator;
import My_AKKA_Practice.explore.dbaaply.Iterator.impl.FeildIteratorImpl;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public class QueryTable {
	private String tableName;
	private List<QueryFeild> feilds;

	public QueryTable(String tableName) {
		this.tableName = tableName;
		this.feilds = new ArrayList<QueryFeild>();
	}

	public void addFeild(QueryFeild feild) {
		this.feilds.add(feild);
	}

	public String toString() {
		return this.tableName;
	}

	public List<String> getFeildsString() {
		List<String> feilds = new ArrayList<String>();
		if (!this.feilds.isEmpty())
			for (QueryFeild feild : this.feilds) {
				feilds.add(tableName + "." + feild.getFeildName());
			}
		return feilds;
	}

	private String getQueryFeildsName(QueryFeild feild) {
		return tableName + "." + feild.getQueryStr();
	}

	public List<QueryFeild> getFeildIterms() {
		List<QueryFeild> feilds = new ArrayList<QueryFeild>();
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
			QueryFeild feild = iterator.next();
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

	public List<QueryFeild> getFeilds() {
		return feilds;
	}

	public void setFeilds(List<QueryFeild> feilds) {
		this.feilds = feilds;
	}
}
