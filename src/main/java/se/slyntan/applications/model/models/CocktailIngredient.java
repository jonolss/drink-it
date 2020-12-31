package se.slyntan.applications.model.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CocktailIngredient {
    private Ingredient ingredient;
    private String amount;

    public CocktailIngredient() {
    }

    public CocktailIngredient(Builder builder) {
        this.ingredient = builder.ingredient;
        this.amount = builder.amount;
    }

    public CocktailIngredient(Ingredient ingredient, String amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CocktailIngredient that = (CocktailIngredient) o;
        return Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient);
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public String getAmount() {
        return amount;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public static class Builder {
        private Ingredient ingredient;
        private String amount;

        public Builder () {
        }

        public Builder withIngredient(Ingredient ingredient) {
            this.ingredient = ingredient;
            return this;
        }

        public Builder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public CocktailIngredient build() {
            return new CocktailIngredient(this);
        }
    }
}
