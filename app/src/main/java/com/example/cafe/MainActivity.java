package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;
    private Button ButtonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ButtonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, MakeOrderActivity.class);
                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(
                            MainActivity.this, "Please fill all the lines",Toast.LENGTH_SHORT
                    ).show();
                }
                else{
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
                }
            }
        });
    }
    private void init(){
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        ButtonOrder = findViewById(R.id.ButtonOrder);
    }
}