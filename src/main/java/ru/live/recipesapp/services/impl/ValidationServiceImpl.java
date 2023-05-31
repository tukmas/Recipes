package ru.live.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.live.recipesapp.model.Ingredient;
import ru.live.recipesapp.model.Recipe;
import ru.live.recipesapp.services.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Recipe recipe) {
        return recipe == null
                || recipe.getName() == null
                || StringUtils.isEmpty(recipe.getName())
                || recipe.getSteps() == null
                || recipe.getIngredients() == null
                || recipe.getIngredients().isEmpty()
                || recipe.getSteps().isEmpty();
    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient == null
                || ingredient.getName() == null
                || StringUtils.isEmpty(ingredient.getName());
    }
}
