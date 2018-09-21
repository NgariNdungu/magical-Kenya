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
public class SitesFragment extends Fragment {

    @BindView(R.id.list)
    ListView sitesList;

    public SitesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.default_list, container,false);
        ButterKnife.bind(this, rootView);
        // list of sites
        ArrayList<Attraction> sites = new ArrayList<>(Arrays.asList(
                new Attraction("Fort Jesus", null,
                        "Standing high over the Mombasa harbor, this museum is steeped in history"),
                new Attraction("Giraffe Center", null,
                        "Come feed the giraffes just outside Nairobi"),
                new Attraction("Ol Pejeta Chimpanzee Sanctuary", null,
                        "Home to rescued chimps from central and east Africa"),
                new Attraction("Lamu Old Town", null,
                        "A UNESCO World Heritage Site, a place with a unique culture and endearing atmosphere"),
                new Attraction("Mt. Kenya National Park", null,
                        "Mt. Kenya is Africa's second highest peak. A trek to point Lenana offers breathtaking views")
        ));
        sitesList.setAdapter(new AttractionsAdapter(getContext(), sites));
        return rootView;
    }

}
