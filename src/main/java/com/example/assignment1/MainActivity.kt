package com.example.assignment1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get the button using the id we set on the user interface


      val submitButton = findViewById<Button>(R.id.SubmitButton)
        val ResetButton = findViewById<Button>(R.id.ResetButton)
        val EditName = findViewById<EditText>(R.id.editName)
        val textDisplay = findViewById<TextView>(R.id.textDisplay)

        // find the EditText and buttons by their IDs
        val editName = findViewById<EditText>(R.id.editName)
        val resetButton = findViewById<Button>(R.id.ResetButton)

        // Set an OnClickListener for the reset button
        ResetButton.setOnClickListener {
            // Reset the EditText to an empty state (clear text)
            editName.text.clear()

            // Optionally, resets other UI elements or perform additional actions
        }
        // find the submit button and TextView by their IDs
        val SubmitButton = findViewById<Button>(R.id.SubmitButton)
        val TextDisplay = findViewById<TextView>(R.id.textDisplay)

        // Sample items to choose from
        val items = arrayOf("morningMeals","afternoonMeals","eveningMeals")

        // Set OnClickListener for the submit button
        SubmitButton.setOnClickListener {
            // Create an AlertDialog with the list of items
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Select Your meal")
            builder.setItems(items) { dialog, which ->
                // Handle item selection
                val selectedItem = items[which]
                "Selected: $selectedItem" // Display selected item in TextView
            }
            builder.show()
        }

        fun main() {
            // Meal options
            val morningMeals = listOf("Pancakes With Syrup", "Omelette", "Toast And Eggs", "Cereal")
            val afternoonMeals = listOf("Grill Cheese Sandwich", "Salad", "Pepper Steak Pie", "Ham Burger")
            val eveningMeals = listOf("Pizza", "Steak", "Sushi", "Spaghetti And Mince", "Grilled Chicken")

            // Variable to store selected meals
            var selectedMorningMeal: String? = null
            var selectedAfternoonMeal: String? = null
            var selectedEveningMeal: String? = null

            while (true) {
                println("\nSelect an option:")
                println("1. Select Morning Meal")
                println("2. Select Afternoon Meal")
                println("3. Select Evening Meal")
                println("4. Confirm Meals")
                println("5. Reset")
                println("6. Exit")

                val choice = readLine()?.toIntOrNull()

                when (choice) {
                    1 -> {
                        // Choose Morning Meal
                        println("\nSelect your Morning meal:")
                        morningMeals.forEachIndexed { index, meal -> println("${index + 1}. $meal") }
                        val morningChoice = readLine()?.toIntOrNull()
                        if (morningChoice in 1..morningMeals.size) {
                            selectedMorningMeal = morningMeals[morningChoice!! - 1]
                            println("You have selected: ${selectedMorningMeal}")
                        } else {
                            println("Invalid choice. Please try again.")
                        }
                    }

                    2 -> {
                        // Choose Afternoon Meal
                        println("\nSelect your Afternoon meal:")
                        afternoonMeals.forEachIndexed { index, meal -> println("${index + 1}. $meal") }
                        val afternoonChoice = readLine()?.toIntOrNull()
                        if (afternoonChoice in 1..afternoonMeals.size) {
                            selectedAfternoonMeal = afternoonMeals[afternoonChoice!! - 1]
                            println("You have selected: ${selectedAfternoonMeal}")
                        } else {
                            println("Invalid choice. Please try again.")
                        }
                    }

                    3 -> {
                        // Choose Evening Meal
                        println("\nSelect your Evening meal:")
                        eveningMeals.forEachIndexed { index, meal -> println("${index + 1}. $meal") }
                        val eveningChoice = readLine()?.toIntOrNull()
                        if (eveningChoice in 1..eveningMeals.size) {
                            selectedEveningMeal = eveningMeals[eveningChoice!! - 1]
                            println("You have selected: ${selectedEveningMeal}")
                        } else {
                            println("Invalid choice. Please try again.")
                        }
                    }

                    4 -> {
                        // Confirm Meals
                        if (selectedMorningMeal != null && selectedAfternoonMeal != null && selectedEveningMeal != null) {
                            println("\nYour selected meals are:")
                            println("Morning: $selectedMorningMeal")
                            println("Afternoon: $selectedAfternoonMeal")
                            println("Evening: $selectedEveningMeal")
                        } else {
                            println("\nPlease select meals for all parts of the day.")
                        }
                    }

                    5 -> {
                        // Reset selections
                        selectedMorningMeal = null
                        selectedAfternoonMeal = null
                        selectedEveningMeal = null
                        println("\nSelections have been reset.")
                    }

                    6 -> {
                        // Exit
                        println("\nExiting the meal selection program.")
                        break
                    }

                    else -> println("\nInvalid choice. Please try again.")



                }
            }
        }

























        }

    }
