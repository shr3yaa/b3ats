package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().setTitle("Forgot Password");
    }
    public void Update(View view) {
        startActivity(new Intent(ForgotPassword.this, Login.class));
    }
    public void Discover(View view){
        startActivity(new Intent(ForgotPassword.this, Discover.class));
    }
    public void Library(View view){
        startActivity(new Intent(ForgotPassword.this, Library.class));
    }
    public void Settings(View view){
        startActivity(new Intent(ForgotPassword.this, Settings.class));
    }
}


