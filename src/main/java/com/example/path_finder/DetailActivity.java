package com.example.path_finder;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.path_finder.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail); // Check karein ke ye layout file maujood ho

        ImageView img = findViewById(R.id.detailImage);
        TextView title = findViewById(R.id.detailTitle);
        TextView desc = findViewById(R.id.detailDesc);

        // Data receive karna
        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESC");
        int image = getIntent().getIntExtra("IMG", 0);

        // Data screen par set karna
        if (name != null) title.setText(name);
        if (description != null) desc.setText(description);
        if (image != 0) img.setImageResource(image);
    }
}