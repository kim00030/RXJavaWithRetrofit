package demo.dankim.com.rxjavademofromkvishalkamboj.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.dankim.com.rxjavademofromkvishalkamboj.R;
import demo.dankim.com.rxjavademofromkvishalkamboj.model.Hero;

/**
 * Created by Dan Kim on 2019-01-29
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private Context context;
    private List<Hero> heroList = new ArrayList<>();

    public RecyclerAdapter(Context context, List<Hero> heroes) {

        this.context = context;
        this.heroList = heroes;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {

        itemViewHolder.tvName.setText(this.heroList.get(position).getName());
        itemViewHolder.tvRealName.setText(this.heroList.get(position).getRealName());
        itemViewHolder.tvTeam.setText(this.heroList.get(position).getTeam());
        itemViewHolder.tvFirstAppearance.setText(this.heroList.get(position).getFirstAppearance());
        itemViewHolder.tvCreatedBy.setText(this.heroList.get(position).getCreatedBy());
        itemViewHolder.tvPublisher.setText(this.heroList.get(position).getPublisher());
        itemViewHolder.tvImageUrl.setText(this.heroList.get(position).getImageUrl());
        itemViewHolder.tvBio.setText(this.heroList.get(position).getBio());

    }

    @Override
    public int getItemCount() {
        return this.heroList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {


        private TextView tvName, tvRealName, tvTeam, tvFirstAppearance, tvCreatedBy, tvPublisher, tvImageUrl, tvBio;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvRealName = itemView.findViewById(R.id.tv_real_name);
            tvTeam = itemView.findViewById(R.id.tv_team);
            tvFirstAppearance = itemView.findViewById(R.id.tv_first_appearance);
            tvCreatedBy = itemView.findViewById(R.id.tv_created_by);
            tvPublisher = itemView.findViewById(R.id.tv_publisher);
            tvImageUrl = itemView.findViewById(R.id.tv_image_url);
            tvBio = itemView.findViewById(R.id.tv_bio);
        }
    }
}
