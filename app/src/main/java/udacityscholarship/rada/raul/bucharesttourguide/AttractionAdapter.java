package udacityscholarship.rada.raul.bucharesttourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AttractionAdapter extends FragmentPagerAdapter {

    // context of the app
    private Context mContext;

    /**
     * Create a new AttractionAdapter object
     *
     * @param context of the app
     * @param fm      fragment manager that will keep each fragment's state in the adapter across swipes
     */
    public AttractionAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
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

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) return mContext.getString(R.string.hotels);
        else if (position == 1) return mContext.getString(R.string.restaurants);
        else if (position == 2) return mContext.getString(R.string.museums);
        else return mContext.getString(R.string.parks);
    }
}
