package nyc.c4q.shannonalexander_navarro.testreview.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shannonalexander-navarro on 12/8/16.
 */

public class RadioResponse {
    @SerializedName("playlist")
    @Expose
    private PlayList playList;

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }
}
