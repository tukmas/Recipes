package ru.live.recipesapp.model;
import java.util.List;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private int cookingTime;
    protected List<Ingredient> ingredients;
    private List<String> steps;

    @Override
    public String toString() {
        return name + "\n Время приготовления: " + cookingTime;
    }
}
