package pl.mobicons.aimealplanner.domain

import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipeDetails(id: String): Flow<RecipeDetails>
}