package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

import sg.edu.tp.musicstreamapp.util.AppUtil;

public class PlaySongActivity1 extends AppCompatActivity {


    SeekBar positionBar;
    SeekBar volumeBar;
    int totalTime;

    Handler handler;
    Runnable runnable;

    private static final String BASE_URL = "https://p.scdn.co/mp3-preview/";

    private String songId = "";
    private String title = "";
    private String artist = "";
    private String fileLink = "";
    private String coverArt = "";
    private String url = "";

    private MediaPlayer player = null;
    private int musicPosition = 0;
    private Button btnPlayPause = null;
    private Button repeat =null;



    private SongCollection songCollection = new SongCollection();
    private final int[] resID = {R.raw.amsterdam, R.raw.compass, R.raw.fallingforu,
            R.raw.thecalling, R.raw.thereforu,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song1);

        handler = new Handler();
        btnPlayPause = findViewById(R.id.btnPlayPause);
        retrieveData();
        displaySong(title, artist, coverArt);


        player = MediaPlayer.create(getApplicationContext(), resID[musicPosition]);
        player.seekTo(0);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        totalTime = player.getDuration();


        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        volumeBar=(SeekBar)findViewById(R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum =progress/100f;
                player.setVolume(volumeNum,volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer player) {
                positionBar.setMax(player.getDuration());
                playCycle();
                player.start();
            }
        });


        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar positionBar, int progress, boolean fromUser) {
                if (fromUser) {
                    player.seekTo(progress);
                    gracefullyStopWhenMusicEnds();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar positionBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar positionBar) {
                gracefullyStopWhenMusicEnds();
            }
        });

    }


    public void playCycle() {
        positionBar.setProgress(player.getCurrentPosition());

        if (player.isPlaying()) {
            runnable = new Runnable() {
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
        handler.removeCallbacks(runnable);
        gracefullyStopWhenMusicEnds();
    }

    public void playNext(View view) {
        Song nextSong = songCollection.getNextSong(songId);
        if (nextSong != null) {
            songId = nextSong.getId();
            title = nextSong.getTitle();
            artist = nextSong.getArtist();
            fileLink = nextSong.getFileLink();
            coverArt = nextSong.getCoverArt();

            url = BASE_URL + fileLink;
            displaySong(title, artist, coverArt);

            stopActivities();
            playOrPauseMusic(view);
        }
    }

    public void playPrevious(View view) {
        Song prevSong = songCollection.getPrevSong(songId);
        if (prevSong != null) {
            songId = prevSong.getId();
            title = prevSong.getTitle();
            artist = prevSong.getArtist();
            fileLink = prevSong.getFileLink();
            coverArt = prevSong.getCoverArt();
            url = BASE_URL + fileLink;
            displaySong(title, artist, coverArt);

            stopActivities();
            playOrPauseMusic(view);

        }
    }


    public void playOrPauseMusic(View view) {

        if (player == null) {
            preparePlayer();
        }
        if (!player.isPlaying()) {
            if (musicPosition > 0) {
                player.seekTo(musicPosition);
            }
            player.start();
            btnPlayPause.setBackgroundResource(R.drawable.ic_pause_black_24dp);

            setTitle("Now playing: " + title + " - " + artist);
            gracefullyStopWhenMusicEnds();
        } else {
            pauseMusic();
        }

    }

    public void repeat(View view) {
        player.setLooping(true);


    }

    private void gracefullyStopWhenMusicEnds() {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (player != null) {
                    musicPosition = 0;
                    setTitle("");
                    btnPlayPause.setBackgroundResource(R.drawable.ic_play_circle_outline_black_24dp);
                    player.pause();
                }

            }
        });
    }

    private void stopActivities() {
        btnPlayPause.setText("");
        musicPosition = 0;
        btnPlayPause.setBackgroundResource(R.drawable.ic_play_circle_outline_black_24dp);

        player.stop();

        player.release();

        player = null;

    }

    private void pauseMusic() {
        player.pause();
        musicPosition = player.getCurrentPosition();
        btnPlayPause.setBackgroundResource(R.drawable.ic_play_circle_outline_black_24dp);
    }

    private void preparePlayer() {
        player = new MediaPlayer();
        try {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(url);
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void displaySong(String title, String artist, String coverArt) {
        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);

        TextView txtArtist = findViewById(R.id.txtArtist);
        txtArtist.setText(artist);

        int imageId = AppUtil.getImageIdFromDrawable(this, coverArt);

        ImageView ivCoverArt = findViewById(R.id.imgCoverArt);
        ivCoverArt.setImageResource(imageId);
    }

    private void retrieveData() {
        Bundle songData = this.getIntent().getExtras();
        songId = songData.getString("id");
        title = songData.getString("title");
        artist = songData.getString("artist");
        fileLink = songData.getString("fileLink");
        coverArt = songData.getString("coverArt");

        url = BASE_URL + fileLink;

    }
}