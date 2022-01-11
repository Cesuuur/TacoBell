package com.cesar.tacobell.web;

import com.cesar.tacobell.Ingredient;
import com.cesar.tacobell.Ingredient.Type;
import com.cesar.tacobell.data.IngredientRepository;
import com.cesar.tacobell.Taco;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
//Order se guarda entre diferentes "vistas" a nivel de sesión (creo que order = taco + order)
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {

        List<Ingredient> ingredientes = new ArrayList<>();

        ingredientRepo.findAll().forEach(i -> ingredientes.add(i));

        Type[] types = Ingredient.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientes, type));
        }

        model.addAttribute("design", new Taco()); // objeto en el que se guardan los POST
        return "design";
    }

//DEPRECADA SIN PERSISTENCIA
//@Slf4j
//@Controller
//@RequestMapping("/design")
//public class DesignTacoController {
//    @GetMapping
//    public String showDesignForm(Model model) {
//        // Model: Controller -> Rendered Data
//        List<Ingredients> Ingredients = Arrays.asList(
//                new Ingredients("FLTO", "Flour Tortilla", Type.WRAP),
//                new Ingredients("COTO", "Corn Tortilla", Type.WRAP),
//                new Ingredients("GRBF", "Ground Beef", Type.PROTEIN),
//                new Ingredients("CARN", "Carnitas", Type.PROTEIN),
//                new Ingredients("TMTO", "Diced Tomatoes", Type.VEGGIES),
//                new Ingredients("LETC", "Lettuce", Type.VEGGIES),
//                new Ingredients("LETC", "Lettuce", Type.VEGGIES),
//                new Ingredients("CHED", "Cheddar", Type.CHEESE),
//                new Ingredients("JACK", "Monterrey Jack", Type.CHEESE),
//                new Ingredients("SLSA", "Salsa", Type.SAUCE),
//                new Ingredients("SRCR", "Sour Cream", Type.SAUCE)
//        );
//
//        Type[] types = Type.values();
//        for (Type type : types) {
//            // Model -> Ejemplo [ WRAP, (Flour..., Corn Tortilla) ]
//            // Model es el nexo entre la plantilla HTML y este código
//            model.addAttribute(type.toString().toLowerCase(), filterByType(Ingredients, type));
//            // Luego dentro del HTML, Thymeleaf es como Jinja2!!
//        }
//
//        model.addAttribute("design", new Taco());
//        return "design";
//      }
//

    // input ... *{atributo} -> conecta con el Taco el Postmapping
    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
        // Save the taco design...
        // We'll do this in chapter 3 log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private Object filterByType(@NotNull List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}