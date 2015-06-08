package My_AKKA_Practice.explore.dbaaply.entity.query.feild;

import My_AKKA_Practice.explore.dbaaply.entity.query.Feild;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public class GroupFeild extends Feild {
	private int groupIndex;

	public GroupFeild(String feildName, int groupIndex) {
		super(feildName);
		this.groupIndex = groupIndex;
	}

	public int getGroupIndex() {
		return groupIndex;
	}

	public void setGroupIndex(int groupIndex) {
		this.groupIndex = groupIndex;
	}

	@Override
	protected QueryFeildType initType() {
		return QueryFeildType.GROUP;
	}

}
