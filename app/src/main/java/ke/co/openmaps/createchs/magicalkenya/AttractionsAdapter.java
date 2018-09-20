package ke.co.openmaps.createchs.magicalkenya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ke.co.openmaps.createchs.magicalkenya.data.Attraction;

public class AttractionsAdapter extends ArrayAdapter<Attraction> {
    public AttractionsAdapter(@NonNull Context context, @NonNull ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_list_item, parent, false
            );
        }
        Attraction currentAttraction = getItem(position);
        TextView nameTView = (TextView) convertView.findViewById(R.id.attraction_name);
        TextView descTView = (TextView) convertView.findViewById(R.id.attraction_desc);

        nameTView.setText(currentAttraction.getName());
        descTView.setText(currentAttraction.getDescription());
        return convertView;
    }
}
