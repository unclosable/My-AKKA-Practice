package My_AKKA_Practice.explore.dbaaply.entity.query;

import java.util.List;

import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;
import My_AKKA_Practice.explore.dbaaply.enums.TimeFeildType;

public class QueryCondition {
	private String host;
	private int port;
	private String dataBaseName;
	private String userName;
	private String passWord;
	private List<QueryTable> tables;
	private Long sTime;
	private Long eTime;
	private TimeFeildType timeFeildType;

	public String getSelectFeildStr() {
		return getFeildStr(QueryFeildType.SELECT);
	}

	public String getSelectTableStr() {
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (QueryTable queryTable : tables) {
			if (!first)
				builder.append(",");
			builder.append(queryTable.getTableName());
			first &= false;
		}
		return builder.toString();
	}

	public String getSelectJoinStr() {// 表的链接查询，尚未设计
		return null;
	}

	public String getSelectTimeStr() {
		return getFeildStr(QueryFeildType.TIME);
	}

	public String getSelectOrderStr() {
		return getFeildStr(QueryFeildType.ORDER);
	}

	public String getSelectGroupStr() {
		return getFeildStr(QueryFeildType.GROUP);
	}

	public String getSelectRemarkStr() {
		return getFeildStr(QueryFeildType.REMARK);
	}

	private String getFeildStr(QueryFeildType feildType) {
		StringBuilder builder = new StringBuilder();
		for (QueryTable queryTable : tables) {
			builder.append(queryTable.getQueryString(feildType));
		}
		return builder.toString();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<QueryTable> getTables() {
		return tables;
	}

	public void setTables(List<QueryTable> tables) {
		this.tables = tables;
	}

	public Long getsTime() {
		return sTime;
	}

	public void setsTime(Long sTime) {
		this.sTime = sTime;
	}

	public Long geteTime() {
		return eTime;
	}

	public void seteTime(Long eTime) {
		this.eTime = eTime;
	}

	public TimeFeildType getTimeFeildType() {
		return timeFeildType;
	}

	public void setTimeFeildType(TimeFeildType timeFeildType) {
		this.timeFeildType = timeFeildType;
	}

}
