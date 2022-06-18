package com.example.sherpa.Presenter;

import com.example.sherpa.View.MainActivity;
import com.example.sherpa.Model.University;

import java.util.List;

public interface UniversityPresenter {

    void setView(MainActivity view);
    void getUniversities();
    void setUniversities(List<University> universityList);
}
