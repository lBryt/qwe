package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final User EMPTY = new User();
    private String name;
    private String pasport;

    private User() {
    }

    public User(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }

    public String getName() {
        return name;
    }

    public String getPasport() {
        return pasport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return pasport != null ? pasport.equals(user.pasport) : user.pasport == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pasport != null ? pasport.hashCode() : 0);
        return result;
    }
}
