package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import iteso.mx.tarea05.R
import iteso.mx.tarea05.fragments.Fragment_tut1
import iteso.mx.tarea05.fragments.Fragment_tut2
import iteso.mx.tarea05.fragments.Fragment_tut3
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ActivityTutorial : AppCompatActivity(), View.OnClickListener{

    private lateinit var mNext1 : Button
    private lateinit var mNext2 : Button
    private lateinit var mFinish : Button
    private lateinit var mPrevious2 : Button
    private lateinit var mPrevious3 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_tutorial_fl_main_content,
                Fragment_tut1()
            )
            .commit()
        /* TODO Create three fragments for the tutorial and place them in activity_tutorial_fl_content
        *   First Fragment has a background image and a next button
        *   Second Fragment has a background image a next and previous button
        *   Third Fragment has a background image a finish and a previous button
        *  */
        Log.d("tutorial_activity", "exited rendering first fragment")
    }
    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.fragment_tutorial1_btn_next -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_main_content,
                        Fragment_tut2()
                    )
                    .commit()
            }
            R.id.fragment_tutorial2_btn_next -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_main_content,
                        Fragment_tut3()
                    )
                    .commit()
            }
            R.id.fragment_tutorial2_btn_previous -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_main_content,
                        Fragment_tut1()
                    )
                    .commit()
            }
            R.id.fragment_tutorial3_btn_previous -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_main_content,
                        Fragment_tut2()
                    )
                    .commit()
            }
            R.id.fragment_tutorial3_btn_finish -> {
                startActivity<ActivityMain>()
            }
        }
    }
}
