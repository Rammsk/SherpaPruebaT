package com.example.sherpa.Retrofit;

import com.example.sherpa.Model.University;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UniversityService {

    @GET("/search")
    Call<List<University>> getUniversityInfo(@Query("country")String query);
}
