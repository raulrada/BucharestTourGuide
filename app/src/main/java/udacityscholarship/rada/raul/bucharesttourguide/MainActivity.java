package udacityscholarship.rada.raul.bucharesttourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager.
        tabLayout.setupWithViewPager(viewPager);

        //if user returns to MainActivity from DetailsActivity, go back to previously selected Tab
        //position 0 is reserved for reflecting the fact that there is no position to get from
        //an Intent. All tab positions are off-set by 1 in the sequence below
        if (getIntent().getIntExtra(TAB_POSITION_STRING, 0) != 0){
            int tabPosition = getIntent().getIntExtra(TAB_POSITION_STRING, 0);
            //eliminate the tab possition off-setting by 1
            viewPager.setCurrentItem(tabPosition-1);
        }

    }
}
