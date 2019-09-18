package msrit.santhosh.fragment1;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_list extends ListFragment {

    ItemSelected activity;
    // Inflate the layout for this fragment

    public interface ItemSelected{
        void onListItemSelected(int index);
    }

    public fragment_list() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        /*ArrayList<String> data = new ArrayList<>();
        data.add("1 this is first");
        data.add("this is second");
        data.add("this is third");*/

        String [] data = getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));

        // to show the description of the first one when the screen in landscape mode.
        if(this.getActivity().findViewById(R.id.id_activity_land) != null) {
            activity.onListItemSelected(0);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        activity.onListItemSelected(position);
    }
}
