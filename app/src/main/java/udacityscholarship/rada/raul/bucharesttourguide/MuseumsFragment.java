package udacityscholarship.rada.raul.bucharesttourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        final ArrayList<Attraction> museums = generateMuseums();

        // create a {@link LocationAdapter} whose data source is a list of {@link Museum} objects. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), museums);

        // find the ListView in attractions_list.xml
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // make listView use the {@link LocationAdapter} created above in order to display each
        // {@ link Museum} object in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

    /**
     * Generates list of Museums
     * @return ArrayList<Attraction> containing Museum objects
     */
    private ArrayList<Attraction> generateMuseums() {
        ArrayList<Attraction> museums = new ArrayList<Attraction>();
        museums.add(new Museum(R.string.antipa_name, R.string.antipa_opening, R.string.antipa_geo,
                R.string.antipa_address, R.string.antipa_web, R.string.antipa_phone,
                R.string.antipa_type));
        museums.add(new Museum(R.string.history_name, R.string.history_opening, R.string.history_geo,
                R.string.history_address, R.string.history_web, R.string.history_phone,
                R.string.history_type));
        museums.add(new Museum(R.string.art_name, R.string.art_opening, R.string.art_geo,
                R.string.art_address, R.string.art_web, R.string.art_phone,
                R.string.art_type));
        museums.add(new Museum(R.string.sat_name, R.string.sat_opening, R.string.sat_geo,
                R.string.sat_address, R.string.sat_web, R.string.sat_phone,
                R.string.sat_type));
        museums.add(new Museum(R.string.taran_name, R.string.taran_opening, R.string.taran_geo,
                R.string.taran_address, R.string.taran_web, R.string.taran_phone,
                R.string.taran_type));
        return museums;
    }
}
