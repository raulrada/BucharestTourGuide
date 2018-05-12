package udacityscholarship.rada.raul.bucharesttourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    // String key used to get the int value of the Tab in MainActivity
    // from the Intent to start DetailsActivity
    private final String TAB_POSITION_STRING = "tab position";

    // String key used to get the int value of the clicked item position
    // in the fragment launching DetailsActivity, from the related Intent
    private final String ITEM_POSITION_STRING = "item position";

    //String key used to get value of color id from the Intent used to start DetailsActivity
    private final String BACKGROUND_COLOR = "background color";

    //position of the current tab in MainActivity
    private int tabPosition;

    //position of selected item in the relevant list of Attractions
    private int position;

    //ID of color to be set to the background of activity_details.xml
    private int colorId;

    //Back button in activity_details.xml
    private Button button;

    //variables referencing different Views in activity_details.xml
    private ImageView attractionImage;
    private ImageView directionsImage;
    private ImageView starsImage;
    private TextView attractionNameTextView;
    private TextView attractionTypeTextView;

    //ScrollView in activity_details.xml showing details about the selected Attraction
    private ScrollView attractionScroll;

    //the Attraction about which information should be displayed
    private Attraction currentAttraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setup();

        button.setOnClickListener(new View.OnClickListener() {
            /**
             * go back to MainActivity, letting MainActivity know which Fragment it should show
             * immediately after it starts (based on value of tabPosition)
             */
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(DetailsActivity.this, MainActivity.class);
                startMain.putExtra(TAB_POSITION_STRING, tabPosition);
                startActivity(startMain);
                finish();
            }
        });

        directionsImage.setOnClickListener(new View.OnClickListener() {
            /**
             * Launch map app, if available, in order to show the location of the Attraction
             */
            @Override
            public void onClick(View v) {
                Intent showOnMapIntent = new Intent(Intent.ACTION_VIEW);
                showOnMapIntent.setData(Uri.parse(DetailsActivity.this.getString(currentAttraction.getGeoId())));
                if (showOnMapIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(showOnMapIntent);
            }
        });
    }

    /**
     * Perform various utility tasks for the current Activity (such as finding relevant Views in
     * activity_details.xml, initializing selected variables and displaying on the screen relevant
     * information about the selected Attraction).
     */
    private void setup(){
        button = (Button) findViewById(R.id.back_button);
        attractionImage = (ImageView) findViewById(R.id.attraction_image);
        directionsImage = (ImageView) findViewById(R.id.directions_image);
        starsImage = (ImageView) findViewById(R.id.stars_image_details);
        attractionNameTextView = (TextView) findViewById(R.id.attraction_name_text_view);
        attractionTypeTextView = (TextView) findViewById(R.id.attraction_type_text_view);
        attractionScroll = (ScrollView) findViewById(R.id.attraction_scroll);

        tabPosition = getIntent().getIntExtra(TAB_POSITION_STRING, 1);
        position = getIntent().getIntExtra(ITEM_POSITION_STRING,0);
        colorId = getIntent().getIntExtra(BACKGROUND_COLOR, 0);

        displayAttraction();
    }

    /**
     * Display information about the selected Attraction, based on the type of Attraction
     */
    private void displayAttraction() {

        //set the background color for activity_details.xml depending on Attraction type
        View rootView = findViewById(R.id.root_view);
        rootView.setBackgroundColor(getResources().getColor(colorId));

        //identify the Attraction about which details will be shown
        getAttraction();

        //display the image of the Attraction. Change ScaleType for the image of any Attractions
        //other than a Park
        attractionImage.setImageResource(currentAttraction.getLargePicId());
        if (tabPosition != 4) {
            attractionImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            //for Attractions other than Museums and Parks, insert additional margin at the
            // top of their large image
            if (tabPosition != 3) {
                ViewGroup.MarginLayoutParams params =
                        (ViewGroup.MarginLayoutParams) attractionImage.getLayoutParams();
                params.topMargin = getResources().getDimensionPixelSize(R.dimen.large_image_margin_top_non_standard);
            }
        }

        //display the name of the Attraction
        attractionNameTextView.setText(getString(currentAttraction.getNameId()));

        //display the type of the Attraction, if info is available. Otherwise remove corresponding
        //TextView from screen
        if (currentAttraction.hasType()){
            attractionTypeTextView.setVisibility(View.VISIBLE);
            attractionTypeTextView.setText(getString(currentAttraction.getTypeId()));
        }
        else
            attractionTypeTextView.setVisibility(View.GONE);

        //display the number of stars of the Attraction, if case. Otherwise remove corresponding
        //ImageView from screen
        if (currentAttraction.hasStars()){
            starsImage.setVisibility(View.VISIBLE);
            switch (currentAttraction.getStarsNumber()){
                case 1: starsImage.setImageResource(R.drawable.star1_vector);
                        break;
                case 2: starsImage.setImageResource(R.drawable.star2_vector);
                        break;
                case 3: starsImage.setImageResource(R.drawable.star3_vector);
                        break;
                case 4: starsImage.setImageResource(R.drawable.star4_vector);
                        break;
                case 5: starsImage.setImageResource(R.drawable.star5_vector);
                        break;
            }
        }
        else
            starsImage.setVisibility(View.GONE);

    }

    /**
     * get currentAttraction to be presented in more detail, from the relevant fragment, which
     * contains the list whose item was clicked by the user (based on value of tabPosition)
     */
    private void getAttraction() {
        switch (tabPosition){
            case 1: currentAttraction = HotelsFragment.hotels.get(position);
                break;
            case 2: currentAttraction = RestaurantsFragment.restaurants.get(position);
                break;
            case 3: currentAttraction = MuseumsFragment.museums.get(position);
                break;
            case 4: currentAttraction = ParksFragment.parks.get(position);
                break;
        }
    }
}
