package cz.codingmonkey.observer.observers;


import cz.codingmonkey.observer.domain.Identity;
import cz.codingmonkey.observer.events.EntityChangedEvent;
import cz.codingmonkey.observer.events.Event;
import cz.codingmonkey.observer.events.EventSubscriber;
import rx.Observable;
import rx.Subscription;

/**
 * @author Richard Stefanca
 */
public class SystemWithEmailAttribute implements EventSubscriber {

    private String name;

    public SystemWithEmailAttribute(String name) {
        this.name = name;
    }

    public Subscription subscribe(Observable<Event> observable) {
        return observable.subscribe(event -> {
            if (event instanceof EntityChangedEvent) { //listens only to changed entities
                EntityChangedEvent entityChangedEvent = (EntityChangedEvent) event;
                if (entityChangedEvent.contains("email")) {
                    changeEmail(((Identity) entityChangedEvent.getEntity()));
                }
            }
        });
    }

    private void changeEmail(Identity entity) {
        System.out.println("Changing email of " + entity.getName() + " in system " + name);
    }
}
