package se.slyntan.applications.model.models;

import java.util.List;

public class User {

    private String name;
    private List<String> ownedIngredients;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getOwnedIngredients() {
        return ownedIngredients;
    }

    public void setOwnedIngredients(List<String> ownedIngredients) {
        this.ownedIngredients = ownedIngredients;
    }
}
