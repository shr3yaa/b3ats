package sg.edu.tp.musicstreamapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteSongAdapter extends ArrayAdapter<SongItem> {
    private List <SongItem>songListFull;

    public AutoCompleteSongAdapter(@NonNull Context context, @NonNull List<SongItem> songList) {
        super(context, 0, songList);
        songListFull=new ArrayList<>(songList);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return songFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView= LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_row,parent,false
            );
    }
        TextView textViewName=convertView.findViewById(R.id.text_view_name);
        ImageView imageViewSong=convertView.findViewById(R.id.hello);

        SongItem songitem=getItem(position);

        if (songitem != null){
            textViewName.setText(songitem.getSongName());
            imageViewSong.setImageResource(songitem.getSongImage());
        }
    return convertView;}

    private Filter songFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            List<SongItem>suggestions=new ArrayList<>();
            if (constraint==null || constraint.length()==0){
                suggestions.addAll(songListFull);
            }else{
                String filterPattern =constraint.toString().toLowerCase().trim();

                for (SongItem item: songListFull){
                    if (item.getSongName().toLowerCase().contains(filterPattern)){
                        suggestions.add(item);
                    }
                }
            }
            results.values=suggestions;
            results.count=suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List)results.values);

            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((SongItem)resultValue).getSongName();
        }
    };
}
