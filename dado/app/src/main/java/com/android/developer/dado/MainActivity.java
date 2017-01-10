package com.android.developer.dado;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener
{
    //This is our tablayout
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Dice of Power!");
        setSupportActionBar(toolbar);
        configToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about: {
                menuAboutDialog();
                break;
            }
            // case blocks for other MenuItems (if any)
        }
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return false;
    }


    private void menuAboutDialog(){
        AlertDialog.Builder readyDialog = new AlertDialog.Builder(MainActivity.this);
        readyDialog.setTitle("About");
        readyDialog.setMessage("Created by Rodrigo R. Ribeiro\n\n\n\n\nv1.0\n\nJanuary, 2017").setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //função do botão de OK
                    }
                });
        AlertDialog dialog = readyDialog.create();
        dialog.show();
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }


    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }


    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    public void configToolbar(){
        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("D4"));
        tabLayout.addTab(tabLayout.newTab().setText("D6"));
        tabLayout.addTab(tabLayout.newTab().setText("D8"));
        tabLayout.addTab(tabLayout.newTab().setText("D10"));
        tabLayout.addTab(tabLayout.newTab().setText("D12"));
        tabLayout.addTab(tabLayout.newTab().setText("D20"));
        tabLayout.addTab(tabLayout.newTab().setText("D%"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Toast toast;
        if(id == R.id.nav_dice){
            toast = Toast.makeText(this, "Dice", Toast.LENGTH_SHORT);
            if (toast.getView().isShown()){
                toast.cancel();
                toast.show();
            }
        } else if (id == R.id.nav_sheet){
            toast = Toast.makeText(this, "Sheet", Toast.LENGTH_SHORT);
            if (toast.getView().isShown()){
                toast.cancel();
                toast.show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}