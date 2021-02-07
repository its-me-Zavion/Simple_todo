package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter  extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

  public interface OnLongClickListener {
      void onItemLongClicked( int position);
  }
   List<String> items;
   OnLongClickListener longclicklistener;

    public ItemsAdapter(List<String> items, OnLongClickListener longclicklistener) {
        this.items = items;
        this.longclicklistener = longclicklistener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

        return new ViewHolder(todoView);
    }

    @Override

    //this binds data to view holder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //get position
    //  bind to holder

        String item = items.get(position);

        holder.bind(item);
    }

    @Override
   // tells the rv the # of items in list
    public int getItemCount() {
        return items.size();
    }

    //container
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }
//update view in viewholder
        public void bind(String item) {
            tvItem.setText(item);
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //notify what was long clicked
                    longclicklistener.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
