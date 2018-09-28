package com.example.shani.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class Register extends AppCompatActivity {

    private EditText regFname ,regLname , regPass , regConfirmpass , regEmail;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setViewId();
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate())
                {
                    startActivity(new Intent(Register.this,Login.class));
                }
                else
                {
                    startActivity(new Intent(Register.this,Home_Activity.class));

                }
            }
        });
    }
    private void setViewId()
    {
         regFname = (EditText) findViewById(R.id.regFname);
        regLname = (EditText) findViewById(R.id.regLname);
        regEmail = (EditText) findViewById(R.id.regEmail);
        regPass = (EditText) findViewById(R.id.regPass);
        regConfirmpass = (EditText) findViewById(R.id.regConfirmPass);
        regBtn =(Button) findViewById(R.id.regBtn);
    }
    private Boolean validate()
    {
        Boolean result = false;
        String firstname = regFname.getText().toString();
        String lastname = regLname.getText().toString();
        String email = regEmail.getText().toString();
        String pass =  regPass.getText().toString();
        String  confirm = regConfirmpass.getText().toString();
        if(firstname.isEmpty() && lastname.isEmpty() && email.isEmpty() && pass.isEmpty() && confirm.isEmpty() )
        {
            return false ;
        }
       /* if(lastname.isEmpty())
        {
            regLname.setError("This Field Should Not be Empty");
        }
        if (email.isEmpty())
        {
            regEmail.setError("This Field Shoould Not be Empty ");
        }
        if (pass.isEmpty())
        {
            regPass.setError("This Field Should Not be Empty");
        }
        if(confirm.isEmpty())
        {
            regConfirmpass.setError("This Field Should Not be Empty");
        }
        */
        if(!confirm.equals(pass))
        {
            regConfirmpass.setError("Password Not Matches");
        }
        else
        {
            result = true;
        }

      return result;
    }
}
