package com.idkteam.idk.adapter;

/**
 * Created by Danny on 20/08/2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.idkteam.idk.ui.TabFragment;
import com.idkteam.idk.ui.TabFragmentHistory;
import com.idkteam.idk.ui.TabFragmentMain;
import com.idkteam.idk.ui.TabFragmentSubscribed;

/**
 * Created by Danny
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    // Which Fragment should be displayed by the viewpager for the given position
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentHistory tab1 = new TabFragmentHistory();
                return tab1;
            case 1:
                TabFragmentMain tab2 = new TabFragmentMain();
                return tab2;
            case 2:
                TabFragmentSubscribed tab3 = new TabFragmentSubscribed();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
