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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.content, new PlacesFragment()).commit();
        ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // highlight selected item
                item.setChecked(true);
                // switch fragment
                switch (item.getItemId()) {
                    case R.id.menu_places:
                        fragmentManager.beginTransaction().replace(R.id.content, new PlacesFragment()).commit();
                        break;
                    case R.id.menu_events:
                        fragmentManager.beginTransaction().replace(R.id.content, new EventsFragment()).commit();
                        break;
                    case R.id.menu_people:
                        fragmentManager.beginTransaction().replace(R.id.content, new PeopleFragment()).commit();
                        break;
                    case R.id.menu_sites:
                        fragmentManager.beginTransaction().replace(R.id.content, new SitesFragment()).commit();
                        break;
                    default:
                        fragmentManager.beginTransaction().replace(R.id.content, new PlacesFragment()).commit();
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
