package com.samuel.app_noticias;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.samuel.app_noticias.News.Categories;
import com.samuel.app_noticias.News.Search;
import com.samuel.app_noticias.News.fragment_all_news;
import com.samuel.app_noticias.News.fragment_tech_news;
import com.samuel.app_noticias.Utils.Constants;
import com.samuel.app_noticias.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private boolean isListView;
    private Menu menu;
    private boolean brasil = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        isListView = true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }

       MenuItem searchItem = menu.findItem(R.id.action_search);
       SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
       searchView.setOnQueryTextListener(this);

        return super.onOptionsItemSelected(item);
    }

    private void toggle() {
        fragment_all_news fragment_all_news=new fragment_all_news();
        fragment_tech_news fragment_tech_news=new fragment_tech_news();
        MenuItem item = menu.findItem(R.id.action_toggle);
        if (isListView) {


            item.setIcon(R.drawable.ic_view_day_black_24dp);
            item.setTitle("Mostrar como lista");
            isListView = false;


            fragment_all_news.setLayout(isListView);
            fragment_tech_news.setLayout(isListView);
        } else {


            item.setIcon(R.drawable.ic_dashboard_black_24dp);
            item.setTitle("Mostrar como card");
            isListView = true;

            fragment_all_news.setLayout(isListView);
            fragment_tech_news.setLayout(isListView);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent intent = new Intent(MainActivity.this, Categories.class);
        if (id == R.id.nav_business) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_BUSINESS);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Negocios");
            startActivity(intent);
        } else if (id == R.id.nav_entertainment) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_ENTERTAINMENT);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Entretenimento");
            startActivity(intent);

        } else if (id == R.id.nav_politics) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_POLITICS);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Tecnologia");
            startActivity(intent);

        } else if (id == R.id.nav_science) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_SCIENCE);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Ciência");
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent in = new Intent();
            in.setAction(Intent.ACTION_SEND);
            in.putExtra(Intent.EXTRA_TEXT, " Olha que app legal de noticias: \n" +
                    "...link da playStore...");
            in.setType("text/plain");
            startActivity(in);
        } else if (id == R.id.nav_sports) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_SPORTS);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Esportes");
            startActivity(intent);
        }
// else if (id == R.id.brasil_teste) {
//            brasil = false;
//            intent.putExtra(Constants.KEY_CATEGORY_INTENT, "google-news-br");
//            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Brasil Noticias");
//            startActivity(intent);
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment_all_news(), "todas");
        adapter.addFragment(new fragment_tech_news(), "tech");

        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons() {

        tabLayout.getTabAt(0).setText("TODAS");
        tabLayout.getTabAt(1).setText("TECH");


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        TextView texto = findViewById(R.id.action_search);

        Constants.SEARCH_TEXT = (String) texto.getText();

        Intent intent = new Intent(MainActivity.this, Search.class);
        intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.SEARCH_TEXT);
        intent.putExtra(Constants.KEY_CATEGORY_LABEL, Constants.SEARCH_TEXT);
        startActivity(intent);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
