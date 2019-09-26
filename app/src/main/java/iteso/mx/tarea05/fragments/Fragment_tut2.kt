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

class Fragment_tut2 : Fragment(), View.OnClickListener  {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial2, container, false)
        val nextButton: Button = view.findViewById(R.id.fragment_tutorial2_btn_next)
        val previousButton: Button = view.findViewById(R.id.fragment_tutorial2_btn_previous)
        nextButton.setOnClickListener(this)
        previousButton.setOnClickListener(this)
        Log.d("Fragment_tut1", "reached first fragment")
        return view
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.fragment_tutorial2_btn_next-> {
                getActivity()?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(
                        R.id.activity_tutorial_fl_main_content,
                        Fragment_tut3()
                    )
                    ?.commit()
            }
            R.id.fragment_tutorial2_btn_previous -> {
                getActivity()?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(
                        R.id.activity_tutorial_fl_main_content,
                        Fragment_tut1()
                    )
                    ?.commit()
            }
        }
    }
}