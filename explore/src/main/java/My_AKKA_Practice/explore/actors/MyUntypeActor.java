package My_AKKA_Practice.explore.actors;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyUntypeActor extends UntypedActor {
	LoggingAdapter log=Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object message) throws Exception {
		if(message instanceof String){
			log.info("receive String message :{}",message);
			getSender().tell(message, getSelf());
		}else
			unhandled(message);
	}

}
