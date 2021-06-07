package com.brogrammers.jielian.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.brogrammers.jielian.helper.Converter;
import com.brogrammers.jielian.R;
import com.brogrammers.jielian.databinding.ActivityMainBinding;
import com.brogrammers.jielian.fragments.ProfileFragment;
import com.brogrammers.jielian.model.CategoryItem;
import com.brogrammers.jielian.model.OrderItem;
import com.brogrammers.jielian.utility.StringUtility;
import com.brogrammers.jielian.viewmodel.MainActivityViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.like.LikeButton;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    private NavController navController;

    private BottomSheetBehavior bottomSheetBehavior;

    private MainActivityViewModel model;

    private static int cart_count = 0;

    ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        cart_count = 2;
//        invalidateOptionsMenu();

        model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        setSupportActionBar(binding.toolbarId);

        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.homeFragment);
//        topLevelDestinations.add(R.id.branchFragment);

        new AppBarConfiguration.Builder(topLevelDestinations).setOpenableLayout(binding.drawerLayout);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout);

        NavigationUI.setupWithNavController(binding.navigationDrawerView, navController);

        bottomSheetBehavior = BottomSheetBehavior.from(binding.getRoot().findViewById(R.id.bottom_sheet));
        bottomSheetBehavior.setPeekHeight(0);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.addBottomSheetCallback(callback);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        findViewById(R.id.item_quantity_increase).setOnClickListener(this);
        findViewById(R.id.item_quantity_decrease).setOnClickListener(this);
        findViewById(R.id.add_to_cart_button).setOnClickListener(this);
        observeSelectedItemAndChangeShape();
        model.getTotalOrderQuantity().observe(this, orderTotalQuantityObserver);
    }

    //menu option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.cartFragment);
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this, cart_count, R.drawable.shopping_cart));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);

    }


    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }


    //toolbar back button
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, binding.drawerLayout);
    }

    private void observeSelectedItemAndChangeShape() {

        ShapeableImageView foodItemImage = findViewById(R.id.food_item_image);
        TextView foodItemName = findViewById(R.id.food_item_name);
        TextView foodItemPrice = findViewById(R.id.food_item_price);
        TextView foodItemDescription = findViewById(R.id.food_item_description);
        TextView foodItemQuantity = findViewById(R.id.food_item_quantity);
        Button addToCartButton = findViewById(R.id.add_to_cart_button);

        foodItemImage.setShapeAppearanceModel(foodItemImage.getShapeAppearanceModel()
                .toBuilder()
                .setTopLeftCorner(CornerFamily.ROUNDED, 30)
                .setTopRightCorner(CornerFamily.ROUNDED, 30)
                .build());


        model.getCategoryItemMutableLiveData().observe(this, new Observer<CategoryItem>() {
            @Override
            public void onChanged(CategoryItem categoryItem) {

                if (categoryItem != null) {

                    if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        bottomSheetBehavior.setHideable(true);

                        foodItemName.setText(categoryItem.getTitle());
                        foodItemPrice.setText(StringUtility.getFormattedString(categoryItem.getPrice()));
                        foodItemDescription.setVisibility(View.VISIBLE);
                        foodItemDescription.setText((categoryItem.getDescription()));
                    } else {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }

                }

            }
        });

        model.getOrderItemMutableLiveData().observe(this, new Observer<OrderItem>() {
            @Override
            public void onChanged(OrderItem orderItem) {
                if (orderItem != null) {

                    model.getTotalQuantity().setValue(orderItem.getItemQuantity());

                    if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        bottomSheetBehavior.setHideable(true);

                        foodItemName.setText(orderItem.getItemName());
                        foodItemPrice.setText(StringUtility.getFormattedString(orderItem.getItemPrice()));
                        foodItemQuantity.setText(String.valueOf(orderItem.getItemQuantity()));
                        foodItemDescription.setVisibility(View.GONE);
                    } else {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }

                }
            }
        });

        model.getTotalQuantity().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (integer != null) {

                    foodItemQuantity.setText(String.valueOf(integer));

                    if (integer == 0) {
                        addToCartButton.setText("Remove from cart");
                        foodItemQuantity.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                        addToCartButton.setOnClickListener(removeFromCartButtonClickListener);
                    } else {
                        addToCartButton.setText("Add to cart");
                        foodItemQuantity.setTextColor(getResources().getColor(android.R.color.background_dark));
                        addToCartButton.setOnClickListener(addToCartButtonClickListener);
                    }

                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_quantity_increase:
                model.increaseQuantity();
                break;
            case R.id.item_quantity_decrease:
                model.decreaseQuantity();
                break;
        }
    }

    private void resetQuantityAndFavoriteButton() {
        LikeButton favoriteButton = findViewById(R.id.favorite_button);
        if (favoriteButton.isLiked()) {
            favoriteButton.setLiked(false);
        }
        model.getTotalQuantity().postValue(1);
    }

    // listener for the bottom sheet
    private final BottomSheetBehavior.BottomSheetCallback callback = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull @NotNull View bottomSheet, int newState) {

            // if bottom sheet is collapsed then reset the quantity to 1 and favorite button to default state
            if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                resetQuantityAndFavoriteButton();
            }
        }

        @Override
        public void onSlide(@NonNull @NotNull View bottomSheet, float slideOffset) {

        }
    };

    private final View.OnClickListener addToCartButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // add to cart
            CategoryItem categoryItem = model.getCategoryItemMutableLiveData().getValue();

            int itemQuantity = model.getTotalQuantity().getValue();
            int cost = categoryItem.getPrice() * itemQuantity;

            model.getOrderItemLiveData().getValue().add(
                    new OrderItem(categoryItem.getTitle(), cost, itemQuantity)
            );

            model.getTotalOrderQuantity().setValue(
                    model.getTotalOrderQuantity().getValue() + itemQuantity
            );

            model.increaseCost(cost);

            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            Toast.makeText(MainActivity.this, categoryItem.getTitle() + " is added to cart", Toast.LENGTH_SHORT).show();
        }
    };

    private final View.OnClickListener removeFromCartButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // remove to cart
            CategoryItem categoryItem = model.getCategoryItemMutableLiveData().getValue();

            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            Toast.makeText(MainActivity.this, categoryItem.getTitle() + " is removed from cart", Toast.LENGTH_SHORT).show();
        }
    };

    private final Observer<Integer> orderTotalQuantityObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer integer) {
            if (integer != null && integer > 0) {
                cart_count = integer;
                invalidateOptionsMenu();
            }
        }
    };
}