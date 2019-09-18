package msrit.santhosh.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements fragment_list.ItemSelected{
    TextView txtin;
    String [] description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtin = findViewById(R.id.id_textview_in_fragdetail);
        description = getResources().getStringArray(R.array.descriptions);
        /**
         * when screen in portrait mode
         */
        if(findViewById(R.id.id_activity_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.id_fragdetails_in_activitymain))
                    .show(manager.findFragmentById(R.id.id_fraglist_in_activitymain))
                    .commit();
        }
        //when screen in landscapre mode
        if(findViewById(R.id.id_activity_land) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.id_fragdetails_in_activitymain))
                    .show(manager.findFragmentById(R.id.id_fraglist_in_activitymain))
                    .commit();
        }
    }

    @Override
    public void onListItemSelected(int index) {
            txtin.setText(description[index]);
        // only when screen in portrait mode.
        if(findViewById(R.id.id_activity_portrait) != null) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.id_fragdetails_in_activitymain))
                    .hide(manager.findFragmentById(R.id.id_fraglist_in_activitymain))
                    .addToBackStack(null)   /*to go back to when back button is pressed */
                    .commit();
        }
    }
}
