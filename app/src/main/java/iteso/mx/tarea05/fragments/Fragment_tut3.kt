package iteso.mx.tarea05.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R
import iteso.mx.tarea05.activities.ActivityMain
import org.jetbrains.anko.startActivity

class Fragment_tut3 : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial3, container, false)
        val nextButton: Button = view.findViewById(R.id.fragment_tutorial3_btn_finish)
        val previousButton: Button = view.findViewById(R.id.fragment_tutorial3_btn_previous)
        nextButton.setOnClickListener(this)
        previousButton.setOnClickListener(this)
        Log.d("Fragment_tut1", "reached first fragment")
        return view
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.fragment_tutorial3_btn_finish-> {
                getActivity()?.startActivity<ActivityMain>()
            }
            R.id.fragment_tutorial3_btn_previous -> {
                getActivity()?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(
                        R.id.activity_tutorial_fl_main_content,
                        Fragment_tut2()
                    )
                    ?.commit()
            }
        }
    }
}