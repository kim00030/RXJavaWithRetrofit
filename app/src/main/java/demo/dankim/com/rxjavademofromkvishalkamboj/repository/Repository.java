package demo.dankim.com.rxjavademofromkvishalkamboj.repository;

import android.util.Log;

import java.util.List;

import demo.dankim.com.rxjavademofromkvishalkamboj.model.Hero;
import demo.dankim.com.rxjavademofromkvishalkamboj.remote.RetrofitClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dan Kim on 2019-01-29
 */
public class Repository {

    private static final String TAG = "Repository";
    private Callback callback;
    private Disposable disposable;

    public Repository(Callback callback) {

        this.callback = callback;
    }

    /**
     * Call Retrofit API to get Hero Data using RXJava
     */
    public void sendHeroDataRequest() {

        Observable<List<Hero>> observableList = RetrofitClient.getInstance().getApi().getHeroList();
        observableList.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Hero>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(List<Hero> heroes) {

                        callback.setResultWith(heroes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void dispose() {
        if (disposable != null) {
            disposable.dispose();
            disposable = null;
        }
    }

    public interface Callback {
        void setResultWith(List<Hero> heroList);
    }
}
