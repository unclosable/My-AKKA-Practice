package My_AKKA_Practice.explore.dbaaply.entity.query.feild;

import My_AKKA_Practice.explore.dbaaply.entity.query.Feild;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public class RemarkFeild extends Feild {

	private String remark;

	public RemarkFeild(String feildName, String remarkStr) {
		super(feildName);
		this.remark = remarkStr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	protected QueryFeildType initType() {
		return QueryFeildType.REMARK;
	}
}
