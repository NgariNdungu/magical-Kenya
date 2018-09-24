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

import butterknife.BindView;
import butterknife.ButterKnife;
import ke.co.openmaps.createchs.magicalkenya.data.Attraction;

/**
 * Fragment to provide data on events
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
        Resources res = getResources();
        // list of events
        ArrayList<Attraction> events = new ArrayList<>(Arrays.asList(
                new Attraction(res.getStringArray(R.array.event_camel_derby)),
                new Attraction(res.getStringArray(R.array.event_lewa_marathon)),
                new Attraction(res.getStringArray(R.array.event_rhino_charge)),
                new Attraction(res.getStringArray(R.array.event_lamu_festival)),
                new Attraction(res.getStringArray(R.array.event_turkana_festival))
        ));
        eventsList.setAdapter(new AttractionsAdapter(getContext(),events));
        return rootView;

    }

}
