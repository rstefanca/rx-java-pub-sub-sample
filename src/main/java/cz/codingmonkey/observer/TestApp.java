package cz.codingmonkey.observer;

import cz.codingmonkey.observer.domain.Identity;
import cz.codingmonkey.observer.events.EntityChangedEvent;
import cz.codingmonkey.observer.events.EventBus;
import cz.codingmonkey.observer.events.EventSubscriber;
import cz.codingmonkey.observer.observers.SystemWithEmailAttribute;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author Richard Stefanca
 */
public class TestApp {
    private static EventBus eventBus = new EventBus();

    public static void main(String[] args) throws Exception {

        EventSubscriber system = new SystemWithEmailAttribute("medea");
        system.subscribe(eventBus.eventObservable());

        eventBus.eventObservable().subscribe(System.out::println); //logging subscription

        IntStream.range(0,10)
                .mapToObj(i -> new Identity("identity" + i).withEmail("dummy@gmail.com"))
                .parallel()
                .forEach(TestApp::updateIdentity);

        System.out.println("done");
    }

    private static void updateIdentity(Identity identity) {
        Set<String> changedFields = new HashSet<>();
        identity.addPropertyChangeListener(evt -> changedFields.add(evt.getPropertyName()));

        // we change the entity
        identity.setEmail("johndoe@gmail.com");
        identity.setFirstName("john");

        if (!changedFields.isEmpty()) {
            //persist()
            eventBus.send(new EntityChangedEvent<>(identity, changedFields));
        }
    }
}
