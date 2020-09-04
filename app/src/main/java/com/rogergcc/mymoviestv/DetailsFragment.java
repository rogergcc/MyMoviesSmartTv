package com.rogergcc.mymoviestv;

import android.os.Bundle;
import android.support.v17.leanback.app.DetailsSupportFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.SparseArrayObjectAdapter;

import static android.media.session.PlaybackState.ACTION_PLAY;
import static android.media.session.PlaybackState.ACTION_REWIND;

public class DetailsFragment extends DetailsSupportFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buildUI();

    }

    private void buildUI(){

        ClassPresenterSelector selector = new ClassPresenterSelector();
        selector.addClassPresenter(DetailsOverviewRow.class,
                new FullWidthDetailsOverviewRowPresenter(
                        new DetailsDescriptionPresenter()
                )
        );

        ArrayObjectAdapter madapter =new ArrayObjectAdapter(selector);
        DetailsOverviewRow detailsOverview = new DetailsOverviewRow("Media Item Details");
        // Add images and action buttons to the details view
        detailsOverview
                .setImageDrawable(getActivity()
                                  .getResources()
                                  .getDrawable(R.drawable.avengers)
                                  );

        //Add some Actions
        SparseArrayObjectAdapter actionAdap = new SparseArrayObjectAdapter();
        actionAdap.set((int)ACTION_PLAY,new Action(1, "Buy $9.99"));
        actionAdap.set((int)ACTION_REWIND,new Action(2, "Rent $2.99"));
        detailsOverview.setActionsAdapter(actionAdap);
        madapter.add(detailsOverview);
        setAdapter(madapter);


    }

}




