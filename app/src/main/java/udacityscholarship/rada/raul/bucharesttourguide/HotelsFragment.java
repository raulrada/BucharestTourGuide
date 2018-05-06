package udacityscholarship.rada.raul.bucharesttourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    // constants showing the number of stars of each Hotel in the list
    private final int MARRIOT_STARS = 5;
    private final int MICHELANGELO_STARS = 3;
    private final int RAMADA_STARS = 4;

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        final ArrayList<Attraction> hotels = generateHotels();

        // create a {@link LocationAdapter} whose data source is a list of {@link Hotel} objects. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), hotels);

        // find the ListView in attractions_list.xml
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // make listView use the {@link LocationAdapter} created above in order to display each
        // {@ link Hotel} object in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

    /**
     * Generates list of Hotels
     * @return ArrayList<Attraction> containing Hotel objects
     */
    public ArrayList<Attraction> generateHotels() {
        ArrayList<Attraction> hotels = new ArrayList<Attraction>();
        hotels.add(new Hotel(R.string.marriot_name, R.string.marriot_geo, R.string.marriot_address,
                MARRIOT_STARS, R.string.marriot_web, R.string.marriot_phone));
        hotels.add(new Hotel(R.string.michelangelo_name, R.string.michelangelo_geo, R.string.michelangelo_address,
                MICHELANGELO_STARS, R.string.michelangelo_web, R.string.michelangelo_phone));
        hotels.add(new Hotel(R.string.ramada_name, R.string.ramada_geo, R.string.ramada_address,
                RAMADA_STARS, R.string.ramada_web, R.string.ramada_phone));
        return hotels;
    }
}
