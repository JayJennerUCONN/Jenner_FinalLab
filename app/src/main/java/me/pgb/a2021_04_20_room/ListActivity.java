package me.pgb.a2021_04_20_room;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Application;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;


import me.pgb.a2021_04_20_room.db.Stock;


public class ListActivity extends AppCompatActivity {
    private PortfolioViewModel portfolioViewModel;
    private Button gotoeditButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);
        gotoeditButton = findViewById(R.id.action_button_list);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        StockAdapter adapter = new StockAdapter();
        recyclerView.setAdapter(adapter);
        gotoeditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        portfolioViewModel = new ViewModelProvider(this).get(PortfolioViewModel.class);
        portfolioViewModel.getAllStocks().observe(this, new Observer<List<Stock>>() {
            @Override
            public void onChanged(@Nullable List<Stock> Stocks) {
                adapter.setStocks(Stocks);
            }
        });
    }
}