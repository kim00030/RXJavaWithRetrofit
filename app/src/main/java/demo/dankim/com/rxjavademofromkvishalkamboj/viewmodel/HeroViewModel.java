package demo.dankim.com.rxjavademofromkvishalkamboj.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import demo.dankim.com.rxjavademofromkvishalkamboj.model.Hero;
import demo.dankim.com.rxjavademofromkvishalkamboj.repository.Repository;

/**
 * Created by Dan Kim on 2019-01-29
 */
public class HeroViewModel extends AndroidViewModel implements Repository.Callback{

    private Repository repository;
    private MutableLiveData<List<Hero>> listMutableLiveData = new MutableLiveData<>();

    public HeroViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(this);
    }

    public void sendRequest(){
        repository.sendHeroDataRequest();
    }

    @Override
    public void setResultWith(List<Hero> heroList) {
        listMutableLiveData.setValue(heroList);
    }

    public MutableLiveData<List<Hero>> getListMutableLiveData(){
        return listMutableLiveData;
    }

    public void dispose(){
        repository.dispose();
    }
}
