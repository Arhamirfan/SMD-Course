package com.example.smd_aftermid.RestAPIExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.smd_aftermid.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRestMainActivity extends AppCompatActivity {

    MyRetrofitInterface apiInterface;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rest_main);

        recyclerView = findViewById(R.id.myretrorecyclerview);
        apiInterface = myRetrofit.getRetrofit().create(MyRetrofitInterface.class);

//        getMyPost();
//        getMyComments();
//        getMyCommentByQueryString();
//        getCommentByURL();
        CreatePost();
    }

    public  void CreatePost()
    {
        myRetrofitModel model = new myRetrofitModel(5,"Title of screen","This is to post data");
        Call<myRetrofitModel> myPost = apiInterface.createPost(model);
        myPost.enqueue(new Callback<myRetrofitModel>() {
            @Override
            public void onResponse(Call<myRetrofitModel> call, Response<myRetrofitModel> response) {
                if(response.isSuccessful())
                {
                    Log.d("TAG", " " + response.body().getUserId() + "\n" + response.body().getTitle() + "\n" + response.body().getBody());
                }
            }

            @Override
            public void onFailure(Call<myRetrofitModel> call, Throwable t) {

            }
        });
    }

    public  void getMyCommentsByArguments()
    {
        Map<String,String> Arguments = new HashMap<>();
        Arguments.put("postId","4");
        Arguments.put("_sort","id");
        Arguments.put("_order","desc");
        Call<List<myCommentsModel>> list = apiInterface.getMyCommentsByArguments(Arguments);
        list.enqueue(new Callback<List<myCommentsModel>>() {
            @Override
            public void onResponse(Call<List<myCommentsModel>> call, Response<List<myCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for ( myCommentsModel commentsModel: response.body())
                    {
                        Log.d("TAG", "ID : " + commentsModel.getId() +  "Post name : "+ commentsModel.getName() + " Comment : " + commentsModel.getBody());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<myCommentsModel>> call, Throwable t) {

            }
        });
    }
    public void getCommentByURL()
    {
//        Map<String,String> Arguments = new HashMap<>();
//        Arguments.put("postId","3");
        Call<List<myCommentsModel>> list = apiInterface.getCommentByURL("https://jsonplaceholder.typicode.com/comments?postId=1");
        list.enqueue(new Callback<List<myCommentsModel>>() {
            @Override
            public void onResponse(Call<List<myCommentsModel>> call, Response<List<myCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for ( myCommentsModel commentsModel: response.body())
                    {
                        Log.d("TAG", "ID : " + commentsModel.getId() +  "Post name : "+ commentsModel.getName() + " Comment : " + commentsModel.getBody());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<myCommentsModel>> call, Throwable t) {

            }
        });
    }

    public void getMyCommentByQueryString()
    {
        Call<List<myCommentsModel>> list = apiInterface.getMyCommentByQueryString(5);
        list.enqueue(new Callback<List<myCommentsModel>>() {
            @Override
            public void onResponse(Call<List<myCommentsModel>> call, Response<List<myCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for ( myCommentsModel commentsModel: response.body())
                    {
                        Log.d("TAG", "ID : " + commentsModel.getId() +  "Post name : "+ commentsModel.getName() + " Comment : " + commentsModel.getBody());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<myCommentsModel>> call, Throwable t) {

            }
        });
    }
    private void getMyComments()
    {
        Call<List<myCommentsModel>> list = apiInterface.getComment(5);
        list.enqueue(new Callback<List<myCommentsModel>>() {
            @Override
            public void onResponse(Call<List<myCommentsModel>> call, Response<List<myCommentsModel>> response) {
                if(response.isSuccessful())
                {
                    for ( myCommentsModel commentsModel: response.body())
                    {
                        Log.d("TAG", "ID : " + commentsModel.getId() +  "Post name : "+ commentsModel.getName() + " Comment : " + commentsModel.getBody());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<myCommentsModel>> call, Throwable t) {

            }
        });
    }
    private void getMyPost() {
        apiInterface.getlist().enqueue(new Callback<List<myRetrofitModel>>() {
            @Override
            public void onResponse(Call<List<myRetrofitModel>> call, Response<List<myRetrofitModel>> response) {
                if(response.body().size() > 0)
                {
                    List<myRetrofitModel> list = response.body();
                    myRestAdapter adapter = new myRestAdapter(list,getApplicationContext());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);

                    Toast.makeText(MyRestMainActivity.this, "Data retrived", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MyRestMainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<myRetrofitModel>> call, Throwable t) {

            }
        });
    }
}