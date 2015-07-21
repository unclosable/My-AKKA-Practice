package My_AKKA_Practice.funtest.funtestone;

import net.sf.cglib.proxy.Enhancer;

public class BookServiceBean {
	public static BookServiceBean getProxyInstance(MyCglibProxy myProxy) {
		Enhancer en = new Enhancer();
		// 进行代理
		en.setSuperclass(BookServiceBean.class);
		en.setCallback(myProxy);
		// 生成代理实例
		return (BookServiceBean) en.create();
	}

	public void create() {
		System.out.println("create() is running !");
	}

	public void query() {
		System.out.println("query() is running !");
	}

	public void update() {
		System.out.println("update() is running !");
	}

	public void delete() {
		System.out.println("delete() is running !");
	}

}
