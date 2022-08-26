package com.example.myapplication1.Frangment.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication1.R;

/**
 *
 **/
public class FragmentOneActivity extends Fragment {
    private final String TAG = "FragmentOneActivity";
    private Button mBtnFragmentOne;
    private TextView mTextView;
    private View mView;
    private fragmentListener fragmentListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
        fragmentListener = (com.example.myapplication1.Frangment.Fragment.fragmentListener) getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
    }

//    public void setFragmentListener(FragmentOneActivity.fragmentListener fragmentListener) {
//        Log.e(TAG, "setFragmentListener");
//        this.fragmentListener = fragmentListener;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_one_activity, container, false);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        mBtnFragmentOne = getActivity().findViewById(R.id.btn_fragment_one);
        mTextView = getActivity().findViewById(R.id.et_fragment_one);
        mBtnFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mBtnFragmentOne.setText(mTextView.getText());
                if (fragmentListener != null) {
                    fragmentListener.info("12");
                }else{
                    Log.e(TAG,"setOnClickListener NO");
                }
            }
        });
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(TAG, "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach");
    }

}
