
package app.delish.data.plan.remote

import com.elbehiry.model.MealsPlan
import app.delish.data.remote.DelishApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class GetMealPlanRemoteDataSource @Inject constructor(
    private val api: DelishApi,
    private val spoonAcularKey: String,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MealPlanDataSource {
    override suspend fun getMealsPlan(): MealsPlan =
        withContext(ioDispatcher) {
            api.getMealsPlan(apiKey = spoonAcularKey)
        }
}
