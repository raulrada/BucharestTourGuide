package udacityscholarship.rada.raul.bucharesttourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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
     * Class of {@link ViewHolder} objects used to store each of the component views of list_item.xml
     * inside the tag field of the Layout, so you can immediately access them without
     * the need to look them up repeatedly
     */
    static class ViewHolder{
        private ImageView listImageView;
        private ImageView stars;
        private TextView nameTextView;
        private TextView typeTextView;
        private TextView openTextView;
    }

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

        // create {@link ViewHolder} object storing each of the component views of list_item.xml
        ViewHolder holder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            // find relevant objects in the list item layout to be populated with info about
            // {@link Attraction} and store them in the {@link holder} object
            holder = new ViewHolder();
            holder.listImageView = (ImageView) convertView.findViewById(R.id.list_pic);
            holder.nameTextView = (TextView) convertView.findViewById(R.id.list_title);
            holder.stars = (ImageView) convertView.findViewById(R.id.stars);
            holder.typeTextView = (TextView) convertView.findViewById(R.id.type);
            holder.openTextView = (TextView) convertView.findViewById(R.id.open);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        // get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        /* if a small pic is available, show it in the list, otherwise set the visibility of the
        small pic in the list to GONE, so as not to take up any space */
        if (currentAttraction.hasSmallImage()) {
            holder.listImageView.setVisibility(View.VISIBLE);
            holder.listImageView.setImageResource(currentAttraction.getSmallPicId());
        }
        else
            holder.listImageView.setVisibility(View.GONE);

        //set the name of the attraction in the corresponding TextView
        holder.nameTextView.setText(currentAttraction.getNameId());

        /* if an {@link Attraction} type is available, show it in the list, otherwise set the
        visibility of the relevant TextView to GONE, so as not to take up any space */
        if(currentAttraction.hasType()){
            holder.typeTextView.setText(mContext.getString(R.string.type_list,
                    mContext.getResources().getString(currentAttraction.getTypeId())));
            holder.typeTextView.setVisibility(View.VISIBLE);
        }
        else
            holder.typeTextView.setVisibility(View.GONE);

        //show opening hours in relevant TextView
        holder.openTextView.setText(mContext.getString(R.string.open_list,
                mContext.getResources().getString(currentAttraction.getOpeningHoursId())));

        /* if {@link Attraction} is classified by number of stars, show the LinearLayout
        containing star images, otherwise set the visibility of the entire LinearLayout to GONE */
        if (currentAttraction.hasStars()) {
            Log.v("raul_adapter", "has stars " + mContext.getResources().getString(currentAttraction.getNameId()));
            holder.stars.setVisibility(View.VISIBLE);
            switch (currentAttraction.getStarsNumber()) {
                case 1:
                    holder.stars.setImageResource(R.drawable.star1_vector);
                    break;
                case 2:
                    holder.stars.setImageResource(R.drawable.star2_vector);
                    break;
                case 3:
                    holder.stars.setImageResource(R.drawable.star3_vector);
                    break;
                case 4:
                    holder.stars.setImageResource(R.drawable.star4_vector);
                    break;
                case 5:
                    holder.stars.setImageResource(R.drawable.star5_vector);
                    break;
            }
        }
        else
            holder.stars.setVisibility(View.GONE);

        return convertView;
    }
}

