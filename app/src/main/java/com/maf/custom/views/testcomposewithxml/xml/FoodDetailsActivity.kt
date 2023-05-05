package com.maf.custom.views.testcomposewithxml.xml

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.maf.custom.views.testcomposewithxml.R

class FoodDetailsActivity: AppCompatActivity() {

    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        backButton = findViewById(R.id.image_view_button_back)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}