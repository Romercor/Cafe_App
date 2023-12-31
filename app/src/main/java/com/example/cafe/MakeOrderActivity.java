package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MakeOrderActivity extends AppCompatActivity {
    private int step = 0;
    private boolean UserChecked = false;
    private String Drink;
    private String Option;
    private String Toppings;
    private Boolean lemon = false;
    private Boolean milk = false;
    private Boolean sugar = false;
    private String teaType;
    private String coffeeType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        Intent intent = getIntent();
        RadioGroup radioGroup1 = findViewById(R.id.radioGroupDrinks);
        TextView toppings = findViewById(R.id.textViewToppings);
        TextView typeOfDrink = findViewById(R.id.textViewTypeOfDrink);
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonContinue = findViewById(R.id.buttonContinue);
        RadioButton radioButtonTea = findViewById(R.id.TeaOption);
        RadioButton radioButtonCoffee = findViewById(R.id.CoffeeOption);
        CheckBox checkBoxSugar = findViewById(R.id.ToppingSugar);
        CheckBox checkBoxMilk = findViewById(R.id.ToppingMilk);
        CheckBox checkBoxLemon = findViewById(R.id.ToppingLemon);
        Spinner teaTypes=findViewById(R.id.spinnerTea);
        Spinner coffeeTypes=findViewById(R.id.spinnerCoffee);
        String name = intent.getStringExtra("username");
        TextView textViewGreeting = findViewById(R.id.textViewGreeting);
        String greetings = getString(R.string.greeting);
        greetings = String.format(greetings, name);
        textViewGreeting.setText(greetings);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (step==1){
                    radioGroup1.setVisibility(View.VISIBLE);
                    textViewGreeting.setVisibility(View.VISIBLE);
                    checkBoxLemon.setVisibility(View.VISIBLE);
                    toppings.setVisibility(View.INVISIBLE) ;
                    checkBoxMilk.setVisibility(View.INVISIBLE);
                    checkBoxSugar.setVisibility(View.INVISIBLE);
                    checkBoxLemon.setVisibility(View.INVISIBLE);
                    checkBoxLemon.setChecked(false);
                    checkBoxSugar.setChecked(false);
                    checkBoxMilk.setChecked(false);
                    step--;
                    UserChecked = false;
                    toppings.setText("What should be added in your");
                }
                if(step==2){
                    checkBoxMilk.setVisibility(View.VISIBLE);
                    checkBoxSugar.setVisibility(View.VISIBLE);
                    checkBoxLemon.setVisibility(View.VISIBLE);
                    toppings.setVisibility(View.VISIBLE);
                    typeOfDrink.setVisibility(View.INVISIBLE);
                    teaTypes.setVisibility(View.INVISIBLE);
                    coffeeTypes.setVisibility(View.INVISIBLE);
                    step--;
                }
            }
        });
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId ) {
                if (!UserChecked) {
                    if (checkedId == R.id.TeaOption) {
                        Drink = radioButtonTea.getText().toString();
                        radioGroup1.setVisibility(View.INVISIBLE);
                        textViewGreeting.setVisibility(View.INVISIBLE);
                        toppings.setVisibility(View.VISIBLE);
                        checkBoxMilk.setVisibility(View.VISIBLE);
                        checkBoxSugar.setVisibility(View.VISIBLE);
                        checkBoxLemon.setVisibility(View.VISIBLE);
                    } else {
                        Drink = radioButtonCoffee.getText().toString();
                        radioGroup1.setVisibility(View.INVISIBLE);
                        textViewGreeting.setVisibility(View.INVISIBLE);
                        toppings.setVisibility(View.VISIBLE);
                        checkBoxMilk.setVisibility(View.VISIBLE);
                        checkBoxSugar.setVisibility(View.VISIBLE);
                        checkBoxLemon.setVisibility(View.VISIBLE);
                        checkBoxLemon.setVisibility(View.INVISIBLE);
                    }
                    Toppings = toppings.getText().toString() + " " + Drink.toLowerCase();
                    toppings.setText(Toppings);
                    UserChecked = true;
                    step++;
                }
            }
        });
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (step==2){
                    Intent intent2 = new Intent(MakeOrderActivity.this, OrderDetails.class);
                    intent2.putExtra("username", intent.getStringExtra("username"));
                    intent2.putExtra("drink",Drink);
                    intent2.putExtra("sugar", sugar);
                    intent2.putExtra("milk", milk);
                    intent2.putExtra("lemon", lemon);
                    if (Drink.equals("Tea")) intent2.putExtra("drinkType", teaTypes.getSelectedItem().toString());
                    else intent2.putExtra("drinkType", coffeeTypes.getSelectedItem().toString());
                    startActivity(intent2);
                }
                if (step==1){
                    lemon = checkBoxLemon.isChecked();
                    milk = checkBoxMilk.isChecked();
                    sugar = checkBoxSugar.isChecked();
                    checkBoxMilk.setVisibility(View.INVISIBLE);
                    checkBoxSugar.setVisibility(View.INVISIBLE);
                    checkBoxLemon.setVisibility(View.INVISIBLE);
                    toppings.setVisibility(View.INVISIBLE);
                    typeOfDrink.setVisibility(View.VISIBLE);
                    if(Drink.equals("Tea")) teaTypes.setVisibility(View.VISIBLE);
                    else coffeeTypes.setVisibility(View.VISIBLE);
                    step++;

                }
            }
        });

    }
}