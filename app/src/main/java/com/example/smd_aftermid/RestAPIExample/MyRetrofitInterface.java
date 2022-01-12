package com.example.smd_aftermid.RestAPIExample;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface MyRetrofitInterface {
    @GET("posts")
    Call<List<myRetrofitModel>> getlist();

//    @GET("posts/1/comments")
//    Call<List<myCommentsModel>> getComment();

    @GET("posts/{id}/comments")
    Call<List<myCommentsModel>> getComment(@Path("id") int id);

    @GET("comments")
    Call<List<myCommentsModel>> getMyCommentByQueryString(@Query("postId") int id);

    @GET()
    Call<List<myCommentsModel>> getCommentByURL(@Url String url);

    @GET("comments")
    Call<List<myCommentsModel>> getMyCommentsByArguments(Map<String,String> Arguments);

    @POST("psots")
    Call<myRetrofitModel> createPost(@Body myRetrofitModel post);
}
