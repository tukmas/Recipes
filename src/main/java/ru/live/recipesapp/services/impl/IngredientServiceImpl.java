package ru.live.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import ru.live.recipesapp.exception.ValidationException;
import ru.live.recipesapp.model.Ingredient;
import ru.live.recipesapp.model.Recipe;
import ru.live.recipesapp.services.IngredientService;
import ru.live.recipesapp.services.ValidationService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private static long idCounter = 1;
    private final Map<Long, Ingredient> ingredients = new HashMap<>();
    private final ValidationService validationService;

    public IngredientServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredients.put(idCounter++, ingredient);
    }

    @Override
    public Optional<Ingredient> getById(Long id) {

        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public Ingredient update(Long id, Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }
        return ingredients.replace(id, ingredient);
    }

    @Override
    public Ingredient delete(Long id) {
        return ingredients.remove(id);
    }

    @Override
    public Map<Long, Ingredient> getAll() {
        return ingredients;
    }
}