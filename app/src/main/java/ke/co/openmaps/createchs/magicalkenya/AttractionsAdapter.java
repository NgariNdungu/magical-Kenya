package ke.co.openmaps.createchs.magicalkenya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ke.co.openmaps.createchs.magicalkenya.data.Attraction;

public class AttractionsAdapter extends ArrayAdapter<Attraction> {
    @BindView(R.id.attraction_name)
    TextView nameTView;
    @BindView(R.id.attraction_tag)
    TextView tagTView;
    @BindView(R.id.attraction_desc)
    TextView descTView;
    @BindView(R.id.attraction_image)
    ImageView imageView;

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
        ButterKnife.bind(this, convertView);
        // set view content
        nameTView.setText(currentAttraction.getName());
        descTView.setText(currentAttraction.getDescription());

        if (currentAttraction.getImage() != 0) {
            imageView.setImageResource(currentAttraction.getImage());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        if (currentAttraction.getTag() != null) {
            tagTView.setText(currentAttraction.getTag());
            tagTView.setVisibility(View.VISIBLE);
        } else {
            tagTView.setVisibility(View.GONE);
        }
        return convertView;
    }
}
