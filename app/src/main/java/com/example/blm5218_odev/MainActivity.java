package com.example.blm5218_odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button signin;
    Button signup;

    ArrayList<Person> persons;
    int attempt=0;
    String email="",pwd="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        define();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkPerson()) {
                    Intent intent;
                    Toast.makeText(getApplicationContext(),"Başarılı giriş",Toast.LENGTH_LONG).show();
                    intent=new Intent(v.getContext(), MenuActivity.class);
                    intent.putExtra("userId",username.getText().toString());
                    startActivity(intent);
                }
                else{
                    attempt+=1;
                    if(attempt>=3){
                        Toast.makeText(getApplicationContext(),"3 hatalı giriş yaptınız.",Toast.LENGTH_LONG).show();

                    }
                    Toast.makeText(getApplicationContext(),"Hatalı e-posta/şifre",Toast.LENGTH_LONG).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(v.getContext(),SignUpActivity.class);
                startActivity(intent);

            }
        });


    }

    private void define() {
        username = findViewById(R.id.username_area);
        password = findViewById(R.id.password_area);
        signin = findViewById(R.id.btn_signin);
        signup = findViewById(R.id.btn_signup);
        persons=Person.getPersonList();
        try {
            email= getIntent().getExtras().get("e-mail").toString();
            pwd=getIntent().getExtras().get("password").toString();
            persons.add(new Person(email,pwd));

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private boolean checkPerson() {
        for (Person p : persons) {

            if ((username.getText().toString().equals(p.getUserName())) && (password.getText().toString().equals(p.getPassword()))) {
                return true;
            }

        }
        return false;
    }




}