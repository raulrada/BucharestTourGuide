package udacityscholarship.rada.raul.bucharesttourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link LocationAdapter} is an {@link ArrayAdapter} that will provide the layout for each element
 * in a list of {@link Attraction} objects
 */
public class LocationAdapter extends ArrayAdapter<Attraction> {

    private Context mContext;

    /**
     * Constructor of {@link LocationAdapter} objects
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param attractions is the list of {@link Attraction} objects to be displayed in the list.
     */
    public LocationAdapter(Context context, ArrayList<Attraction> attractions){
        super(context,0,attractions);
        mContext = context;
    }

    /**
     * Provides a View for a ListView
     * @param position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the ListView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //find relevant objects in the list item layout to be populated with info about {@link Attraction}
        ImageView listImageView = (ImageView) convertView.findViewById(R.id.list_pic);
        ImageView[] stars = new ImageView[]{convertView.findViewById(R.id.star0),
                convertView.findViewById(R.id.star1), convertView.findViewById(R.id.star2),
                convertView.findViewById(R.id.star3), convertView.findViewById(R.id.star4)};
        TextView nameTextView = (TextView) convertView.findViewById(R.id.list_title);
        TextView typeTextView = (TextView) convertView.findViewById(R.id.type);
        TextView openTextView = (TextView) convertView.findViewById(R.id.open);
        LinearLayout starsLinearLayout = (LinearLayout) convertView.findViewById(R.id.stars_layout);

        // get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        /* if a small pic is available, show it in the list, otherwise set the visibility of the
        small pic in the list to GONE, so as not to take up any space */
        if (currentAttraction.hasSmallImage()) {
            listImageView.setVisibility(View.VISIBLE);
            listImageView.setImageResource(currentAttraction.getSmallPicId());
        }
        else
            listImageView.setVisibility(View.GONE);

        //set the name of the attraction in the corresponding TextView
        nameTextView.setText(currentAttraction.getNameId());

        /* if an {@link Attraction} type is available, show it in the list, otherwise set the
        visibility of the relevant TextView to GONE, so as not to take up any space */
        if(currentAttraction.hasType()){
            typeTextView.setText(mContext.getString(R.string.type_list,
                    mContext.getResources().getString(currentAttraction.getTypeId())));
            typeTextView.setVisibility(View.VISIBLE);
        }
        else
            typeTextView.setVisibility(View.GONE);

        //show opening hours in relevant TextView
        openTextView.setText(mContext.getString(R.string.open_list,
                mContext.getResources().getString(currentAttraction.getOpeningHoursId())));

        /* if {@link Attraction} is classified by number of stars, show the LinearLayout
        containing star images, otherwise set the visibility of the entire LinearLayout to GONE */
        if (currentAttraction.hasStars()){
            starsLinearLayout.setVisibility(View.VISIBLE);

            // show a relevant number of stars
            for (int i = 0; i<currentAttraction.getStarsNumber(); i++)
                stars[i].setVisibility(View.VISIBLE);

            // eliminate the extra number of stars
            if(currentAttraction.getStarsNumber() < stars.length)
                for (int i = currentAttraction.getStarsNumber(); i < stars.length; i++)
                    stars[i].setVisibility(View.GONE);
        }

        return convertView;
    }
}
