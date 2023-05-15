package com.example.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {

        // check which button is chosen
        var cellId = 0
        val butSelected: Button = view as Button
        when (butSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9


        }


        Log.d("buClick:", butSelected.id.toString())
        Log.d("buClick: cellId:", cellId.toString())
        playGame(cellId, butSelected)
    }

    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
          //  autoPlay()

        } else {
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellId)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()


    }

    fun checkWinner() {
        var winner = -1

        // row  1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }


        // diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }


        // diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner == 1) {
            Toast.makeText(this, "Player 1 wins the game", Toast.LENGTH_LONG).show()

        } else if (winner == 2) {
            Toast.makeText(this, "Player 2 wins the game", Toast.LENGTH_LONG).show()

        }


    }

//    fun autoPlay() {
//        var emptyCells = ArrayList<Int>()
//        for (cellId in 1..9) {
//            if (!player1.contains(cellId) || player2.contains(cellId)) {
//                emptyCells.add(cellId)
//            }
//        }
//        val r = Random()
//        val randIndex = r.nextInt(emptyCells.size)
//        val cellId = emptyCells[randIndex]
//
//        // int null safety vs button null safety
//        var buSelected:Button?
//
//        ////////////
//        buSelected = when (cellId) {
//            1 -> R.id.button1
//            2 -> R.id.button2
//            3 -> R.id.button3
//            4 -> R.id.button4
//            5 -> R.id.button5
//            6 -> R.id.button6
//            7 -> R.id.button7
//            8 -> R.id.button8
//            9 -> R.id.button9
//            else -> {
//                R.id.button1
//            }
//
//        }
//        playGame(cellId,buSelected)
//
//
//    }

}
