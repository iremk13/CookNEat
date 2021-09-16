package com.project.foodrecipes.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.foodrecipes.R;
import com.project.foodrecipes.model.ModelFilter;
import com.squareup.picasso.Picasso;

import java.util.List;


public class FilterFoodAdapter extends RecyclerView.Adapter<FilterFoodAdapter.ViewHolder> {

    private List<ModelFilter> items;
    private FilterFoodAdapter.onSelectData onSelectData;
    private Context mContext;

    public interface onSelectData {
        void onSelected(ModelFilter modelMain);
    }

    public FilterFoodAdapter(Context context, List<ModelFilter> items, FilterFoodAdapter.onSelectData xSelectData) {
        this.mContext = context;
        this.items = items;
        this.onSelectData = xSelectData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_filter_food, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ModelFilter data = items.get(position);



        Picasso
                .get().load(data.strMealThumb)
                .placeholder(R.drawable.ic_food_placeholder)
                .into(holder.imgThumb);

        holder.tvMeal.setText(data.strMeal);
        holder.cvFilterMeal.setOnClickListener(v -> onSelectData.onSelected(data));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMeal;
        public CardView cvFilterMeal;
        public ImageView imgThumb;

        public ViewHolder(View itemView) {
            super(itemView);
            cvFilterMeal = itemView.findViewById(R.id.cvFilterMeal);
            tvMeal       = itemView.findViewById(R.id.tvMeal);
            imgThumb     = itemView.findViewById(R.id.imgThumb);

        }
    }

}
