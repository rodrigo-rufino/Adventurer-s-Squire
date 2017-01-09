package com.android.developer.dado;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Dice of Power");

        configToolbar();
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

}