package My_AKKA_Practice.explore.dbaaply.entity.query.feild;

import My_AKKA_Practice.explore.dbaaply.entity.query.QueryFeild;
import My_AKKA_Practice.explore.dbaaply.enums.OrderType;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public class OrderFeild extends QueryFeild {

	private OrderType orderType; // 排序的类型，正序or倒序
	private int orderIndex;// 排序的先后顺序

	public OrderFeild(String feildName, OrderType orderType, int orderIndex) {
		super(feildName);
		this.orderIndex = orderIndex;
		this.orderType = orderType;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	@Override
	protected QueryFeildType initType() {
		return QueryFeildType.ORDER;
	}

	@Override
	public String getQueryStr() {
		String str = "";
		switch (this.orderType) {
		case ASC:
			str = getFeildName() + "ASC";
			break;
		case DESC:
			str = getFeildName() + "DESC";
			break;
		default:
			break;
		}
		return str;
	}

}
