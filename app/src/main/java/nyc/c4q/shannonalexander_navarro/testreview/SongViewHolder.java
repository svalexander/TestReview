package nyc.c4q.shannonalexander_navarro.testreview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.testreview.models.Song;

/**
 * Created by shannonalexander-navarro on 12/8/16.
 */
public class SongViewHolder extends RecyclerView.ViewHolder {

    TextView artistNameTV;
    TextView songTitleTV;
    public Song song;

    public SongViewHolder(View itemView) {
        super(itemView);
        artistNameTV = (TextView) itemView.findViewById(R.id.song_artist);
        songTitleTV = (TextView) itemView.findViewById(R.id.song_title);
    }

    public void bind(final Song song) {
        artistNameTV.setText(song.getArtist());
        songTitleTV.setText(song.getTitle());

        final Context context = songTitleTV.getContext();
        itemView.setOnClickListener(new View.OnClickListener() { //onClick must be in the bind method in order to bind the data and be able to send it to another activity
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("Song", song);
                context.startActivity(intent);
            }
        });
    }
}
