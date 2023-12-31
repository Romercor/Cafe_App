package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        OrderInfo OrderInfo = getInt();
        TextView textViewName = findViewById(R.id.textViewNameDetails);
        TextView textViewDrink = findViewById(R.id.textViewDrinkDetails);
        TextView textViewDrinkType = findViewById(R.id.textViewTypeOfDrinkDetails);
        TextView textViewToppings = findViewById(R.id.textViewToppingsDetails);
        textViewName.setText(OrderInfo.getName());
        textViewDrink.setText(OrderInfo.getDrink());
        textViewDrinkType.setText(OrderInfo.getDrinkType());
        textViewToppings.setText(OrderInfo.getToppings());
    }
    private OrderInfo getInt(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        String drink = intent.getStringExtra("drink");
        boolean sugar = intent.getBooleanExtra("sugar",false);
        boolean milk = intent.getBooleanExtra("milk",false);
        boolean lemon = intent.getBooleanExtra("lemon",false);
        String drinkType = intent.getStringExtra("drinkType");
        return new OrderInfo(name, drink, sugar, milk, lemon, drinkType);
    }
    class OrderInfo {
        private String name;
        private String drink;
        private boolean sugar;
        private boolean milk;
        private boolean lemon;
        private String drinkType;

        private OrderInfo(String name, String drink, boolean sugar, boolean milk, boolean lemon, String drinkType) {
            this.name = name;
            this.drink = drink;
            this.sugar = sugar;
            this.milk = milk;
            this.lemon = lemon;
            this.drinkType = drinkType;
        }

        private String getName() {
            return name;
        }

        private String getDrink() {
            return drink;
        }

        private String getDrinkType() {
            return drinkType;
        }
        private String getToppings() {
            String st = "";
            if (sugar) st+="Sugar\n";
            if (milk) st+="Milk\n";
            if (lemon) st += "Lemon";
            return st;
        }
    }

}