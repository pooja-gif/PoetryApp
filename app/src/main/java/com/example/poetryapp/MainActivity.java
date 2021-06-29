package com.example.poetryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
PoetryAdapter poetryAdapter;
//List<PoetryModel> poetryModelList = new ArrayList<>();
ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.poetry_recyclerview);
       // poetryAdapter = new PoetryAdapter(this, poetryModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(poetryAdapter);

        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
       // prepareListData();

        getData();
    }

    /*    private void prepareListData() {
        poetryModelList.add(new PoetryModel(1,"Mirza Galib","Life becomes easy when you accet the things and make positive changes as per needed","10-Apr-2021"));
        poetryModelList.add(new PoetryModel(1,"Mirza Galib","Life becomes easy when you accet the things and make positive changes as per needed","10-Apr-2021"));
        poetryModelList.add(new PoetryModel(1,"Mirza Galib","Life becomes easy when you accet the things and make positive changes as per needed","10-Apr-2021"));
        poetryModelList.add(new PoetryModel(1,"Mirza Galib","Life becomes easy when you accet the things and make positive changes as per needed","10-Apr-2021"));
        poetryModelList.add(new PoetryModel(1,"Mirza Galib","Life becomes easy when you accet the things and make positive changes as per needed","10-Apr-2021"));
        poetryModelList.add(new PoetryModel(1,"Mirza Galib","Life becomes easy when you accet the things and make positive changes as per needed","10-Apr-2021"));

        poetryAdapter.notifyDataSetChanged();
   }*/

private void getData(){
        apiInterface.readpoetry().enqueue(new Callback<GetPoetryResponse>() {
            @Override
            public void onResponse(Call<GetPoetryResponse> call, Response<GetPoetryResponse> response) {

                try {
                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {

                            setadapter(response.body().getData());
                        } else {
                            Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } finally {

                }
                ;
            }

            @Override
            public void onFailure(Call<GetPoetryResponse> call, Throwable t) {

                Log.e("failure",t.getLocalizedMessage());
            }
        });
}

   public void setadapter(List<PoetryModel> poetryModelList){
        poetryAdapter = new PoetryAdapter(this,poetryModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(poetryAdapter);

    }
}