package udacityscholarship.rada.raul.bucharesttourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AttractionAdapter extends FragmentPagerAdapter {

    public AttractionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) return new HotelsFragment();
        else if (position == 1) return new RestaurantsFragment();
        else if (position == 2) return new MuseumsFragment();
        else return new ParksFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
