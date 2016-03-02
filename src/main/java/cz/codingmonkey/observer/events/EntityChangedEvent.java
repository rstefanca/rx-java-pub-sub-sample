package cz.codingmonkey.observer.events;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Richard Stefanca
 */
public class EntityChangedEvent<T> implements Event {

    private final T entity;
    private final Set<String> changedFields = new HashSet<>();

    public EntityChangedEvent(T entity, Set<String> changedFields) {
        this.entity = entity;
        this.changedFields.addAll(changedFields);
    }

    public T getEntity() {
        return entity;
    }

    public Set<String> getChangedFields() {
        return changedFields;
    }

    public boolean contains(String field) {
        return changedFields.contains(field);
    }

    @Override
    public String toString() {
        return "EntityChangedEvent{" +
                "entity=" + entity +
                ", changedFields=" + changedFields +
                '}';
    }
}
