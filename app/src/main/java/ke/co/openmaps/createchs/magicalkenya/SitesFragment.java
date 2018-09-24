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
 * Fragment to provide data on sites
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
        View rootView = inflater.inflate(R.layout.default_list, container, false);
        ButterKnife.bind(this, rootView);
        Resources res = getResources();

        // list of sites
        ArrayList<Attraction> sites = new ArrayList<>(Arrays.asList(
                new Attraction(res.getStringArray(R.array.site_fortjesus)),
                new Attraction(res.getStringArray(R.array.site_giraffe_center)),
                new Attraction(res.getStringArray(R.array.site_ol_pejeta)),
                new Attraction(res.getStringArray(R.array.site_lamu)),
                new Attraction(res.getStringArray(R.array.site_mt_kenya))
        ));
        sitesList.setAdapter(new AttractionsAdapter(getContext(), sites));
        return rootView;
    }

}
