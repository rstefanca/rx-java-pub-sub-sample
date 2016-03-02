package cz.codingmonkey.observer.events;

import rx.Observable;
import rx.Subscription;

/**
 * @author Richard Stefanca
 */
@FunctionalInterface
public interface EventSubscriber {

    Subscription subscribe(Observable<Event> observable);
}
