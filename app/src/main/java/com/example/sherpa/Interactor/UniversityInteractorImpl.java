package com.example.sherpa.Interactor;

import android.content.Context;

import com.example.sherpa.Model.University;
import com.example.sherpa.Presenter.UniversityPresenter;
import com.example.sherpa.Retrofit.RetrofitClient;
import com.example.sherpa.Retrofit.UniversityService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UniversityInteractorImpl implements UniversityInteractor{

    private UniversityPresenter universityPresenter;
    private Context context;
    private UniversityService universityService;

    public UniversityInteractorImpl(UniversityPresenter universityPresenter, Context context){
        this.universityPresenter  = universityPresenter;
        this.context = context;
        initRetrofit();
    }

    private void initRetrofit(){
        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        universityService = retrofit.create(UniversityService.class);
    }

    @Override
    public void getUniversityInformation() {
        Call<List<University>> call = universityService.getUniversityInfo("United States");
        call.enqueue(new Callback<List<University>>() {
            @Override
            public void onResponse(Call<List<University>> call, Response<List<University>> response) {
                List<University> universityList = response.body();
                universityPresenter.setUniversities(universityList);
            }
            @Override
            public void onFailure(Call<List<University>> call, Throwable t) {

            }
        });
    }
}
