package My_AKKA_Practice.explore.dbaaply.entity.query;

import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public abstract class Feild {
	private String feildName;
	private QueryFeildType feildType;

	public Feild(String feildName) {
		this.feildName = feildName;
		this.feildType = initType();
	}

	protected abstract QueryFeildType initType();

	public String getQueryStr() {
		return getFeildName();
	};

	public String getFeildName() {
		return feildName;
	}

	public void setFeildName(String feildName) {
		this.feildName = feildName;
	}

	public QueryFeildType getFeildType() {
		return feildType;
	}

	public void setFeildType(QueryFeildType feildType) {
		this.feildType = feildType;
	}

}
