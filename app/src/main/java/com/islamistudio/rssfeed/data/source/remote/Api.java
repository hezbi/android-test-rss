package com.islamistudio.rssfeed.data.source.remote;

import com.islamistudio.rssfeed.data.source.remote.response.RssResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("{id}")
    Observable<RssResponse> getSoccerXML(@Path("id") String ext);

}
