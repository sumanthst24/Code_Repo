package com.example.covid_19

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.covid_19.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}
