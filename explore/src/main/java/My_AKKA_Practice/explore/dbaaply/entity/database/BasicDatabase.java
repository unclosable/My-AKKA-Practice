package My_AKKA_Practice.explore.dbaaply.entity.database;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicDatabase {
	private List<BasicDatabase> children = new ArrayList<BasicDatabase>();

	public void add(BasicDatabase basicDatabase) {
		children.add(basicDatabase);
	}

	public int count() {
		return children.size();
	}

}
