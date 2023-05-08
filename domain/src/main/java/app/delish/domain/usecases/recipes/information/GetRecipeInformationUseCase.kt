
package app.delish.domain.usecases.recipes.information

import app.delish.data.recipes.repository.RecipesRepository
import app.delish.domain.SuspendUseCase
import app.delish.inject.IoDispatcher
import com.elbehiry.model.RecipesItem
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetRecipeInformationUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<Int, RecipesItem>(ioDispatcher) {
    override suspend fun execute(parameters: Int): RecipesItem =
        recipesRepository.getRecipeInformation(parameters)
}
