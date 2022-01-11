package com.cesar.tacobell.data;

import com.cesar.tacobell.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    // No hace falta implementarlos, Spring lo hace por nosotros en tiempo de ejecución (https://www.youtube.com/watch?v=Vq19TwXfRco)
}
