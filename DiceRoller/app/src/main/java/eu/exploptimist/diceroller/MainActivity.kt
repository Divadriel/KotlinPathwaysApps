package eu.exploptimist.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        rollButton.setOnClickListener {
            rollDice(diceImage)
            rollDice(diceImage2)
        }
        rollDice(diceImage)
        rollDice(diceImage2)
    }

    // roll dice and update UI
    private fun rollDice(diceImage: ImageView) {
        // roll 6-sided dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // find imageView
        //val diceImage: ImageView = findViewById(R.id.imageView)
        // get correct image
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // update UI and contentDescription for screen readers
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
}
// get random between 1 and 6
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}