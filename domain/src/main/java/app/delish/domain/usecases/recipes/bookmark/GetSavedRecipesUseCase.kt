
package app.delish.domain.usecases.recipes.bookmark

import androidx.paging.PagingData
import app.delish.data.db.recipes.entities.RecipeEntity
import app.delish.data.recipes.repository.RecipesRepository
import app.delish.domain.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedRecipesUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) : UseCase<Unit, Flow<PagingData<RecipeEntity>>>() {

    override fun execute(parameters: Unit): Flow<PagingData<RecipeEntity>> =
        recipesRepository.getRecipes()
}
