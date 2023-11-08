package pl.mobicons.aimealplanner.data

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import pl.mobicons.aimealplanner.data.model.RecipeDetailsData
import retrofit2.mock.BehaviorDelegate

class RecipeServiceMock(
    val context: Context,
    val moshi: Moshi,
    val behaviorDelegate: BehaviorDelegate<RecipeService>
) : RecipeService {
    override suspend fun getRecipeDetails(id: String): RecipeDetailsData {
        val json = context.assets.open("example.json").bufferedReader().use { it.readText() }
        val adapter: JsonAdapter<RecipeDetailsData> =
            moshi.adapter(RecipeDetailsData::class.java)
        val response = adapter.fromJson(json)
        return behaviorDelegate.returningResponse(response).getRecipeDetails(id)
    }
}