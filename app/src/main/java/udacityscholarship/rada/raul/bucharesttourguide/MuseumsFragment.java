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
public class MuseumsFragment extends Fragment {

    //list of Museums
    static ArrayList<Attraction> museums;
    // String key used to put an extra int value of the Tab in MainActivity
    // in the Intent to start DetailsActivity
    private final String TAB_POSITION_STRING = "tab position";
    // String key used to put an extra int value of the clicked item position
    // in the Museum fragment, in the Intent to start DetailsActivity
    private final String ITEM_POSITION_STRING = "item position";
    //String key used to put extra int value (color id) in the Intent to start DetailsActivity
    private final String BACKGROUND_COLOR = "background color";
    //position of the current tab plus 1
    private final int TAB_POSITION = 3;

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        // create a list of {@link Museum} objects
        museums = generateMuseums();

        // create a {@link LocationAdapter} whose data source is a list of {@link Museum} objects. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), museums, R.color.museumsColor);

        // find the ListView in attractions_list.xml
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // make listView use the {@link LocationAdapter} created above in order to display each
        // {@ link Museum} object in the list.
        listView.setAdapter(adapter);

        //List item click listener to start DetailsActivity
        // and present details about selected Museum
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent startDetails = new Intent(getContext(), DetailsActivity.class);
                startDetails.putExtra(TAB_POSITION_STRING, TAB_POSITION);
                startDetails.putExtra(ITEM_POSITION_STRING, position);
                startDetails.putExtra(BACKGROUND_COLOR, R.color.museumsColor);
                startActivity(startDetails);
            }
        });

        return rootView;
    }

    /**
     * Generates list of Museums
     *
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
