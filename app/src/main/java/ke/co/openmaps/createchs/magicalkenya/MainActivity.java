package ke.co.openmaps.createchs.magicalkenya;

import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;
    private int container = R.id.content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        ButterKnife.bind(this);
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
                drawerLayout.closeDrawers();
                return true;
            }
        });
        // load the places fragment if no fragment is added
        if (fragmentManager.getFragments().size() == 0) {
            fragmentManager.beginTransaction().add(container, new PlacesFragment()).commit();
        }
    }
}
