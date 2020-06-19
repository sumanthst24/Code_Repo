package com.example.covid_19

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel()
{
    var word = ""
    var button1 = ""
    var button2 = ""
    var button3 = ""
    var button4 = ""
    var CorrectAnswer=""
    var f=0
    private lateinit var wordList: MutableList<String>
    private lateinit var wordList1: MutableList<String>
    private fun resetList()
    {
        wordList = mutableListOf(
            "In which country was COVID-19 first reported?",
            "America",
            "Iran",
            "Italy",
            "China",
            "What is COVID-19",
            "Name of the Virus",
            "Name of the disease",
            "Name of a drug",
            "A place in China",
            "Which virus causes the disease COVID19",
            "SARS-CoV-2",
            "SARS",
            "MERS",
            "NIPAH",
            "Is there anything I should not do?",
            "Smoking",
            "Wearing multiple masks",
            "Taking antibiotics",
            "All the above",
            "How can we make our hands safe?",
            "Wash with soap and water",
            "Wash with plain water",
            "Wipe hands with tissue paper or cloth",
            "Wash with soap and water and scrub at least for 20 seconds",
            "What are the methods to prevent COVID19?",
            "Physical distancing 1 meter",
            "Physical distancing 2 meter",
            "Physical distancing 6 feet",
            "Both 2 and 3",
            "Who is at a higher risk of developing complications from COVID-19?",
            "Constant touching of face, eyes or mouth in public place",
            "Close contact with a Covid19 infected person",
            "Close contact with a Covid19 infected person",
            "All the above",
            "What are the safe methods of disposal of dead bodies of persons who have died of suspected or confirmed COVID-19",
            "Cremation",
            "Burial",
            "Both 1 & 2",
            "None of the above",
            "What are the most common symptoms of COVID-19",
            "Fever",
            "Dry cough",
            "Tiredness",
            "All the above",
            "How does Coronavirus transmit?",
            "Droplets spread - When a person sneezes or cough",
            "Constant touching of face, eyes or mouth in public place",
            "Close contact with a Covid19 infected person",
            "All the above"
        )
    }

    private fun correct()
    {
        wordList1 = mutableListOf(
            "China",
            "Name of the Virus",
            "SARS-CoV-2",
            "Smoking",
            "Wash with soap and water and scrub at least for 20 seconds",
            "Both 2 and 3",
            "All the above",
            "Burial",
            "All the above",
            "All the above")

    }

    init
    {
        resetList()
        correct()
        Log.i("GameViewModel", "GameViewModel created!")
    }

    fun nextWord()
    {
        f++
        if (!wordList.isEmpty())
        {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
            button1 = wordList.removeAt(0)
            button2 = wordList.removeAt(0)
            button3 = wordList.removeAt(0)
            button4 = wordList.removeAt(0)
            CorrectAnswer=wordList1.removeAt(0)
        }

    }
    override fun onCleared()
    {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

}