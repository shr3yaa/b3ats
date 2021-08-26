package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ArtistPlaylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_playlist);
        getSupportActionBar().setTitle("Artists");
    }
    public void Library(View view) {
        startActivity(new Intent(ArtistPlaylist.this, Library.class));
    }
    public void Settings(View view) {
        startActivity(new Intent(ArtistPlaylist.this, Settings.class));
    }
    public void Discover(View view) {
        startActivity(new Intent(ArtistPlaylist.this, Discover.class));
    }
}
