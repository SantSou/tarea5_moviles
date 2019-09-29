package iteso.mx.mvp.activities.main

import iteso.mx.tarea05.adapters.Recipe

interface HomeContract {
    interface View {
        fun showProgress()
        fun showRecipe(recipe: Recipe)
        fun showNoRecipe()
    }

    interface Presenter {
        fun fetchRecipe(objectId: String)
    }
}
