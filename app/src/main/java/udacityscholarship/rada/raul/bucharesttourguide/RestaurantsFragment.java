package udacityscholarship.rada.raul.bucharesttourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    // String key used to put an extra int value of the Tab in MainActivity
    // in the Intent to start DetailsActivity
    private final String TAB_POSITION_STRING = "tab position";

    // String key used to put an extra int value of the clicked item position
    // in the Restaurants fragment, in the Intent to start DetailsActivity
    private final String ITEM_POSITION_STRING = "item position";

    //String key used to put extra int value (color id) in the Intent to start DetailsActivity
    private final String BACKGROUND_COLOR = "background color";

    //position of the current tab plus 1
    private final int TAB_POSITION = 2;

    //list of Restaurants
    static ArrayList<Attraction> restaurants;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        restaurants = generateRestaurants();

        // create a {@link LocationAdapter} whose data source is a list of {@link Museum} objects. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), restaurants, R.color.restaurantsColor);

        // find the ListView in attractions_list.xml
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // make listView use the {@link LocationAdapter} created above in order to display each
        // {@ link Museum} object in the list.
        listView.setAdapter(adapter);

        //List item click listener to start DetailsActivity
        // and present details about selected Restaurant
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent startDetails = new Intent(getContext(), DetailsActivity.class);
                startDetails.putExtra(TAB_POSITION_STRING, TAB_POSITION);
                startDetails.putExtra(ITEM_POSITION_STRING, position);
                startDetails.putExtra(BACKGROUND_COLOR, R.color.restaurantsColor);
                startActivity(startDetails);
            }
        });

        return rootView;
    }

    /**
     * Generates list of Restaurants
     * @return ArrayList<Attraction> containing Restaurant objects
     */
    private ArrayList<Attraction> generateRestaurants() {
        ArrayList<Attraction> restaurants = new ArrayList<Attraction>();
        restaurants.add(new Restaurant(R.string.caru_name, R.string.caru_opening, R.string.caru_geo,
                R.string.caru_address, R.string.caru_web, R.string.caru_phone,
                R.string.caru_type));
        restaurants.add(new Restaurant(R.string.curtea_name, R.string.curtea_opening, R.string.curtea_geo,
                R.string.curtea_address, R.string.curtea_web, R.string.curtea_phone,
                R.string.curtea_type));
        restaurants.add(new Restaurant(R.string.pescarus_name, R.string.pescarus_opening, R.string.pescarus_geo,
                R.string.pescarus_address, R.string.pescarus_web, R.string.pescarus_phone,
                R.string.pescarus_type));
        restaurants.add(new Restaurant(R.string.buon_name, R.string.buon_opening, R.string.buon_geo,
                R.string.buon_address, R.string.buon_web, R.string.buon_phone,
                R.string.buon_type));
        restaurants.add(new Restaurant(R.string.zen_name, R.string.zen_opening, R.string.zen_geo,
                R.string.zen_address, R.string.zen_web, R.string.zen_phone,
                R.string.zen_type));
        return restaurants;
    }

}
