package My_AKKA_Practice.funtest;

public class Client {

	public static void main(String[] args) {
		// BookServiceBean service = BookServiceFactory.getInstance();
		BookServiceBean service = BookServiceFactory
				.getProxyInstance(new MyCglibProxy("boss"));
		// service.create();
		// BookServiceBean service2 = BookServiceFactory
		// .getProxyInstance(new MyCglibProxy("john"));
		// service2.create();
		doMethod(service);
	}

	public static void doMethod(BookServiceBean service) {
		service.create();
		service.update();
		service.query();
		service.delete();
	}

}
