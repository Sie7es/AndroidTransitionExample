package com.bignerdranch.android.transitionexample;

import android.app.Fragment;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class TransitionFragment extends Fragment {
    private TransitionManager mTransitionManager;
    private Scene mScene1;
    private Scene mScene2;

    public TransitionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transition_scene_1, container, false);

        View rootView2 = inflater.inflate(R.layout.fragment_transition_scene_2, container, false);


        //ViewGroup container = (ViewGroup)findViewById(R.id.container);
        TransitionInflater transitionInflater = TransitionInflater.from(getActivity());
        mTransitionManager = transitionInflater.inflateTransitionManager(R.transition.transition_manager, container);
        mScene1 = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_1, getActivity());
        mScene2 = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_2, getActivity());
        final Scene scene = new Scene(container, (ViewGroup) rootView2);

        Button bt = (Button) rootView.findViewById(R.id.goButton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToScene2(view);
            }
        });

        Button bt2 = (Button) rootView2.findViewById(R.id.myButton);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToScene1(view);
            }
        });


    return rootView;
    }

    public void goToScene1(View view) {
        mTransitionManager.transitionTo(mScene1);
    }

    public void goToScene2(View view) {
        mTransitionManager.transitionTo(mScene2);
    }


}
