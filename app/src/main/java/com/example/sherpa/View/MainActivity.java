package com.example.sherpa.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sherpa.Model.University;
import com.example.sherpa.Model.UniversityAdapter;
import com.example.sherpa.Presenter.UniversityPresenter;
import com.example.sherpa.Presenter.UniversityPresenterImpl;
import com.example.sherpa.R;

import java.util.List;


public class MainActivity extends AppCompatActivity implements UniversityView {

    private RecyclerView rvUniversity;
    private UniversityAdapter universityAdapter;
    private UniversityPresenter universityPresenter;
    private List<University> universityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPresenter();
    }

    private void initView(){
        rvUniversity = (RecyclerView)findViewById(R.id.rvUniversity);
    }

    private void initPresenter(){
        universityPresenter = new UniversityPresenterImpl(getApplicationContext());
        universityPresenter.setView(this);
        universityPresenter.getUniversities();
    }
    @Override
    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvUniversity.setLayoutManager(linearLayoutManager);
        universityAdapter = new UniversityAdapter(universityList,getApplicationContext());
        rvUniversity.setAdapter(universityAdapter);
    }
}