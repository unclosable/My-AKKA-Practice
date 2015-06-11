package My_AKKA_Practice.explore.dbaaply.Iterator;

import My_AKKA_Practice.explore.dbaaply.entity.query.QueryFeild;

public interface FeildIterator {
	boolean hasNext();

	QueryFeild next();

}
