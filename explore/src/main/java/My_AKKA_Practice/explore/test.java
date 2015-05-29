package My_AKKA_Practice.explore;

import My_AKKA_Practice.explore.Pi.Listener;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class test {

	public static void main(String[] args) {
		ActorSystem system=ActorSystem.create();

		System.out.println(1);
		ActorRef helloWorld=system.actorOf(new Props(HelloWorld.class), "listener");

		System.out.println(2);
		helloWorld.tell("sdf");
		System.out.println(3);
		
	}

}
