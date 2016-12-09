package nyc.c4q.shannonalexander_navarro.testreview.network;

import nyc.c4q.shannonalexander_navarro.testreview.models.RadioResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shannonalexander-navarro on 12/8/16.
 */

public interface PlayListService {
    @GET("/radio1/playlist.json")
    Call<RadioResponse> getPlayLists();
    //we need to call the radio response b/c we are getting an object that has playlists in it

    //if we have to query it will look like this:
    //(a query is what is btwn the ? and the =)
    //Call<RadioResponse> getPlayLists(@Query("search_query") String query);
}
