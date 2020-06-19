package com.example.covid_19

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.covid_19.databinding.FragmentMainBinding

class MainFragment : Fragment()
{
    private lateinit var binding: FragmentMainBinding
    var navController : NavController?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        setHasOptionsMenu(true)
    }

    override fun onStart()
    {
        super.onStart()

        //Handling Click on ListView
        val itemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if(position==0)
                navController!!.navigate(R.id.action_mainFragment_to_gameFragment)
            if(position==1)
                navController!!.navigate(R.id.action_mainFragment_to_workoutStopwatch)
        }
        binding.options.onItemClickListener=itemClickListener
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)
    {
        inflater.inflate(R.menu.menu_main,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.action_me -> {
                navController!!.navigate(R.id.action_mainFragment_to_aboutMe)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
