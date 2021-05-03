package me.pgb.a2021_04_20_room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import me.pgb.a2021_04_20_room.db.Stock;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockHolder>{
    private List<Stock> stocks = new ArrayList<>();
    @NonNull
    @Override
    public StockHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_item, parent, false);
        return new StockHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StockAdapter.StockHolder holder, int position) {
        Stock currentStock = stocks.get(position);
        holder.textViewName.setText(currentStock.getName());
        holder.textViewPrice.setText(String.valueOf(currentStock.getPrice()));
        holder.textViewId.setText(String.valueOf(currentStock.getId()));
    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }


    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
        notifyDataSetChanged();
    }

    public class StockHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewPrice;
        private TextView textViewId;
        public StockHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewPrice = itemView.findViewById(R.id.text_view_price);
            textViewId = itemView.findViewById(R.id.text_view_id);

    }
}
}
