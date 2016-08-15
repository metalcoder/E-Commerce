package com.telpa.ecommerce.activities.ActivityB;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.fragment.FragmentB.FragmentBView;
import com.telpa.ecommerce.models.Category;
import com.telpa.ecommerce.utils.BaseActivity;
import com.telpa.ecommerce.utils.TabHelper;

import java.util.ArrayList;
import java.util.List;

public class ScreenB extends BaseActivity implements IScreenBView {
    IScreenBPresenter screenBPresenter;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_b);


        fcreateTitle("My Store" + " B");
        fcreateToolbar(this, false, true, true, R.id.toolbar);
        fcreateMenu(this, true);

        screenBPresenter = new ScreenBPresenterImpl(this, getApplication());
        screenBPresenter.getCategories();
    }

    @Override
    public void search() {

    }

    @Override
    public void goBasket() {

    }

    @Override
    public void fillFragments(ArrayList<Category> categories) {
        List<TabHelper> tabHelperList = new ArrayList<>();

        for (Category i : categories) {
            view = getLayoutInflater().inflate(R.layout.fragment_b_tab1, null);
            FragmentBView tab = new FragmentBView();
            tab.setView(view);
            tab.setCategory(i);
            tab.setTitle(i.getName());
            tab.setApplication(getApplication());
            tabHelperList.add(tab);
        }

        fcreateTabMenu(tabHelperList);

    }
}