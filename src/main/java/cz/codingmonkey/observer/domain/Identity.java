package cz.codingmonkey.observer.domain;

/**
 * @author Richard Stefanca
 */
public class Identity extends AbstractObservableEntity {

    private String name;
    private String email;
    private String firstName;

    public Identity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        firePropertyChange("name", this.name, name);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        firePropertyChange("email", this.email, email);
        this.email = email;
    }

    public Identity withEmail(String email) {
        setEmail(email);
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firePropertyChange("firstName", this.firstName, firstName);
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
