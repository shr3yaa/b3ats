package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Library extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getSupportActionBar().setTitle("Library");
    }
    public void AllSongs(View view){
        startActivity(new Intent(Library.this, HomeActivity.class));
    }
    public void Settings(View view){
        startActivity(new Intent(Library.this,Settings.class));
    }
    public void Discover(View view){
        startActivity(new Intent(Library.this, Discover.class));
    }
    public void smartPlaylists(View view){
        startActivity(new Intent(Library.this, SmartPlaylists.class));
    }
}


