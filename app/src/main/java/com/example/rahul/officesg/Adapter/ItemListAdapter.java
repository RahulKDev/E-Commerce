package com.example.rahul.officesg.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rahul.officesg.R;
import com.example.rahul.officesg.model.Item;

import java.util.List;

/**
 * Created by Manish on 2/13/2016.
 */
public class ItemListAdapter extends ArrayAdapter<Item> {
    private final Context context;
    private final List<Item> items;

    public ItemListAdapter(Context context, List<Item> items) {
        super(context, R.layout.item_list, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Item currentItem = items.get(position);
        View rowView = inflater.inflate(R.layout.item_list, parent, false);
       // String url = getImageEndpoint() + currentItem.getImagePath();

        ImageView imageView = (ImageView) rowView.findViewById(R.id.il_ImageView1);

        //imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.yes));

        imageView.setImageResource(currentItem.getImageId());
        // ImageLoader.getInstance().displayImage(url, imageView) ;

        TextView textView = (TextView) rowView.findViewById(R.id.il_textView1);
        textView.setText(currentItem.getTitle());

        return rowView;
    }

    /*public String getImageEndpoint(){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String server_url = sharedPref.getString(UserPrefActivity.KEY_PREF_SERVER_ENDPOINT, "");

        if (server_url.endsWith("/")){
            return server_url;
        }
        else{
            return server_url+"/";
        }
    }*/
}
