package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Genres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);
        getSupportActionBar().setTitle("Genres");
    }
    public void Library(View view) {
        startActivity(new Intent(Genres.this, Library.class));
    }
    public void Settings(View view) {
        startActivity(new Intent(Genres.this, Settings.class));
    }
    public void Discover(View view) {
        startActivity(new Intent(Genres.this, Discover.class));
    }

}
