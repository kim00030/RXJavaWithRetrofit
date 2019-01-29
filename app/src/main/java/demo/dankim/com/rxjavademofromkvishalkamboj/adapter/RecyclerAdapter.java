package demo.dankim.com.rxjavademofromkvishalkamboj.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.dankim.com.rxjavademofromkvishalkamboj.databinding.ItemLayoutBinding;
import demo.dankim.com.rxjavademofromkvishalkamboj.model.Hero;

/**
 * Created by Dan Kim on 2019-01-29
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private List<Hero> heroList = new ArrayList<>();
    private LayoutInflater layoutInflater;


    public RecyclerAdapter(List<Hero> heroes) {

        this.heroList = heroes;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        ItemLayoutBinding itemLayoutBinding = ItemLayoutBinding.inflate(layoutInflater, viewGroup, false);
        return new ItemViewHolder(itemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {

        Hero hero = this.heroList.get(position);
        itemViewHolder.bind(hero);
    }

    @Override
    public int getItemCount() {
        return this.heroList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        //Binding object generated by Binding API
        private ItemLayoutBinding itemLayoutBinding;

        public ItemViewHolder(@NonNull ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;

        }

        public void bind(Hero hero) {
            this.itemLayoutBinding.setHero(hero);
        }

    }
}
