package iteso.mx.fragments.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.ViewAnimator
import androidx.fragment.app.Fragment
import iteso.mx.mvp.activities.main.HomeContract
import iteso.mx.tarea05.R
import iteso.mx.tarea05.activities.HomePresenter
import iteso.mx.tarea05.adapters.Recipe
import org.jetbrains.anko.support.v4.find

class FragmentHome : Fragment(), HomeContract.View, View.OnClickListener {
    private lateinit var mName: TextView
    private lateinit var mSwitcher: ViewAnimator
    private lateinit var mPresenter: HomeContract.Presenter
    private lateinit var mButton: Button

    companion object {
        const val SHOW_PROGRESS = 2
        const val SHOW_NO_RECIPE = 1
        const val SHOW_RECIPE = 3
        const val REFRESH_BUTTON = 3
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        mButton = view.findViewById(R.id.fragment_refresh_button)
        mSwitcher = view.findViewById(R.id.fragment_home_switcher)
        mPresenter = HomePresenter(this)
        Log.d("fragment_home", "view inflated")
        mButton.setOnClickListener(this)
        return view
    }

    override fun onClick(p0: View?) {
            mPresenter.fetchRecipe("hola")
            Log.d("fragment_home", "button clicked")
    }

    override fun showProgress() {
        mSwitcher.displayedChild = SHOW_PROGRESS
    }

    override fun showRecipe(recipe: Recipe) {
        mSwitcher.displayedChild = SHOW_RECIPE
    }

    override fun showNoRecipe() {
        mSwitcher.displayedChild = SHOW_NO_RECIPE
    }

    private fun decideActionWithMenuItemClicked(itemId: Int) {
        showRecipe(Recipe("Erick", 23))
    }
}