package My_AKKA_Practice.funtest;

public class BookServiceFactory {
	private static BookServiceBean service = new BookServiceBean();

	private BookServiceFactory() {
	}

	public static BookServiceBean getInstance() {
		return service;
	}

	public static BookServiceBean getProxyInstance(MyCglibProxy myCglibProxy) {
		return BookServiceBean.getProxyInstance(myCglibProxy);
	}

}
