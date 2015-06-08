package My_AKKA_Practice.explore.dbaaply.entity.query.feild;

import My_AKKA_Practice.explore.dbaaply.entity.query.Feild;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public class SelectFeild extends Feild {

	public SelectFeild(String feildName) {
		super(feildName);
	}

	@Override
	protected QueryFeildType initType() {
		return QueryFeildType.SELECT;
	}

}
