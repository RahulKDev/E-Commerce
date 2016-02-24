package com.example.rahul.officesg.Products;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.rahul.officesg.Cart.CartFragment;
import com.example.rahul.officesg.R;
import com.example.rahul.officesg.model.Item;
import com.example.rahul.officesg.tabs.CustomTabListener;

/**
 * Created by Manish on 2/12/2016.
 */
public class ItemListActivity extends FragmentActivity
        implements
        ItemListFragment.Callbacks, CartFragment.Callbacks{

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    //Hold a reference to cart fragment
    private CartFragment currentCartFragment;

    @Override
    public void storeCartFragment(CartFragment cartFragment) {
        this.currentCartFragment = cartFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the activity should be in two-pane mode.
            mTwoPane = true;


        }

        //Create Tabs
        final ActionBar actionBar = getActionBar();
        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //actionBar.

        //---These will again be dynamically populated from the database server side- api call -getting back json data according to varieties of options available.
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Office Supplies")
                        .setTabListener(new CustomTabListener<ItemListFragment>(this,
                                "Office Supplies", ItemListFragment.class)));

        actionBar.addTab(
                actionBar.newTab()
                        .setText("Facilities Supplies")
                        .setTabListener(new CustomTabListener<ItemListFragment>(this,
                                "Facilities Supplies", ItemListFragment.class)));

        actionBar.addTab(
                actionBar.newTab()
                        .setText("Pantry Supplies")
                        .setTabListener(new CustomTabListener<ItemListFragment>(this,
                                "Pantry Supplies", ItemListFragment.class)));


        actionBar.addTab(
                actionBar.newTab()
                        .setText("Cart")
                        .setTabListener(new CustomTabListener<CartFragment>(this, "Cart", CartFragment.class)));
    }

    public static Item selectedItem = null;

    /**
     * Callback method from {@link ItemListFragment.Callbacks} indicating that
     * the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(Item item) {
        selectedItem = item;
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            //Bundle arguments = new Bundle();

            ItemDetailsFragment fragment = new ItemDetailsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment).commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailsActivity.class);
            startActivity(detailIntent);
        }
    }

    // Delete items and update cart
    public void deleteFromCartAction(View view){
        currentCartFragment.removeItemFromCart();
    }

    // Checkout and update cart
    public void checkoutCartAction(View view){
        currentCartFragment.checkoutCart();
    }
}
