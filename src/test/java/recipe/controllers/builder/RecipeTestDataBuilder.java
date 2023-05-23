package recipe.controllers.builder;

import recipe.models.Recipe;

public class RecipeTestDataBuilder {
    public static Recipe createRecipe() {
        return createRecipe(null);
    }

    public static Recipe createRecipe(Integer id) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName("pasta");
        recipe.setNumberOfServings(5);
        recipe.setType("NON_VEGETARIAN");
        recipe.setInstructions("Boil Pasta, Cook Veggies, Add pasta, Granish with cheese and basil");

        return recipe;
    }
}
