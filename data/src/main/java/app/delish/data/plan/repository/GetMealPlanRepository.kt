
package app.delish.data.plan.repository

import com.elbehiry.model.MealsPlan
import app.delish.data.plan.remote.MealPlanDataSource
import javax.inject.Inject

class GetMealPlanRepository @Inject constructor(
    private val mealPlanRemoteDataSource: MealPlanDataSource
) : MealPlanRepository {
    override suspend fun getMealsPlan(): MealsPlan = mealPlanRemoteDataSource.getMealsPlan()
}
