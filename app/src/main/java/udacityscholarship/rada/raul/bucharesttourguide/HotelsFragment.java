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
public class HotelsFragment extends Fragment {

    // String key used to put an extra int value of the Tab in MainActivity
    // in the Intent to start DetailsActivity
    private final String TAB_POSITION_STRING = "tab position";

    // String key used to put an extra int value of the clicked item position
    // in the Hotels fragment, in the Intent to start DetailsActivity
    private final String ITEM_POSITION_STRING = "item position";

    //position of the current tab plus 1
    private final int TAB_POSITION = 1;

    //list of Hotels
    static ArrayList<Attraction> hotels;

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        // create a list of {@link Hotel} objects
        hotels = generateHotels();

        // create a {@link LocationAdapter} whose data source is a list of {@link Hotel} objects. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), hotels);

        // find the ListView in attractions_list.xml
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // make listView use the {@link LocationAdapter} created above in order to display each
        // {@ link Hotel} object in the list.
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
     * Generates list of Hotels
     * @return ArrayList<Attraction> containing Hotel objects
     */
    public ArrayList<Attraction> generateHotels() {
        // constants showing the number of stars of each Hotel in the list
        final int MARRIOT_STARS = 5;
        final int MICHELANGELO_STARS = 3;
        final int RAMADA_STARS = 4;
        final int ATHENEE_STARS = 5;
        final int CROWNE_STARS = 4;
        final int RADISSON_STARS = 5;
        final int ANTIQUE_STARS = 2;
        final int CARPATI_STARS = 1;

        ArrayList<Attraction> hotels = new ArrayList<Attraction>();
        hotels.add(new Hotel(R.string.marriot_name, R.string.marriot_geo, R.string.marriot_address,
                MARRIOT_STARS, R.string.marriot_web, R.string.marriot_phone));
        hotels.add(new Hotel(R.string.michelangelo_name, R.string.michelangelo_geo, R.string.michelangelo_address,
                MICHELANGELO_STARS, R.string.michelangelo_web, R.string.michelangelo_phone));
        hotels.add(new Hotel(R.string.ramada_name, R.string.ramada_geo, R.string.ramada_address,
                RAMADA_STARS, R.string.ramada_web, R.string.ramada_phone));
        hotels.add(new Hotel(R.string.athenee_name, R.string.athenee_geo, R.string.athenee_address,
                ATHENEE_STARS, R.string.athenee_web, R.string.athenee_phone));
        hotels.add(new Hotel(R.string.crowne_name, R.string.crowne_geo, R.string.crowne_address,
                CROWNE_STARS, R.string.crowne_web, R.string.crowne_phone));
        hotels.add(new Hotel(R.string.radisson_name, R.string.radisson_geo, R.string.radisson_address,
                RADISSON_STARS, R.string.radisson_web, R.string.radisson_phone));
        hotels.add(new Hotel(R.string.antique_name, R.string.antique_geo, R.string.antique_address,
                ANTIQUE_STARS, R.string.antique_web, R.string.antique_phone));
        hotels.add(new Hotel(R.string.carpati_name, R.string.carpati_geo, R.string.carpati_address,
                CARPATI_STARS, R.string.carpati_web, R.string.carpati_phone));
        return hotels;
    }
}
