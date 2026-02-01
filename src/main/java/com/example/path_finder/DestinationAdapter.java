package com.example.path_finder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> {

    private List<Destination> destinationList;

    public DestinationAdapter(List<Destination> destinationList) {
        this.destinationList = destinationList;
    }

    public void filterList(ArrayList<Destination> filteredList) {
        this.destinationList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_destination, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Destination item = destinationList.get(position);
        holder.title.setText(item.getName());
        holder.desc.setText(item.getDescription());
        holder.img.setImageResource(item.getImageResource());

        // Card par click karne se DetailActivity khulegi
        holder.itemView.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("NAME", item.getName());
            intent.putExtra("DESC", item.getDescription());
            intent.putExtra("IMG", item.getImageResource());
            v.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgDestination);
            title = itemView.findViewById(R.id.txtTitle);
            desc = itemView.findViewById(R.id.txtDescription);
        }
    }
}