package cz.codingmonkey.observer.events;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * @author Richard Stefanca
 */
public class EventBus {

    private final Subject<Event, Event> bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Event event) {
        bus.onNext(event);
    }

    public Observable<Event> eventObservable() {
        return bus;
    }
}
