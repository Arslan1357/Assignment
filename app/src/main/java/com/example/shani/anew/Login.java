package com.example.shani.anew;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class Login extends AppCompatActivity {
;

    private EditText loginName;
    private EditText loginPass;
    private TextView loginregBtn ;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUIviews();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(validate())
               {
                   startActivity(new Intent(Login.this,Home_Activity.class ));
               }

            }
        });
        loginregBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startintent();
            }
        });

    }
    private void startintent()
    {
        Intent open = new Intent(getApplicationContext(),Register.class);
        startActivity(open);
    }
    private void setupUIviews()
    {
        loginName = (EditText) findViewById(R.id.loginName);

        loginPass = (EditText) findViewById(R.id.loginPass);

        loginBtn = (Button) findViewById(R.id.loginBtn) ;

        loginregBtn = (TextView) findViewById(R.id.loginregBtn) ;

    }
    private Boolean validate()
    {
        Boolean result = false;
        String nn ="Muhammad Arslan Ali";
        String pp = "arslan123";
        String name = loginName.getText().toString();
        String pass = loginPass.getText().toString() ;
       //int len = pass.length();
        if(name.length()== 0 )
        {
            loginName.setError("Please Fill this Field");
        }
        if(pass.length()==0)
         {
             loginPass.setError("Please fill this Field");
            //Toast.makeText(this,"Hi There! " + name ,Toast.LENGTH_LONG).show();
             //result=true;
        }
        if(!loginName.getText().toString().equals(nn))
        {
            loginName.setError("InValid Name");

        }
        if(loginPass.getText().toString().length() < 6 )
        {

            loginPass.setError("InValid Password");
        }
        else
        {

            result=true;

        }
 return result;

    }
}
