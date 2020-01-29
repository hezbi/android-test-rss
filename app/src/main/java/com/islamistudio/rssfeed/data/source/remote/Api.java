package com.islamistudio.rssfeed.data.source.remote;

import com.islamistudio.rssfeed.data.source.remote.response.RssResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("sepakbola")
    Call<RssResponse> getSoccerXML();

}
