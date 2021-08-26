package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import sg.edu.tp.musicstreamapp.util.AppUtil;

public class HomeActivity extends AppCompatActivity {

    private SongCollection songCollection = new SongCollection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("All Songs");


    }
    public void handleSelection(View myview){
        String resourceId = AppUtil.getResourceId(this, myview);

        Song selectedSong = songCollection.searchById(resourceId);

        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getTitle());

        sendDataToActivity(selectedSong);
    }
    public void sendDataToActivity(Song song){
        Intent intent =new Intent(this, PlaySongActivity1.class);
        intent.putExtra("id", song.getId());
        intent.putExtra("title", song.getTitle());
        intent.putExtra("artist", song.getArtist());
        intent.putExtra("fileLink", song.getFileLink());
        intent.putExtra("coverArt", song.getCoverArt());

        startActivity(intent);
    }


    public void Settings(View view) {
        startActivity(new Intent(HomeActivity.this, Settings.class));
    }
    public void Discover(View view) {
        startActivity(new Intent(HomeActivity.this, Discover.class));
    }
    public void Library(View view) {
        startActivity(new Intent(HomeActivity.this, Library.class));
    }

}


