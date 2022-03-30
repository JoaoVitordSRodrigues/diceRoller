package com.example.dicerollerimage2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}

    }

    private fun rollDice(){
        val  randomInt = (1..6).random()
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val edtNumber: EditText = findViewById(R.id.edtNumber)

        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4-> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        if (edtNumber.length() != 0) {
            if (randomInt == Integer.parseInt(edtNumber.text.toString())) {
                Toast.makeText(this, "Você ganhou!!!", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "Você perdeu!!!", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this, "Insira algum número!!!", Toast.LENGTH_SHORT).show()
        }

        diceImage.setImageResource(drawableResource)
    }
}