package iteso.mx.tarea05.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R

class Fragment_tut1 : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial1, container, false)
        Log.d("Fragment_tut1", "reached first fragment")
        return view
    }

    override fun onClick(p0: View?) {
        getActivity()?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.activity_tutorial_fl_main_content,
                Fragment_tut1()
            )
            ?.commit()
    }
}