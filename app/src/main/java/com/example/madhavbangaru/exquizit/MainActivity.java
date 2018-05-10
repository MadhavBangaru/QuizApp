package com.example.madhavbangaru.exquizit;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }
    public void validate(String userName, String password){

        if((userName.equals("Madhav"))&&(password.equals("6296"))){

            Intent intent = new Intent(MainActivity.this,QuizActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("No of attempts left: "+ String.valueOf(counter));
            Info.setTextColor(Color.RED);
            Toast.makeText(this,"No of attempts left "+ String.valueOf(counter),
                    Toast.LENGTH_LONG).show();
            if(counter <= 0){
               Login.setEnabled(false);
                Info.setText("Sorry, your account is temporarily blocked.Please contact support");
                Info.setTextColor(Color.RED);
                Toast.makeText(this,"Sorry, your account is temporarily blocked.Please contact support",
                        Toast.LENGTH_LONG).show();
            }


        }
    }
}
