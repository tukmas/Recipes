package ru.live.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.live.recipesapp.model.Ingredient;
import ru.live.recipesapp.services.IngredientService;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
@Tag(name = "API по работе с ингридиентами", description = "CRUD - операции для ингридиентов")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @Operation(
            summary = "Сохранение ингредиентов"
    )
    @PostMapping
    public ResponseEntity<Ingredient> save(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.save(ingredient));
    }
    @Operation(
            summary = "Получение ингредиента по id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getById(@PathVariable Long id) {
        return ResponseEntity.of(ingredientService.getById(id));
    }
    @Operation(
            summary = "Обновление ингредиента"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.update(id, ingredient));
    }
    @Operation(
            summary = "Удаление ингредиента"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientService.delete(id));
    }
    @Operation(
            summary = "Получение всех ингредиентов"
    )
    @GetMapping
    public ResponseEntity<Map<Long, Ingredient>> getAll() {
        return ResponseEntity.ok(ingredientService.getAll());
    }
}
