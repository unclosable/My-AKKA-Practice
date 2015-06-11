package My_AKKA_Practice.explore.dbaaply.entity.query.feild;

import My_AKKA_Practice.explore.dbaaply.entity.query.QueryFeild;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;
import My_AKKA_Practice.explore.dbaaply.enums.TimeFeildType;

public class TimeFeild extends QueryFeild {

	private TimeFeildType timeFeildType;

	public TimeFeild(String feildName, TimeFeildType timeFeildType) {
		super(feildName);
		this.timeFeildType = timeFeildType;
	}

	public TimeFeildType getTimeFeildType() {
		return timeFeildType;
	}

	public void setTimeFeildType(TimeFeildType timeFeildType) {
		this.timeFeildType = timeFeildType;
	}

	@Override
	protected QueryFeildType initType() {
		return QueryFeildType.TIME;
	}
}
