package My_AKKA_Practice.explore.dbaaply.util;

import My_AKKA_Practice.explore.dbaaply.entity.query.QueryCondition;

public class SQLStrMaker {

	public static String getSingleTableSelectSQL(QueryCondition condition) {
		StringBuilder sql = new StringBuilder("select ");
		sql.append(condition.getSelectFeildStr());

		sql.append(" from ");

		sql.append(condition.getSelectTableStr());

		sql.append(" where ");

		sql.append(condition.getSelectTimeStr());
		switch (condition.getTimeFeildType()) {
		case JAVA_DOUBLE:
			sql.append(String.format("between %d and %d", condition.getsTime(),
					condition.geteTime()));
			break;
		case UNIX_DOUBLE:
			sql.append(String.format("between %d and %d",
					condition.getsTime() / 1000, condition.geteTime() / 1000));
			break;
		case DATE_TIME:
			sql.append(String.format("between '%tF %tT' and '%tF %tT'",
					condition.getsTime(), condition.getsTime(),
					condition.geteTime(), condition.geteTime()));
			break;
		default:
			return null;
		}

		sql.append(" order by ");

		sql.append(condition.getSelectOrderStr());

		sql.append(" group by ");

		sql.append(condition.getSelectGroupStr());
		return sql.toString();
	}
}
