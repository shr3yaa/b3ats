package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        getSupportActionBar().setTitle("Change Password");

        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangePassword.this, Pop.class));
            }
        });
    }
    public void Library(View view) {
        startActivity(new Intent(ChangePassword.this, Library.class));
    }
    public void Settings(View view) {
        startActivity(new Intent(ChangePassword.this, Settings.class));
    }
    public void Discover(View view) {
        startActivity(new Intent(ChangePassword.this, Discover.class));
    }
}
