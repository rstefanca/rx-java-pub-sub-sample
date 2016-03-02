package cz.codingmonkey.observer;

import cz.codingmonkey.observer.domain.Identity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Richard Stefanca
 */
public class ObservableIdentityTest {

    @Test
    public void fire_when_property_is_changed() {
        Identity john = new Identity("john");

        List<String> changedFields = new ArrayList<>();

        john.addPropertyChangeListener(evt -> {
            System.out.println(evt);
            changedFields.add(evt.getPropertyName());
        });

        john.setName("peter");
        john.setEmail("peter@bcvsoulutions.eu");

        assertEquals(changedFields.get(0), "name");
        assertEquals(changedFields.get(1), "email");

    }

    @Test
    public void no_change_event_fired_when_same_value_is_set() {
        Identity john = new Identity("john");
        List<String> changedFields = new ArrayList<>();
        john.addPropertyChangeListener(evt -> changedFields.add(evt.getPropertyName()));
        john.setName("john");
        assertEquals(0, changedFields.size());
    }
}