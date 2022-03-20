package com.example.a3hw3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ThirdFragment extends Fragment {
    public  final static String KEY_BUNDLE = "key.param.third";
    private Button next;
    private TextView tvValue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        next = view.findViewById(R.id.next);
        tvValue = view.findViewById(R.id.tv_value);
        if (getArguments() != null) {
            String value = getArguments().getString(SecondFragment.KEY_BUNDLE);
            tvValue.setText(value);
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle suitcase = new Bundle();
                suitcase.putString(KEY_BUNDLE,tvValue.getText().toString());
                FourthFragment fragment = new FourthFragment();
                fragment.setArguments(suitcase);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container,fragment).commit();
            }
        });
    }
}