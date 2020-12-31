package se.slyntan.applications.model.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cocktail {

    private String name;
    private List<CocktailIngredient> cocktailIngredients;

    public Cocktail() {}

    public Cocktail(Builder builder) {
        this.name = builder.name;
        this.cocktailIngredients = builder.cocktailIngredients;
    }

    public Cocktail(String name, List<CocktailIngredient> cocktailIngredients) {
        this.name = name;
        this.cocktailIngredients = cocktailIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cocktail cocktail = (Cocktail) o;
        return Objects.equals(name, cocktail.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public List<CocktailIngredient> getIngredients() {
        return cocktailIngredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CocktailIngredient> getCocktailIngredients() {
        return cocktailIngredients;
    }

    public void setCocktailIngredients(List<CocktailIngredient> cocktailIngredients) {
        this.cocktailIngredients = cocktailIngredients;
    }

    public static class Builder {
        private String name;
        private List<CocktailIngredient> cocktailIngredients;

        public Builder () {
            cocktailIngredients = new ArrayList<>();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCocktailIngredient(CocktailIngredient cocktailIngredient) {
            cocktailIngredients.add(cocktailIngredient);
            return this;
        }

        public Cocktail build() {
            return new Cocktail(this);
        }
    }
}
