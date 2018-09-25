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

    public static class ViewHolder {
        TextView name;
        TextView tag;
        TextView description;
        ImageView image;
    }

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
            ViewHolder viewHolder = new ViewHolder();
            ButterKnife.bind(this, convertView);
            viewHolder.name = nameTView;
            viewHolder.tag = tagTView;
            viewHolder.description = descTView;
            viewHolder.image = imageView;
            convertView.setTag(viewHolder);
        }

        // get attraction at current position
        Attraction currentAttraction = getItem(position);
        // get the view holder
        ViewHolder holder = (ViewHolder) convertView.getTag();
        // set view content
        holder.name.setText(currentAttraction.getName());
        holder.description.setText(currentAttraction.getDescription());

        // set the attraction image if available else remove ImageView from item
        if (currentAttraction.getImage() != 0) {
            holder.image.setImageResource(currentAttraction.getImage());
            holder.image.setVisibility(View.VISIBLE);
        } else {
            holder.image.setVisibility(View.GONE);
        }

        // set the tag text if available else remove the tag TextView from item
        if (!currentAttraction.getTag().isEmpty()) {
            holder.tag.setText(currentAttraction.getTag());
            holder.tag.setVisibility(View.VISIBLE);
        } else {
            holder.tag.setVisibility(View.GONE);
        }
        return convertView;
    }
}
