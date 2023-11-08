package pl.mobicons.aimealplanner.data.model

data class RecipeDetailsData(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val ingredients: List<IngredientData>,
    val instructions: List<InstructionStepData>,
    val prepTime: String,
    val cookTime: String,
    val totalTime: String,
    val servings: Int,
    val calories: Int,
    val protein: Int,
    val carbohydrates: Int,
    val fat: Int,
    val image: String
)