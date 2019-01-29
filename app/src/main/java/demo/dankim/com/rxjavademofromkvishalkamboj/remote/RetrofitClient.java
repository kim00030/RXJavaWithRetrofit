package demo.dankim.com.rxjavademofromkvishalkamboj.remote;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dan Kim on 2019-01-29
 */
public class RetrofitClient {

    private static final String BASE_URL = " https://simplifiedcoding.net/demos/";
    private static RetrofitClient instance;
    private final Retrofit retrofit;

    /**
     * I need
     * addCallAdapterFactory(RxJava2CallAdapterFactory.create())
     * to use Rxjava adapter
     */
    public RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ApiService getApi() {
        return retrofit.create(ApiService.class);
    }
}
