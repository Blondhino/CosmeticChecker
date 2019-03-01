package com.blondi.lv4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private Call<List<Product>> apiCall;
    private Button btnSearch;
    private EditText etSearch;
    private RecyclerView recycler;
    private RecyclerAdapter adapter;
    private List<Product> productlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecycler();
        btnSearch = (Button) findViewById(R.id.btnSearch);
        etSearch=(EditText) findViewById(R.id.etSearch);


    btnSearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            setAPIcall(etSearch.getText().toString());
        }
    });
    }

    private void setUpRecycler(){
        productlist=new ArrayList<>();
        recycler=findViewById(R.id.rvProducts);
        recycler.setLayoutManager(new LinearLayoutManager(this  ));
        adapter=new RecyclerAdapter(getApplicationContext(),productlist);
        recycler.setAdapter(adapter);
    }

    private void setAPIcall(String type) {
        apiCall = NetworkUtils.getApiInterface().getProducts(type);
        apiCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>>
                    response) {
                if (response.isSuccessful() && response.body() != null) {
                    productlist=response.body();
                    adapter.setProducts(productlist);
                }
                if (response.isSuccessful() && response.body().size()==0)
                {
                    Toast.makeText(MainActivity.this, "Product Not Found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showProducts(List<Product> data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Product tempProduct : data) {
            stringBuilder.append(tempProduct.getName()).append("\n")
                    .append(tempProduct.getName()).append("\n\n");

        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (apiCall != null)
            apiCall.cancel();
    }

}
