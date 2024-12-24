package com.example.crudapps;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudapps.adapter.AdapterCrud;
import com.example.crudapps.dataset.ItemData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ItemData> array;
    private AdapterCrud adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_curd();
    }

    private void add_curd(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        array = new ArrayList<ItemData>();
        array.add(new ItemData("1", "Bakso bakar", 0, "https://img-global.cpcdn.com/recipes/d185e9793017b3d4/1502x1064cq70/bakso-bakar-simple-enak-foto-resep-utama.jpg"));
        array.add(new ItemData("2", "Bakso Lava", 0, "https://img-global.cpcdn.com/recipes/d185e9793017b3d4/1502x1064cq70/bakso-bakar-simple-enak-foto-resep-utama.jpg"));
        array.add(new ItemData("3", "Bakso urat", 0, "https://img-global.cpcdn.com/recipes/d185e9793017b3d4/1502x1064cq70/bakso-bakar-simple-enak-foto-resep-utama.jpg"));
        array.add(new ItemData("4", "Bakso beranak", 0, "https://img-global.cpcdn.com/recipes/d185e9793017b3d4/1502x1064cq70/bakso-bakar-simple-enak-foto-resep-utama.jpg"));
        adapter = new AdapterCrud(this, array);
        recyclerView.setAdapter(adapter);
    }

}