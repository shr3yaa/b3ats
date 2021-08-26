package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setTitle("Settings");
    }
    public void Library(View view) {
        startActivity(new Intent(Settings.this, Library.class));
    }

    public void SleepTimer(View view) {
        startActivity(new Intent(Settings.this, SleepTimer.class));
    }
    public void Account(View view) {
        startActivity(new Intent(Settings.this, Account.class));
    }
    public void Discover(View view){
        startActivity(new Intent(Settings.this, Discover.class));
    }
}

