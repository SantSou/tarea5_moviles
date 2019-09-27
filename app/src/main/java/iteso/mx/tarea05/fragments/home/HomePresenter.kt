package iteso.mx.tarea05.activities

import iteso.mx.mvp.activities.main.HomeContract
import iteso.mx.tarea05.adapters.Recipe
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {
    override fun fetchRecipe(objectId: String) {
        view.showProgress()
        doAsync {
            Thread.sleep(4000)
            val random = Random()
            val randomInt = random.nextInt(20)
            if (randomInt < 11) {
                uiThread {
                    view.showRecipe(Recipe("Erick", 23))
                }
            } else {
                uiThread {
                    view.showNoRecipe()
                }
            }
        }
    }
}
