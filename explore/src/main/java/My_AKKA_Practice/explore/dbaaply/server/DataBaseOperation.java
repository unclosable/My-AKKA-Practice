package My_AKKA_Practice.explore.dbaaply.server;

import My_AKKA_Practice.explore.dbaaply.entity.database.Table;
import My_AKKA_Practice.explore.dbaaply.entity.query.QueryCondition;

public interface DataBaseOperation {
	/**
	 * 理论上是支持多表一起查的，现阶段Condition没有加入多表链接条件，先写单表的查询
	 * 
	 * @param condition
	 * @return
	 */
	Table singleTableQuery(QueryCondition condition);

}
