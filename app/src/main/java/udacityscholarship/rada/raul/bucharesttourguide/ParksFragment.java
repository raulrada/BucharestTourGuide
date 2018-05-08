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
public class ParksFragment extends Fragment {

    // String key used to put an extra int value of the Tab in MainActivity
    // in the Intent to start DetailsActivity
    private final String TAB_POSITION_STRING = "tab position";

    // String key used to put an extra int value of the clicked item position
    // in the Park fragment, in the Intent to start DetailsActivity
    private final String ITEM_POSITION_STRING = "item position";

    //position of the current tab plus 1
    private final int TAB_POSITION = 4;

    //list of Parks
    static ArrayList<Attraction> parks;

    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        // create a list of {@link Park} objects
        parks = generateParks();

        // create a {@link LocationAdapter} whose data source is a list of {@link Park} objects. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), parks);

        // find the ListView in attractions_list.xml
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // make listView use the {@link LocationAdapter} created above in order to display each
        // {@ link Park} object in the list.
        listView.setAdapter(adapter);

        //List item click listener to start DetailsActivity
        // and present details about selected Park
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent startDetails = new Intent(getContext(), DetailsActivity.class);
                startDetails.putExtra(TAB_POSITION_STRING, TAB_POSITION);
                startDetails.putExtra(ITEM_POSITION_STRING, position);
                startActivity(startDetails);
            }
        });

        return rootView;
    }

    /**
     * Generates list of Parks
     * @return ArrayList<Attraction> containing Park objects
     */
    public ArrayList<Attraction> generateParks(){
        ArrayList<Attraction> parks = new ArrayList<Attraction>();
        parks.add(new Park(R.string.ior_name, R.string.ior_opening, R.drawable.ior_big,
                R.string.ior_geo, R.drawable.ior_small, R.string.ior_size, R.string.ior_since));
        parks.add(new Park(R.string.botanic_name, R.string.botanic_opening, R.drawable.botanica_big,
                R.string.botanic_geo, R.drawable.botanica_small,R.string.botanic_size,R.string.botanic_since));
        parks.add(new Park(R.string.carol_name, R.string.carol_opening, R.drawable.carol_big,
                R.string.carol_geo, R.drawable.carol_small,R.string.carol_size,R.string.carol_since));
        parks.add(new Park(R.string.cismigiu_name, R.string.cismigiu_opening, R.drawable.cismigiu_big,
                R.string.cismigiu_geo, R.drawable.cismigiu_small,R.string.cismigiu_size,R.string.cismigiu_since));
        parks.add(new Park(R.string.izvor_name, R.string.izvor_opening, R.drawable.izvor_big,
                R.string.izvor_geo, R.drawable.izvor_small,R.string.izvor_size,R.string.izvor_since));
        parks.add(new Park(R.string.herastrau_name, R.string.herastrau_opening, R.drawable.herastrau_big,
                R.string.herastrau_geo, R.drawable.herastrau_small,R.string.herastrau_size,R.string.herastrau_since));
        parks.add(new Park(R.string.tineretului_name, R.string.tineretului_opening, R.drawable.tineretului_big,
                R.string.tineretului_geo, R.drawable.tineretului_small,R.string.tineretului_size,R.string.tineretului_since));
        parks.add(new Park(R.string.vacaresti_name, R.string.vacaresti_opening, R.drawable.vacaresti_big,
                R.string.vacaresti_geo, R.drawable.vacaresti_small,R.string.vacaresti_size,R.string.vacaresti_since));
        return parks;
    }
}
