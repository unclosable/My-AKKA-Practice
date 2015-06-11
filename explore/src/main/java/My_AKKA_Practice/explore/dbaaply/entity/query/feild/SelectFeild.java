package My_AKKA_Practice.explore.dbaaply.entity.query.feild;

import My_AKKA_Practice.explore.dbaaply.entity.query.QueryFeild;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public class SelectFeild extends QueryFeild {

	public SelectFeild(String feildName) {
		super(feildName);
	}

	@Override
	protected QueryFeildType initType() {
		return QueryFeildType.SELECT;
	}

}
