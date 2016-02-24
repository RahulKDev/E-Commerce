package com.example.rahul.officesg.Products;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rahul.officesg.Cart.CartFragment;
import com.example.rahul.officesg.R;
import com.example.rahul.officesg.model.Item;

/**
 * Created by Manish on 2/13/2016.
 */
public class ItemDetailsActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Show the Up button in the action bar.
//        getActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            ItemDetailsFragment fragment = new ItemDetailsFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                openSettingsPage();
                return true;
            case android.R.id.home:

                NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSettingsPage() {
       // Intent detailIntent = new Intent(this, UserPrefActivity.class);
       // startActivity(detailIntent);

    }

    public void addToCartAction(View view) {
        addItemToCart(ItemListActivity.selectedItem);

        //Go back to list page
        NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
    }

    public void addItemToCart(Item item) {
        //Avoid duplicates. Re-adding in case there has been some change to the item in the server
        if (CartFragment.currentCartItemsMap.containsKey(item.getId())) {
            CartFragment.currentCartItems.remove(item);
        }
        CartFragment.currentCartItemsMap.put(item.getId(), item);

        CartFragment.convertItemsMaptoListStatic();

        //server side
        /*new AddToCartService().execute(GlobalDataProvider
                .getInstance()
                .getRestServiceUrl() + "cart/" + item.getId());*/
    }

    /*public class AddToCartService extends GetRequestService {

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }

    }*/

}
