package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button LogIn;
    private Button SignUp;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        Name = (EditText)findViewById(R.id.Name);
        Password=(EditText)findViewById(R.id.Password);
        Info=(TextView) findViewById(R.id.tvInfo);
        LogIn=(Button)findViewById(R.id.btnLogin);
        SignUp=(Button)findViewById(R.id.btnSignUp);

        Info.setText("No. of attempts remaining: 5");

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());

            }
        });
    }
    private void validate(String userName, String userPassword){
        if ((userName.equals("admin")) && (userPassword.equals("abc123"))){
            Intent intent =new Intent(Login.this, Discover.class);
            startActivity(intent);
        }
        else{
            counter--;

            Info.setText("No. of attempts remaining: "+ String.valueOf(counter));

            if(counter==0){
                LogIn.setEnabled(false);
            }
        }
    }
    public void SignUp(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
    }
    public void Login(View view){
            startActivity(new Intent(getApplicationContext(),Discover.class));
    }
public void ForgotPassword(View view){
        startActivity(new Intent (getApplicationContext(),ForgotPassword.class));
}}
