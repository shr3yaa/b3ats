package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class Discover extends AppCompatActivity {
    private List<SongItem> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        getSupportActionBar().setTitle("Discover");


        fillSongList();

        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteSongAdapter adapter =new AutoCompleteSongAdapter(this, songList);
        editText.setAdapter(adapter);
    }
    private void fillSongList(){
        songList=new ArrayList<>();
        songList.add(new SongItem("Hello", R.drawable.clairo1));
        songList.add(new SongItem("Pretty Girl", R.drawable.clairo2));
        songList.add(new SongItem("Compass", R.drawable.compass_theneighbourhood));
        songList.add(new SongItem("Falling 4 U", R.drawable.falling_for_u_peachy));
        songList.add(new SongItem("One Kiss", R.drawable.one_kiss_dualipa));
        songList.add(new SongItem("Stay", R.drawable.stay_macmiller));
        songList.add(new SongItem("There For You", R.drawable.there_for_you));
        songList.add(new SongItem("The Calling", R.drawable.the_calling_thefatrat));

    }

    public void Library(View view) {
        startActivity(new Intent(Discover.this, Library.class));
    }
    public void Settings(View view) {
        startActivity(new Intent(Discover.this, Settings.class));
    }
    public void TrendingMusic(View view) {
        startActivity(new Intent(Discover.this, TrendingMusic.class));
    }
    public void Genres(View view) {
        startActivity(new Intent(Discover.this, Genres.class));
    }
    public void Mood(View view) {
        startActivity(new Intent(Discover.this, Mood.class));
    }

}