package com.winseslas.refactoring.myFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.winseslas.refactoring.R;
import com.winseslas.refactoring.adapter.PartnersAdapter;

public class PartnersFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.item_horizontal_partners, container, false);

        // partners recycler view
        RecyclerView horizontalRecyclerView = root.findViewById(R.id.horizontal_partners_recycler_view);
        if (horizontalRecyclerView != null) {
            horizontalRecyclerView.setAdapter(new PartnersAdapter(R.layout.item_horizontal_partners));
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
