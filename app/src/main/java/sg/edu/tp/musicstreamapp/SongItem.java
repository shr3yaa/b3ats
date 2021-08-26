package sg.edu.tp.musicstreamapp;

public class SongItem {
    private String songName;
    private int songImage;

    public SongItem(String songName,int songImage){
        this.songName =songName;
        this.songImage=songImage;
    }
    public String getSongName(){
        return songName;
    }
    public int getSongImage(){
        return songImage;
    }
}
