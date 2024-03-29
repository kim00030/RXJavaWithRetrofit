package demo.dankim.com.rxjavademofromkvishalkamboj;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import demo.dankim.com.rxjavademofromkvishalkamboj.adapter.RecyclerAdapter;
import demo.dankim.com.rxjavademofromkvishalkamboj.databinding.ActivityMainBinding;
import demo.dankim.com.rxjavademofromkvishalkamboj.model.Hero;
import demo.dankim.com.rxjavademofromkvishalkamboj.viewmodel.HeroViewModel;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private RecyclerAdapter recyclerAdapter;
    private HeroViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize DataBinding with activity_main.xml
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //Set IMainActivity to Bind
        activityMainBinding.setIMainActivity(this);
        // set LayoutManager to RecyclerView
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // set empty list to RecyclerView adapter
        List<Hero> heroList = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(heroList);
        // set adapter to RecyclerView
        activityMainBinding.recyclerView.setAdapter(recyclerAdapter);
        // Initialize ViewModel
        viewModel = ViewModelProviders.of(this).get(HeroViewModel.class);
        // Observe Data
        viewModel.getListMutableLiveData().observe(this, new android.arch.lifecycle.Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroes) {
                recyclerAdapter.setHeroList(heroes);

            }
        });
    }

    /**
     * When pressing the button for fetching data
     */
    @Override
    public void fetchData() {
        viewModel.sendRequest();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.dispose();

    }
}
