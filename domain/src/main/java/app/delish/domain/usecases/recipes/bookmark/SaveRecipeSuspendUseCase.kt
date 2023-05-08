
package app.delish.domain.usecases.recipes.bookmark

import app.delish.data.recipes.repository.RecipesRepository
import app.delish.domain.SuspendUseCase
import app.delish.inject.IoDispatcher
import com.elbehiry.model.RecipesItem
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SaveRecipeSuspendUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<RecipesItem, Unit>(ioDispatcher) {
    override suspend fun execute(
        parameters: RecipesItem
    ) = recipesRepository.saveRecipe(parameters)
}
