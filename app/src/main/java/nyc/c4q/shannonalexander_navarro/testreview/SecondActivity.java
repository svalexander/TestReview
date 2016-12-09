package nyc.c4q.shannonalexander_navarro.testreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.testreview.models.Song;

public class SecondActivity extends AppCompatActivity {

    TextView songView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Song song = (Song) intent.getSerializableExtra("Song"); //serializable extra b/c you are getting an object
        //if it was a string it would be getStringExtra
        songView = (TextView) findViewById(R.id.song_TV);
        songView.setText(song.getTitle());
    }
}
