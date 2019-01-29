package demo.dankim.com.rxjavademofromkvishalkamboj.remote;

import java.util.List;

import demo.dankim.com.rxjavademofromkvishalkamboj.model.Hero;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Dan Kim on 2019-01-29
 *
 * full url: https://simplifiedcoding.net/demos/marvel/
 */
public interface ApiService {

    @GET("marvel")
    Observable<List<Hero>> getHeroList();

}
