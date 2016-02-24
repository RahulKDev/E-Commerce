package com.example.rahul.officesg.Products;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rahul.officesg.R;
import com.example.rahul.officesg.model.Item;

import java.text.NumberFormat;

/**
 * Created by Manish on 2/13/2016.
 */
public class ItemDetailsFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM = "selected_item";

    /**
     * The dummy content this fragment is presenting.
     */
    private Item mItem;

    public ItemDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItem = ItemListActivity.selectedItem;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail,
                container, false);


        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail))
                    .setText(mItem.getTitle());

            //String url = getImageEndpoint() + mItem.getImagePath();

            ImageView imageView = (ImageView) rootView.findViewById(R.id.ImageView1);


            /*DisplayImageOptions options =
                    new DisplayImageOptions.Builder()
                            .delayBeforeLoading(0)//Good way to simulate slow performance
                            .cacheInMemory(true) // default
                            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                            .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                            .displayer(new SimpleBitmapDisplayer()) // default
                            .handler(new Handler()) // default
                            .build();
            ImageLoader.getInstance().displayImage(url, imageView, options);*/
            //imageView.setImageDrawable(getResources().getDrawable(R.drawable.yes));
            imageView.setImageResource(mItem.getImageId());
            TextView priceView = (TextView) rootView.findViewById(R.id.priceText);
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String moneyString = formatter.format(mItem.getPrice());
            priceView.setText(moneyString);
        }

        return rootView;
    }
}
