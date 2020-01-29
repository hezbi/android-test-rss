package com.islamistudio.rssfeed.ui.base;

import android.content.Context;

import com.islamistudio.rssfeed.utils.Configure;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RssFeedPresenter<V extends BaseView> implements BasePresenter<V> {

    protected V view;
    protected Context context;

    public RssFeedPresenter(V view) {
        this.view = view;
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    public Retrofit createRetrofit() {

        try {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .build();

            return new Retrofit.Builder()
                    .baseUrl(Configure.BASE_URL)
                    .client(client)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
