
package app.delish.domain.usecases.recipes.bookmark

import app.delish.data.home.repository.HomeRepository
import app.delish.data.recipes.repository.RecipesRepository
import app.delish.domain.SuspendUseCase
import app.delish.inject.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DeleteRecipeSuspendUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<Int?, Unit>(ioDispatcher) {
    override suspend fun execute(parameters: Int?) = recipesRepository.deleteRecipe(parameters)
}
