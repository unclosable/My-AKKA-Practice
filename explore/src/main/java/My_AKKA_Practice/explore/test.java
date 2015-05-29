package My_AKKA_Practice.explore;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class test {

	public static void main(String[] args) {
		ActorSystem system=ActorSystem.create();


//		Address address=new Address("akka", "sys", "host", 1234);
//		
//		ActorRef ref = system.actorOf(new Props(HelloWorld.class).withDeploy(new Deploy(new RemoteScope(address))));
		
	}

}
