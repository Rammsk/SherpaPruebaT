package com.example.sherpa.Presenter;

import android.content.Context;

import com.example.sherpa.Interactor.UniversityInteractor;
import com.example.sherpa.Interactor.UniversityInteractorImpl;
import com.example.sherpa.View.MainActivity;
import com.example.sherpa.Model.University;
import com.example.sherpa.View.UniversityView;

import java.util.List;

public class UniversityPresenterImpl implements UniversityPresenter{

    private Context context;
    private UniversityView view;
    private UniversityInteractor universityInteractor;

    public UniversityPresenterImpl(Context context){
        this.context = context;
        universityInteractor = new UniversityInteractorImpl(this,context);
    }

    @Override
    public void setView(MainActivity view) {
        this.view = view;
    }

    @Override
    public void getUniversities() {
        if (view != null){
            universityInteractor.getUniversityInformation();
        }
    }

    @Override
    public void setUniversities(List<University> universityList) {
        if (view != null){
            view.setUniversityList(universityList);
        }
    }
}
