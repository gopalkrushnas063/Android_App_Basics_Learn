package com.example.fetchapi;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(new ArrayList<>());
        recyclerView.setAdapter(productAdapter);

        apiService = new ApiService(this);
        fetchData();
    }

    private void fetchData() {
        apiService.fetchProducts(
                response -> {
                    try {
                        ArrayList<Product> products = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            products.add(new Product(response.getJSONObject(i)));
                        }
                        productAdapter.setProducts(products);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    // Handle error
                }
        );
    }
}
