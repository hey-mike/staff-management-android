package com.sanitation.app.staffmanagment.signhistory;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanitation.app.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SignDetailFragment extends Fragment {
    private static final String TAG = "SignDetailFragment";

    public static final String ARG_ID = "id";
    public static final String ARG_TITLE = "title";
    public static final String ARG_CONTENT = "content";
    public static final String ARG_DATE = "date";

    private SignHistory mSignHistory;
    public SignDetailFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Activity activity = this.getActivity();
//        if (getArguments().containsKey(ARG_TITLE)) {
//            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
//            if (appBarLayout != null) {
//                appBarLayout.setTitle(getArguments().getString(ARG_TITLE));
//            }
//        }

        if (getArguments().containsKey(ARG_ID)) {
            mSignHistory = SignManager.getInstance().getNotice(getArguments().getString(ARG_ID));
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mSignHistory.title);
            }
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_detail, container, false);
//        if (getArguments().containsKey(ARG_CONTENT)) {
//            TextView content = (TextView) rootView.findViewById(R.id.content);
//            content.setText(getArguments().getString(ARG_CONTENT));
//        }
        if (getArguments().containsKey(ARG_ID)) {
            TextView content = (TextView) rootView.findViewById(R.id.content);
            content.setText(mSignHistory.content);
        }
        return rootView;
    }
}
