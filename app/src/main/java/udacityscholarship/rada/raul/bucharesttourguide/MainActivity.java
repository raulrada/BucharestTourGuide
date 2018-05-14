package udacityscholarship.rada.raul.bucharesttourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // String key used to get the int value of the Tab in MainActivity
    // from the Intent in DetailsActivity
    private final String TAB_POSITION_STRING = "tab position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        AttractionAdapter adapter = new AttractionAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager.
        tabLayout.setupWithViewPager(viewPager);

        //if user returns to MainActivity from DetailsActivity, go back to previously selected Tab
        //position 0 is reserved for reflecting the fact that there is no position to get from
        //an Intent. All tab positions are off-set by 1 in the sequence below
        if (getIntent().getIntExtra(TAB_POSITION_STRING, 0) != 0) {
            int tabPosition = getIntent().getIntExtra(TAB_POSITION_STRING, 0);
            //eliminate the tab possition off-setting by 1
            viewPager.setCurrentItem(tabPosition - 1);
        }

        //set background color of the tabs based on the background color in the displayed Fragment
        //and set the corresponding title in the ActionBar
        switch (tabLayout.getSelectedTabPosition()) {
            case 0:
                tabLayout.setBackgroundColor(getResources().getColor(R.color.hotelsColor));
                getSupportActionBar().setTitle(getString(R.string.bucharest,
                        getString(R.string.hotels)));
                break;
            case 1:
                tabLayout.setBackgroundColor(getResources().getColor(R.color.restaurantsColor));
                getSupportActionBar().setTitle(getString(R.string.bucharest,
                        getString(R.string.restaurants)));
                break;
            case 2:
                tabLayout.setBackgroundColor(getResources().getColor(R.color.museumsColor));
                getSupportActionBar().setTitle(getString(R.string.bucharest,
                        getString(R.string.museums)));
                break;
            case 3:
                tabLayout.setBackgroundColor(getResources().getColor(R.color.parksColor));
                getSupportActionBar().setTitle(getString(R.string.bucharest,
                        getString(R.string.parks)));
                break;
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            /**
             * change the background color of the tabs based on the background color
             * in the displayed Fragment and the title in the ActionBar
             */
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tabLayout.getSelectedTabPosition()) {
                    case 0:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.hotelsColor));
                        getSupportActionBar().setTitle(getString(R.string.bucharest,
                                getString(R.string.hotels)));
                        break;
                    case 1:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.restaurantsColor));
                        getSupportActionBar().setTitle(getString(R.string.bucharest,
                                getString(R.string.restaurants)));
                        break;
                    case 2:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.museumsColor));
                        getSupportActionBar().setTitle(getString(R.string.bucharest,
                                getString(R.string.museums)));
                        break;
                    case 3:
                        tabLayout.setBackgroundColor(getResources().getColor(R.color.parksColor));
                        getSupportActionBar().setTitle(getString(R.string.bucharest,
                                getString(R.string.parks)));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //auto-generated empty stub
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //auto-generated empty stub
            }
        });
    }
}
