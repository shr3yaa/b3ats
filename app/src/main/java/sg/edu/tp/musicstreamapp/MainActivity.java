package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sg.edu.tp.musicstreamapp.util.AppUtil;

public class MainActivity extends AppCompatActivity {

    private SongCollection songCollection = new SongCollection();
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(MainActivity.this, Login.class);
                startActivity(homeIntent);
                finish();
            }

        },SPLASH_TIME_OUT);
    }
    public void handleSelection(View view){
        String resourceId = AppUtil.getResourceId(this,view);

        Song selectedSong = songCollection.searchById(resourceId);

        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getTitle());

        sendDataToActivity(selectedSong);
    }

    public void sendDataToActivity(Song song){
        Intent intent = new Intent (this, PlaySongActivity1.class);
        intent.putExtra("id", song.getId());
        intent.putExtra("title", song.getTitle());
        intent.putExtra("artist", song.getArtist());
        intent.putExtra("fileLink", song.getFileLink());
        intent.putExtra("coverArt", song.getCoverArt());

        startActivity(intent);
    }


}
