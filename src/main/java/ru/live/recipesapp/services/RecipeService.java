package ru.live.recipesapp.services;

import ru.live.recipesapp.model.Recipe;

import java.util.Map;
import java.util.Optional;
public interface RecipeService {

    Recipe save(Recipe recipe);

    Optional<Recipe> getById(Long id);

    Recipe update(Long id, Recipe recipe);

    Recipe delete(Long id);

    Map<Long, Recipe> getAll();
}
