package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlbumPlaylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_playlist);
        getSupportActionBar().setTitle("Albums");
    }
    public void Library(View view) {
        startActivity(new Intent(AlbumPlaylist.this, Library.class));
    }
    public void Settings(View view) {
        startActivity(new Intent(AlbumPlaylist.this, Settings.class));
    }
    public void Discover(View view) {
        startActivity(new Intent(AlbumPlaylist.this, Discover.class));
    }
}
