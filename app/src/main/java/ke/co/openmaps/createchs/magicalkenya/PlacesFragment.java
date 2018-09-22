package ke.co.openmaps.createchs.magicalkenya;


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
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {


    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // create list of places
        ArrayList<Attraction> places = new ArrayList<>(Arrays.asList(
                new Attraction("Loiyangalani", null,
                   "Explore the lake, go mountain climbing or dance with the people",
                        R.drawable.loiyangalani),
                new Attraction("Maralal", null,
                        "Home to the world famous camel race. The gateway to Northern Kenya",
                        R.drawable.maralal),
                new Attraction("South Horr", null,
                        "Nestled between two hills, the village offers some spectacular views",
                        R.drawable.south_horr),
                new Attraction("Sibiloi National Park", null,
                        "Recently accorded World Heritage status, there's plenty to see.",
                        R.drawable.sibiloi),
                new Attraction("Turkana", "The cradle of mankind",
                        "This place is remote, and beautiful and the journey even more so.",
                        R.drawable.turkana)
        ));
        // set list as arrayadapter data source
        // set adapter on the listview
        View rootView = inflater.inflate(R.layout.default_list, container,false);
        ListView list = (ListView) rootView.findViewById(R.id.list);
        list.setAdapter(new AttractionsAdapter(getContext(),places));
        return rootView;
    }

}
