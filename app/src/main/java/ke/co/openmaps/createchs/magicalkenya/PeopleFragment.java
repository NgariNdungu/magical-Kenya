package ke.co.openmaps.createchs.magicalkenya;


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

        // list of people
        ArrayList<Attraction> people = new ArrayList<>(Arrays.asList(
                new Attraction("El Molo", "Kenya's smallest tribe",
                        "Living by the shores of Lake Turkana, they have a unique lifestyle that is quickly dying out"),
                new Attraction("Maasai", null,
                        "Probably Africa's best known tribe, with a vibrant culture that has survived the ages"),
                new Attraction("Samburu", null,
                        "A close cousin to the Maasai found in Northern Kenya with a somewhat similar culture"),
                new Attraction("Swahili", null,
                        "A generalization of the coastal tribes. A welcoming people with a relaxed lifestyle"),
                new Attraction("Turkana", null,
                        "A pastoral community found around the shores of Lake Turkana little touched by urbanisation")
        ));
        peopleList.setAdapter(new AttractionsAdapter(getContext(), people));
        return rootView;
    }

}
