package My_AKKA_Practice.explore.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.Creator;

class ActorCreater implements Creator<MyUntypeActor> {
	static class a {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public MyUntypeActor create() throws Exception {
		// TODO Auto-generated method stub
		return new MyUntypeActor();
	}

	public void test() {
		Props props1 = Props.create(MyUntypeActor.class);
		Props props2 = Props.create(MyUntypeActor.class, new ActorCreater());
		Props props3 = Props.create(new ActorCreater());

		ActorSystem system = ActorSystem.create("try");
		ActorRef actorRef = system.actorOf(props1, "MyUntypeActor");
		actorRef.tell("xxx", ActorRef.noSender());
	}

}
