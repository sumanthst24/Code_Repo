package com.example.covid_19

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.covid_19.databinding.FragmentWorkoutStopwatchBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class WorkoutStopwatch : Fragment()
{
    private var second = 0
    private var running = false
    var time: TextView? = null
    private lateinit var binding: FragmentWorkoutStopwatchBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_workout_stopwatch, container, false)
        if (savedInstanceState != null)
        {
            second = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
        }
        runtimmer()
        return binding.root
    }

    override fun onStart()
    {
        super.onStart()
        binding.start.setOnClickListener(View.OnClickListener {
            running=true
        })
        binding.reset.setOnClickListener(View.OnClickListener {
            running=false
            second=0
        })
        binding.stop.setOnClickListener(View.OnClickListener {
            running=false
        })
    }
    private fun runtimmer()
    {
        Log.i("hello", "Inside runtimmer()")
        val handler = Handler()
        handler.post(object : Runnable
        {
            override fun run()
            {
                val hours = second / 3600
                val minutes = second % 3600 / 60
                val secs = second % 60
                binding.time.text = String.format("%d:%02d:%02d", hours, minutes, secs)
                if (running)
                {
                    second++
                }
                runBlocking {
                    delayTime()
                }
            }
        })
    }

    suspend fun delayTime()
    {
        if(running==true)
        delay(1000)
        runtimmer()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle)
    {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("seconds", second)
        savedInstanceState.putBoolean("running", running)
    }
}
