
package app.delish.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import app.delish.data.db.recipes.dao.CuisineDao
import app.delish.data.db.recipes.dao.IngredientDao
import app.delish.data.db.recipes.dao.RecipesDao
import app.delish.data.db.recipes.entities.CuisineEntity
import app.delish.data.db.recipes.entities.IngredientEntity
import app.delish.data.db.recipes.entities.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
        CuisineEntity::class,
        IngredientEntity::class,
    ],
    version = Constants.VERSION
)
internal abstract class DelishDataBase : RoomDatabase() {
    abstract val recipesTable: RecipesDao
    abstract val cuisineDao : CuisineDao
    abstract val ingredientDao : IngredientDao
}
