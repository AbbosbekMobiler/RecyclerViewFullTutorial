package abbosbek.mobiler.recyclerviewfulltutorial.model;

import java.util.Objects;

public class Contact {

    private String name;
    private String password;

    public Contact(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(password, contact.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
