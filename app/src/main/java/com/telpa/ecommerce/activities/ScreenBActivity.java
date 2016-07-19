package com.telpa.ecommerce.activities;

import android.os.Bundle;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.utils.BaseActivity;
import com.telpa.ecommerce.ui.TabHelper;
import com.telpa.ecommerce.fragment.FragmentBTab;

import java.util.ArrayList;
import java.util.List;


public class ScreenBActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_b);

        fcreateTitle("My Store");
        fcreateToolbar(this, true, true,R.id.toolbar);
        fcreateMenu(this, true);

        List<TabHelper> tabHelperList = new ArrayList<>();
        tabHelperList.add(FragmentBTab.createTab("Category A"));
        tabHelperList.add(FragmentBTab.createTab("Category B"));
        tabHelperList.add(FragmentBTab.createTab("Category C"));


        fcreateTabMenu(tabHelperList);
    }
}