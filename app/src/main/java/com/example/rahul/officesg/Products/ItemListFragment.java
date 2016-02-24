package com.example.rahul.officesg.Products;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rahul.officesg.Adapter.ItemListAdapter;
import com.example.rahul.officesg.R;
import com.example.rahul.officesg.model.Item;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Manish on 2/12/2016.
 */
public class ItemListFragment extends ListFragment {
    //The activity class for this fragment. For use for inner classes
    private Activity parentActivity;

    private String mTag;
    public ItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTag = this.getTag();
        parentActivity = this.getActivity();
        SetUpList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_list,
                container, false);

        return rootView;
    }



    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        public void onItemSelected(Item item);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    /**
     * The fragment's current callback object, which is notified of list item
     * clicks.
     */
    private Callbacks mCallbacks = sDummyCallbacks;
    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(Item item) {
        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException(
                    "Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position,
                                long id) {

        super.onListItemClick(listView, view, position, id);

        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        mCallbacks.onItemSelected(((Item) getListAdapter().getItem(position)));
    }


    private void SetUpList()
    {
        try {
            List<Item> list = new ArrayList<Item>();;
            //Only level 1 indentation done for now - can be easily expanded to second level indentation
            switch (mTag)
            {
                case "Office Supplies" :
                    //These type of items will be directly coming from server database - api call (static for now)

                    Item newItem = new Item();

                    Random randomno = new Random();

                    // get next long value
                    long value = randomno.nextLong();
                    newItem.setId(value);
                    newItem.setImageId(R.drawable.ok);
                    newItem.setPrice(3.69);
                    newItem.setDescription("Stabilo 1867 Long Col.Pencil-12");
                    newItem.setTitle("Stabilo 1867 F/Len Col.Pencil-12");

                    Item newItem2 = new Item();

                    Random randomno1 = new Random();

                    // get next long value
                    long value1 = randomno1.nextLong();
                    newItem2.setId(value1);
                    newItem2.setImageId(R.drawable.ok_filled);
                    newItem2.setPrice(1.48);
                    newItem2.setDescription("Pilot Ball Pen Bp-145-F");
                    newItem2.setTitle("Pilot Ball Pen Bp-145-F");

                    list.add(newItem);
                    list.add(newItem2);
                    break;

                case "Facilities Supplies" :
                    Item newItemF = new Item();

                    Random randomnoF = new Random();

                    // get next long value
                    long valueF = randomnoF.nextLong();
                    newItemF.setId(valueF);
                    newItemF.setImageId(R.drawable.filter);
                    newItemF.setPrice(5);
                    newItemF.setDescription("Ideal for electronic devices.");
                    newItemF.setTitle("Energizer Alkaline Battery E93 BP2");

                    Item newItemF2 = new Item();

                    Random randomnoF1 = new Random();

                    // get next long value
                    long valueF1 = randomnoF1.nextLong();
                    newItemF2.setId(valueF1);
                    newItemF2.setImageId(R.drawable.filter_icon);
                    newItemF2.setPrice(6.1);
                    newItemF2.setDescription("Eveready Torch light 2D cell CE250");
                    newItemF2.setTitle("Protect Your Family and Power Your Outdoor Adventures with the Brightest and Longest Lasting LED Lantern.");

                    list.add(newItemF);
                    list.add(newItemF2);

                    break;
                case "Pantry Supplies" :
                    Item newItemP = new Item();

                    Random randomnoP = new Random();

                    // get next long value
                    long valueP = randomnoP.nextLong();
                    newItemP.setId(valueP);
                    newItemP.setImageId(R.drawable.password_default);
                    newItemP.setPrice(13);
                    newItemP.setDescription("2x more protection for truly healthy and extremely smooth hair.");
                    newItemP.setTitle("Boncafe Coffee Powder - All Day");

                    Item newItemP2 = new Item();

                    Random randomnoP1 = new Random();

                    // get next long value
                    long valueP1 = randomnoP1.nextLong();
                    newItemP2.setId(valueP1);
                    newItemP2.setImageId(R.drawable.password_error);
                    newItemP2.setPrice(2.60);
                    newItemP2.setDescription("No Artificial Colourings.Made from Real Ikan Bilis.No preservatives added.Extra Value 12Cube Pack");
                            newItemP2.setTitle("Jacob'S Box Hi Calcium Vegetable Cracker 180 G\n");

                    list.add(newItemP);
                    list.add(newItemP2);

                    break;
            }

            //newItem.setId(11.0);
            //List<Item> list = new ArrayList<Item>();;



                if (list != null && getListAdapter() == null) {
                    setListAdapter(new ItemListAdapter(parentActivity, list));
                }

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
