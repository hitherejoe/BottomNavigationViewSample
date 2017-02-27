package bottomnav.hitherejoe.com.bottomnavigationsample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textFavorites;
    private TextView textSchedules;
    private TextView textMusic;
    private int selected_menu=1;
    private static String KEY_SELECTED_MENU="KEY_SELECTED_MENU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFavorites = (TextView) findViewById(R.id.text_favorites);
        textSchedules = (TextView) findViewById(R.id.text_schedules);
        textMusic = (TextView) findViewById(R.id.text_music);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        if (savedInstanceState != null) {
            int selected_menu_id= savedInstanceState.getInt(KEY_SELECTED_MENU);
            handleMenu(selected_menu_id);
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        return handleMenu(item.getItemId());
                    }
                });
    }

    private boolean handleMenu(int sel_item) {
        switch (sel_item) {
            case R.id.action_favorites:
                selected_menu=R.id.action_favorites;
                textFavorites.setVisibility(View.VISIBLE);
                textSchedules.setVisibility(View.GONE);
                textMusic.setVisibility(View.GONE);
                break;
            case R.id.action_schedules:
                selected_menu=R.id.action_schedules;
                textFavorites.setVisibility(View.GONE);
                textSchedules.setVisibility(View.VISIBLE);
                textMusic.setVisibility(View.GONE);
                break;
            case R.id.action_music:
                selected_menu=R.id.action_music;
                textFavorites.setVisibility(View.GONE);
                textSchedules.setVisibility(View.GONE);
                textMusic.setVisibility(View.VISIBLE);
                break;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SELECTED_MENU, selected_menu);
    }
}
