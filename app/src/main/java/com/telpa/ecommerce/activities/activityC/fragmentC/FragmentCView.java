package com.telpa.ecommerce.activities.activityC.fragmentC;


import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.telpa.ecommerce.R;
import com.telpa.ecommerce.activities.activityF.ScreenF;
import com.telpa.ecommerce.adapters.RecyclerAdapter;
import com.telpa.ecommerce.adapters.RecyclerAdapter_ABCG;
import com.telpa.ecommerce.models.Category;
import com.telpa.ecommerce.utils.TabHelper;

import java.util.ArrayList;

/**
 * Created by Gizem İlgar on 15.8.2016.
 */

public class FragmentCView extends TabHelper implements IFragmentCView {
    private IFragmentCPresenter fragmentCPresenter;
    private View view;
    private Category category;
    private Application application;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.application = getApplication();
        this.view = getView();
        this.category = getCategory();
        setTitle("Test");

        fragmentCPresenter = new FragmentCPresenter(this, application);
        fragmentCPresenter.loadView(category);
        fragmentCPresenter.getSubCategories(view);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view;
    }

    @Override
    public void viewAll() {
        view.findViewById(R.id.viewallTop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ScreenF.class);
                startActivity(i);
            }
        });
    }



    @Override
    public void setOtherSubCategories(ArrayList<Category> subCategories) {

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewC);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager recyclerLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.addItemDecoration(new RecyclerAdapter.SpaceItemDecoration(0));
        RecyclerAdapter_ABCG recyclerAdapter = new RecyclerAdapter_ABCG(getActivity(), subCategories.size(), R.layout.item_abcg, subCategories, "c",getApplication());
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void goToProduct(int ProductID) {

    }

    @Override
    public void RatingBar(int ProductID) {

    }

}
