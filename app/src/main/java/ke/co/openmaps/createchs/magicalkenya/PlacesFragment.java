package ke.co.openmaps.createchs.magicalkenya;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import ke.co.openmaps.createchs.magicalkenya.data.Attraction;

/**
 * Fragment to provide data for places
 */
public class PlacesFragment extends Fragment {


    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Resources res = getResources();
        // create list of places
        ArrayList<Attraction> places = new ArrayList<>(Arrays.asList(
                new Attraction(res.getStringArray(R.array.place_loiyangalani),
                        R.drawable.loiyangalani),
                new Attraction(res.getStringArray(R.array.place_maralal),
                        R.drawable.maralal),
                new Attraction(res.getStringArray(R.array.place_south_horr),
                        R.drawable.south_horr),
                new Attraction(res.getStringArray(R.array.place_sibiloi),
                        R.drawable.sibiloi),
                new Attraction(res.getStringArray(R.array.place_turkana),
                        R.drawable.turkana)
        ));

        View rootView = inflater.inflate(R.layout.default_list, container, false);
        ListView list = (ListView) rootView.findViewById(R.id.list);
        // set adapter on the listview
        list.setAdapter(new AttractionsAdapter(getContext(), places));
        return rootView;
    }

}
