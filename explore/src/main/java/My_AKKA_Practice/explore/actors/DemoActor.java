package My_AKKA_Practice.explore.actors;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;

public class DemoActor extends UntypedActor {

	public static Props prop(final int num) {
		return Props.create(new Creator<DemoActor>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public DemoActor create() throws Exception {
				return new DemoActor(num);
			}
		});
	}

	final int num;

	public DemoActor(int num) {
		this.num = num;
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		// TODO Auto-generated method stub

	}

}
