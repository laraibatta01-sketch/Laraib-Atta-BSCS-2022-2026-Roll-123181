package com.example.path_finder;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DestinationAdapter adapter;
    ArrayList<Destination> destinationList; // Isay ArrayList rakha hai taake filter asaan ho
    EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI elements link karna
        searchBar = findViewById(R.id.searchBar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Data list populate karna
        destinationList = new ArrayList<>();
        destinationList.add(new Destination("Swat Valley", "Switzerland of Pakistan with lush green mountains.", R.drawable.swat));
        destinationList.add(new Destination("Badshahi Mosque", "Historic Mughal architecture in Lahore.", R.drawable.lahore));
        destinationList.add(new Destination("Hunza Valley", "Stunning views of Rakaposhi and ancient forts.", R.drawable.hunza));
        destinationList.add(new Destination("Margalla Hills", "Beautiful hiking trails in Islamabad.", R.drawable.islamabad));
        destinationList.add(new Destination("Skardu", "Gateway to K2 and Shangrila Resort.", R.drawable.skardu));

        // Adapter set karna
        adapter = new DestinationAdapter(destinationList);
        recyclerView.setAdapter(adapter);

        // Search Bar Logic - Real-time filtering
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Jaise hi user type karega, filter function call hoga
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    // Ye function onCreate se BAHAR hai (Class ke andar)
    private void filter(String text) {
        ArrayList<Destination> filteredList = new ArrayList<>();

        for (Destination item : destinationList) {
            // Check karta hai ke search text name mein maujood hai ya nahi
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        // Adapter ko filtered list bhejna
        if (adapter != null) {
            adapter.filterList(filteredList);
        }
    }
}