package com.mcvector.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create first Dice object with 6 sides and roll it
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()

        // FInd the image view in the layout
        val diceImage1: ImageView = findViewById(R.id.imageView1)

        // Determine which resource ID to use based on dice roll
        val drawableResource1 = when (diceRoll1) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

        // Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)

        // Update the content description
        diceImage1.contentDescription = diceRoll1.toString()

        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        val diceImage2: ImageView = findViewById(R.id.imageView2)

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource2)

        diceImage2.contentDescription = diceRoll2.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}