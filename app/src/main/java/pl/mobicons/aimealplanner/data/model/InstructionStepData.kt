package pl.mobicons.aimealplanner.data.model

import com.squareup.moshi.Json

data class InstructionStepData(
    @Json(name = "step_number") val stepNumber: Int,
    val description: String
)