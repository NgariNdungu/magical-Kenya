package ke.co.openmaps.createchs.magicalkenya;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import ke.co.openmaps.createchs.magicalkenya.data.Attraction;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    @BindView(R.id.list)
    ListView eventsList;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.default_list, container,false);
        ButterKnife.bind(this, rootView);
        // list of events
        ArrayList<Attraction> events = new ArrayList<>(Arrays.asList(
                new Attraction("Camel Derby", null,
                        "Come race on camel back! Held in Maralal town every September"),
                new Attraction("Lewa Marathon", "Run in the wild",
                        "Race with the animals in the Lewa conservancy for a noble cause"),
                new Attraction("Rhino Charge", "Wildest 4x4 event",
                        "Tackle the toughest terrains to help save our rhinos"),
                new Attraction("Lamu Cultural Festival", null,
                        "Experience Lamu culture first-hand, catch the donkey races"),
                new Attraction("L. Turkana Festival", null,
                        "Experience colour and culture of the communities from Loyiangalani")
        ));
        eventsList.setAdapter(new AttractionsAdapter(getContext(),events));
        return rootView;

    }

}
