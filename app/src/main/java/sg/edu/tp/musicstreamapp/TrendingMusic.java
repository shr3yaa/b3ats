package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TrendingMusic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_music);
        getSupportActionBar().setTitle("Trending Music");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void Discover(View view) {
        startActivity(new Intent(TrendingMusic.this, Discover.class));
    }
    public void Library(View view) {
        startActivity(new Intent(TrendingMusic.this, Library.class));
    }
    public void Settings(View view) {
        startActivity(new Intent(TrendingMusic.this, Settings.class));
    }
}
