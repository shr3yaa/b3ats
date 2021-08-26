package sg.edu.tp.musicstreamapp;

import java.util.Random;

public class SongCollection {
    private Song[] songs = new Song [5];

    public SongCollection(){
        prepareSongs();
    }


    private void prepareSongs(){
        Song Amsterdam = new Song("S1001", "Amsterdam", "Peachy!",
                "e734af3ffb0afc4ee6b4df0402284d06532d12ce?cid=2afe87a64b0042dabf51f37318616965",1.75,
                "amsterdam_peachy");

        Song compass = new Song("S1002", "Compass","The Neighbourhood",
                "1cc1b05d1f9368fe80b037ed2f6ea3dcaf9c461f?cid=2afe87a64b0042dabf51f37318616965",2.8, "compass_theneighbourhood");

        Song FallingForU = new Song("S1003", "Falling For U","Peachy! feat. MxmToon",
                "02760bb3822c68ec6b0e63bd45a42a9ee3b1a9d7?cid=2afe87a64b0042dabf51f37318616965",2.07, "falling_for_u_peachy");

        Song TheCalling = new Song("S1004", "The Calling","TheFatRat",
                "ccee7fc5abf43692faa6ad0650371b6b719a9ea6?cid=2afe87a64b0042dabf51f37318616965",3.89, "the_calling_thefatrat");

        Song ThereForYou = new Song("S1005", "There For you","Martin Garrix feat. Troye Sivan",
                "090c4307f87985a4fd16f87ed10660b86207dfd2?cid=2afe87a64b0042dabf51f37318616965",3.7, "there_for_you");


        songs[0]= Amsterdam;
        songs[1]= compass;
        songs[2]= FallingForU;
        songs[3]= TheCalling;
        songs[4]=ThereForYou;
    }
    public Song searchById (String id)
    {
        Song song = null;
        for(int index=0; index<songs.length; index ++)
        {
            song=songs[index];
            if (song.getId().equals(id))
            {
                return song;
            }
        }
        return song;
    }
    public Song getNextSong(String currentSongId)
    {
        Song song =null;

        for (int index=0; index < songs.length; index++)
        {
            String tempSongId = songs[index].getId();

            if(tempSongId.equals(currentSongId)&& (index< songs.length -1))
            {
                song=songs[index+1];
                break;
            }
        }

        return song;
    }

    public Song getPrevSong(String currentSongId)
    {
        Song song =null;

        for (int index=0; index < songs.length; index++)
        {
            String tempSongId = songs[index].getId();

            if(tempSongId.equals(currentSongId)&& (index > 0))
            {
                song=songs[index-1];
                break;
            }
        }

        return song;
    }
}
