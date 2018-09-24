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
 * Fragment to provide data on people
 */
public class PeopleFragment extends Fragment {

    @BindView(R.id.list)
    ListView peopleList;

    public PeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.default_list, container, false);
        ButterKnife.bind(this, rootView);
        Resources res = getResources();

        // list of people
        ArrayList<Attraction> people = new ArrayList<>(Arrays.asList(
                new Attraction(res.getStringArray(R.array.people_el_molo)),
                new Attraction(res.getStringArray(R.array.people_maasai)),
                new Attraction(res.getStringArray(R.array.people_samburu)),
                new Attraction(res.getStringArray(R.array.people_swahili)),
                new Attraction(res.getStringArray(R.array.people_turkana))
        ));
        peopleList.setAdapter(new AttractionsAdapter(getContext(), people));
        return rootView;
    }

}
