package nyc.c4q.shannonalexander_navarro.testreview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.testreview.models.PlayList;
import nyc.c4q.shannonalexander_navarro.testreview.models.RadioResponse;
import nyc.c4q.shannonalexander_navarro.testreview.models.Song;
import nyc.c4q.shannonalexander_navarro.testreview.network.PlayListService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shannonalexander-navarro on 12/8/16.
 */

public class PlayListFragment extends Fragment {

    private static final String BBC_URL = "http://www.bbc.co.uk/";
    RecyclerView playListAView;
    SongAdapter songAdapter;
    List<Song> songList = new ArrayList<>(); //this is really a placeholder, it will be replaced by what comes back from retrofit

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_playlist, container, false);
        //only the root knows where the recyclerview is which is why we use findViewByID on it
        playListAView = (RecyclerView) root.findViewById((R.id.playlist_a));
        playListAView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        fetchPlayList();
        return root;
    }

    private void fetchPlayList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BBC_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlayListService service = retrofit.create(PlayListService.class);

        Call<RadioResponse> call = service.getPlayLists();
        call.enqueue(new Callback<RadioResponse>() { //needs to be enqueue so the call is asynchronous and will not block the main thread
            @Override
            public void onResponse(Call<RadioResponse> call, Response<RadioResponse> response) {
                RadioResponse radioResponse = response.body();
                PlayList ourPlayList = radioResponse.getPlayList();
                songList = ourPlayList.getA();

                songAdapter = new SongAdapter(songList); //pass our list of songs into the adapter
                playListAView.setAdapter(songAdapter); //set adapter to the recyclerView with the song list
            }

            @Override
            public void onFailure(Call<RadioResponse> call, Throwable t) {

            }
        });

    }

}
