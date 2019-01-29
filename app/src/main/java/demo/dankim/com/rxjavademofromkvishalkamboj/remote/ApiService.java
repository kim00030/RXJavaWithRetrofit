package demo.dankim.com.rxjavademofromkvishalkamboj.remote;

import java.util.List;

import demo.dankim.com.rxjavademofromkvishalkamboj.model.Hero;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 *
 *
 * full url: https://simplifiedcoding.net/demos/marvel/
 */
public interface ApiService {

    /**
     * Get Hero data list
     * @return RXJava Observable that holds Hero data list
     */
    @GET("marvel")
    Observable<List<Hero>> getHeroList();

}
