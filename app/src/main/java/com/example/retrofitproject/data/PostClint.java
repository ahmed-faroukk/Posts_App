package com.example.retrofitproject.data;

import com.example.retrofitproject.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClint {
    private static final String BaseUrl = "https://jsonplaceholder.typicode.com/" ;
    PostInterface postInterface ;
    private static PostClint Instance ;

    public PostClint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }
    public static PostClint GetInstance(){
        if(Instance==null)
            Instance = new PostClint();
        return Instance;
    }
    public Call<List<PostModel>> GetPosts(){
       return postInterface.GetPosts();
    }
}
