package ke.co.openmaps.createchs.magicalkenya;

import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;
    private int container = R.id.content;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        ButterKnife.bind(this);
        // set-up action bar
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // highlight selected item
                item.setChecked(true);
                // switch fragment
                switch (item.getItemId()) {
                    case R.id.menu_places:
                        fragmentManager.beginTransaction().replace(container, new PlacesFragment()).commit();
                        break;
                    case R.id.menu_events:
                        fragmentManager.beginTransaction().replace(container, new EventsFragment()).commit();
                        break;
                    case R.id.menu_people:
                        fragmentManager.beginTransaction().replace(container, new PeopleFragment()).commit();
                        break;
                    case R.id.menu_sites:
                        fragmentManager.beginTransaction().replace(container, new SitesFragment()).commit();
                        break;
                    default:
                        fragmentManager.beginTransaction().replace(container, new PlacesFragment()).commit();
                }
                // set actionbar title
                actionBar.setSubtitle(item.getTitle());
                drawerLayout.closeDrawers();
                return true;
            }
        });
        // load the places fragment if no fragment is added
        if (fragmentManager.getFragments().size() == 0) {
            fragmentManager.beginTransaction().add(container, new PlacesFragment()).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // open drawer on menu icon click
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
