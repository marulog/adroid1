package com.example.ch002_1971535_parkjunhee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
class HomeFragment : Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        viewModel.countLiveData.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.textView).text = "${it}"
        }

        view.findViewById<Button>(R.id.button)?.setOnClickListener {
            viewModel.increase()
            findNavController().navigate(R.id.action_homeFragment_to_na1Fragment)
        }
    }
}
class Na1Fragment : Fragment(R.layout.nav1_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        viewModel.countLiveData.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.textView).text = "${it}"
        }

        view.findViewById<Button>(R.id.button)?.setOnClickListener {
            viewModel.increase()
            findNavController().navigate(R.id.action_na1Fragment_to_na2Fragment)
        }

    }
}
class Na2Fragment : Fragment(R.layout.nav2_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        viewModel.countLiveData.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.textView).text = "${it}"
        }

        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button)?.setOnClickListener {
            viewModel.increase()
            findNavController().navigate(R.id.action_na2Fragment_to_homeFragment)
        }
    }

}
