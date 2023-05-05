package ru.live.recipesapp.services;

import ru.live.recipesapp.model.Ingredient;

import java.util.Optional;
public interface IngredientService {

        Ingredient save(Ingredient ingredient);

        Optional<Ingredient> getById(Long id);
}

