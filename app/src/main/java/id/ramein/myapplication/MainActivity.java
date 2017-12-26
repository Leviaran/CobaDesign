package id.ramein.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    AHBottomNavigation bottomNavigation;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.navbutton);

        AHBottomNavigationItem itemHome = new AHBottomNavigationItem("home",R.drawable.ic_home);
        AHBottomNavigationItem itemBanner = new AHBottomNavigationItem("banner",R.drawable.ic_banner);
        AHBottomNavigationItem itemProfile = new AHBottomNavigationItem("profil",R.drawable.ic_profile);

        bottomNavigation.addItem(itemHome);
        bottomNavigation.addItem(itemBanner);
        bottomNavigation.addItem(itemProfile);

        bottomNavigation.setDefaultBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);

        bottomNavigation.setCurrentItem(1);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position){
                    case 1: Toast.makeText(getBaseContext(),"Home",Toast.LENGTH_SHORT).show();
                        return true;
                    case 2: Toast.makeText(getBaseContext(),"Banner",Toast.LENGTH_SHORT).show();
                        return true;
                    case 3: Toast.makeText(getBaseContext(),"Profile",Toast.LENGTH_SHORT).show();
                        return true;
                    default: return true;
                }
            }
        });

        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override
            public void onPositionChange(int y) {
                switch (y){
                    case 1: Toast.makeText(getBaseContext(),"Home",Toast.LENGTH_SHORT).show();
                        break;
                    case 2: Toast.makeText(getBaseContext(),"Banner",Toast.LENGTH_SHORT).show();
                        break;
                    case 3: Toast.makeText(getBaseContext(),"Profile",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


    }
}
