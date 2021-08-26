package sg.edu.tp.musicstreamapp;

public class Song {
    private String id;
    private String title;
    private String artist;
    private String fileLink;
    private double songLength;
    private String coverArt;

    public Song(String id, String title, String artist, String fileLink, double songLength, String coverArt)
    { this.id = id;
        this.title = title;
        this.artist = artist;
        this.fileLink = fileLink;
        this.songLength = songLength;
        this.coverArt = coverArt;
    }
        public String getId(){
        return id;
    }
        public String getTitle(){
        return title;
    }
        public String getArtist(){
        return artist;
    }
        public String getFileLink(){
        return fileLink;
    }
        public double getSongLength(){
        return songLength;
    }
        public String getCoverArt(){
        return coverArt;
    }

        public void setId(String id) {
        this.id = id;
    }

        public void setTitle(String title) {
        this.title = title;
    }

        public void setArtist(String artist) {
        this.artist = artist;
    }

        public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

        public void setSongLength(double songLength) {
        this.songLength = songLength;
    }

        public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

}
