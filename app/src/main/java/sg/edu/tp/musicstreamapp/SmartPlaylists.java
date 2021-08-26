package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SmartPlaylists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_playlists);
        getSupportActionBar().setTitle("Smart Playlists");

    }
    public void albums (View view) {
        startActivity(new Intent(SmartPlaylists.this, AlbumPlaylist.class));
    }
    public void artists (View view) {
        startActivity(new Intent(SmartPlaylists.this, ArtistPlaylist.class));
    }
    public void Library(View view) {
        startActivity(new Intent(SmartPlaylists.this, Library.class));
    }
    public void Settings(View view) {
        startActivity(new Intent(SmartPlaylists.this, Settings.class));
    }
    public void Discover(View view) {
        startActivity(new Intent(SmartPlaylists.this, Discover.class));
    }
}

