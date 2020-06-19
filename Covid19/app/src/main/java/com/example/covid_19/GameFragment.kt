package com.example.covid_19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.covid_19.databinding.FragmentGameBinding

class GameFragment : Fragment()
{
    private lateinit var viewModel: GameViewModel
    private lateinit var binding: FragmentGameBinding
    var navController : NavController?=null
    var score=0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding.textView3.visibility=View.GONE
        binding.textView.visibility=View.GONE
        binding.option1.visibility=View.GONE
        binding.option2.visibility=View.GONE
        binding.option3.visibility=View.GONE
        binding.option4.visibility=View.GONE
        binding.answer1.visibility=View.GONE
        binding.answer2.visibility=View.GONE
        binding.answer3.visibility=View.GONE
        binding.answer4.visibility=View.GONE
        binding.ready.setOnClickListener(View.OnClickListener {
            binding.ready.visibility=View.GONE
            binding.textView.visibility=View.VISIBLE
            binding.option1.visibility=View.VISIBLE
            binding.option2.visibility=View.VISIBLE
            binding.option3.visibility=View.VISIBLE
            binding.option4.visibility=View.VISIBLE
            binding.answer1.visibility=View.VISIBLE
            binding.answer2.visibility=View.VISIBLE
            binding.answer3.visibility=View.VISIBLE
            binding.answer4.visibility=View.VISIBLE
            viewModel.nextWord()
            UpdateViews()
        })
        binding.option1.setOnClickListener(View.OnClickListener {
            if(binding.answer1.text==viewModel.CorrectAnswer)
            {
                Toast.makeText(context,"Correct Answer",Toast.LENGTH_SHORT).show()
                score++
                viewModel.nextWord()
                UpdateViews()
                if(viewModel.f==11)
                {
                    showScore()
                }
            }
            else
            {
                Toast.makeText(context,"Wrong Answer",Toast.LENGTH_SHORT).show()
                viewModel.nextWord()
                UpdateViews()
                if(viewModel.f==11)
                {
                    showScore()
                }
            }
        })
        binding.option2.setOnClickListener(View.OnClickListener {
            if(binding.answer2.text==viewModel.CorrectAnswer)
            {
                Toast.makeText(context,"Correct Answer",Toast.LENGTH_SHORT).show()
                score++
                viewModel.nextWord()
                UpdateViews()
                if(viewModel.f==11)
                {
                    showScore()
                }
            }
            else
            {
                Toast.makeText(context,"Wrong Answer",Toast.LENGTH_SHORT).show()
                viewModel.nextWord()
                UpdateViews()
                if(viewModel.f==11)
                {
                    showScore()
                }
            }
        })
        binding.option3.setOnClickListener(View.OnClickListener {
            if(binding.answer3.text==viewModel.CorrectAnswer)
            {
                Toast.makeText(context,"Correct Answer",Toast.LENGTH_SHORT).show()
                score++
                viewModel.nextWord()
                UpdateViews()
                if(viewModel.f==11)
                {
                    showScore()
                }
            }
            else
            {
                Toast.makeText(context,"Wrong Answer",Toast.LENGTH_SHORT).show()
                viewModel.nextWord()
                UpdateViews()
                if(viewModel.f==11)
                {
                    showScore()
                }
            }
        })
        binding.option4.setOnClickListener(View.OnClickListener {
            if(binding.answer4.text==viewModel.CorrectAnswer)
            {
                Toast.makeText(context,"Correct Answer",Toast.LENGTH_SHORT).show()
                score++
                viewModel.nextWord()
                UpdateViews()
                if(viewModel.f==11)
                {
                    showScore()
                }
            }
            else
            {
                Toast.makeText(context,"Wrong Answer",Toast.LENGTH_SHORT).show()
                viewModel.nextWord()
                UpdateViews()
                if(viewModel.f==11)
                {
                    showScore()
                }
            }
        })
    }
    fun UpdateViews()
    {
        binding.textView.text=viewModel.word
        binding.answer1.text=viewModel.button1
        binding.answer2.text=viewModel.button2
        binding.answer3.text=viewModel.button3
        binding.answer4.text=viewModel.button4
    }
    fun showScore()
    {
        binding.textView.visibility=View.GONE
        binding.option1.visibility=View.GONE
        binding.option2.visibility=View.GONE
        binding.option3.visibility=View.GONE
        binding.option4.visibility=View.GONE
        binding.answer1.visibility=View.GONE
        binding.answer2.visibility=View.GONE
        binding.answer3.visibility=View.GONE
        binding.answer4.visibility=View.GONE
        binding.textView2.text="Score"
        binding.textView3.text=score.toString()
        binding.textView3.visibility=View.VISIBLE
    }
}
