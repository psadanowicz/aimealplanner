package pl.mobicons.aimealplanner.data

import pl.mobicons.aimealplanner.data.model.RecipeDetailsData
import retrofit2.http.GET

interface RecipeService {

    @GET
    suspend fun getRecipeDetails(id: String): RecipeDetailsData
}