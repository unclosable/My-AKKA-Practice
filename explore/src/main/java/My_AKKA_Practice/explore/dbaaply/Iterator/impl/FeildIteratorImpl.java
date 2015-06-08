package My_AKKA_Practice.explore.dbaaply.Iterator.impl;

import java.util.List;

import My_AKKA_Practice.explore.dbaaply.Iterator.FeildIterator;
import My_AKKA_Practice.explore.dbaaply.entity.query.Feild;
import My_AKKA_Practice.explore.dbaaply.entity.query.Table;
import My_AKKA_Practice.explore.dbaaply.enums.QueryFeildType;

public class FeildIteratorImpl implements FeildIterator {
	private int index;
	private QueryFeildType queryFeildType;
	private Table table;

	public FeildIteratorImpl(QueryFeildType queryFeildType, Table table) {
		this.index = -1;
		this.queryFeildType = queryFeildType;
		this.table = table;
	}

	@Override
	public boolean hasNext() {
		return findNextIdx() != -1;
	}

	@Override
	public Feild next() {
		this.index = findNextIdx();
		if (this.index != -1)
			return this.table.getFeildIterms().get(this.index);
		return null;
	}

	private int findNextIdx() {
		List<Feild> feilds = this.table.getFeildIterms();
		boolean find = false;
		int tempIdx = this.index;
		while (!find) {
			tempIdx++;
			if (tempIdx >= feilds.size()) {
				tempIdx = -1;
				break;
			}
			if (feilds.get(tempIdx).getFeildType().equals(this.queryFeildType)) {
				break;
			}
		}
		return tempIdx;
	}

}
