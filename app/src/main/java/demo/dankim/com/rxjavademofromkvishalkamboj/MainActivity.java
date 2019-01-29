package demo.dankim.com.rxjavademofromkvishalkamboj;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.List;

import demo.dankim.com.rxjavademofromkvishalkamboj.adapter.RecyclerAdapter;
import demo.dankim.com.rxjavademofromkvishalkamboj.databinding.ActivityMainBinding;
import demo.dankim.com.rxjavademofromkvishalkamboj.model.Hero;
import demo.dankim.com.rxjavademofromkvishalkamboj.remote.RetrofitClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding activityMainBinding;
    private Disposable disposable;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setIMainActivity(this);

        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    /**
     * When pressing the button for fetching data
     */
    @Override
    public void fetchData() {

        loadJson();

    }

    private void loadJson() {

        Observable<List<Hero>> heroListObservable = RetrofitClient.getInstance().getApi().getHeroList();
        heroListObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Hero>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(List<Hero> heroes) {
                        Log.d(TAG, "onNext: " + heroes);
                        activityMainBinding.recyclerView.setAdapter(new RecyclerAdapter(MainActivity.this.getApplicationContext(), heroes));
                        activityMainBinding.recyclerView.setHasFixedSize(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
