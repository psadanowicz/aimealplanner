package pl.mobicons.aimealplanner.domain.model

import pl.mobicons.aimealplanner.data.model.IngredientData
import pl.mobicons.aimealplanner.data.model.InstructionStepData

data class RecipeDetails(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val ingredients: List<IngredientData>,
    val instructions: List<InstructionStepData>
)