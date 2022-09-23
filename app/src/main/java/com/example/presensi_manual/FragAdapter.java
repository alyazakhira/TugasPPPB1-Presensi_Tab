package com.example.presensi_manual;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragAdapter extends FragmentStateAdapter {

//    constructor
    public FragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            LoginFrag fragment1 = new LoginFrag();
            return fragment1;
        }
        else {
            SignupFrag fragment2 = new SignupFrag();
            return fragment2;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
