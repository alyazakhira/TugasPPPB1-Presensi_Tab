package com.example.presensi_manual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity  {
    TabLayoutMediator mediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getLayoutID
        ViewPager2 viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

//        set adapter for frag
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(adapter);

//        mediator
        String[] tab_array = new String[]{"Masuk", "Daftar"};
        mediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(tab_array[position]));
        mediator.attach();

    }
}