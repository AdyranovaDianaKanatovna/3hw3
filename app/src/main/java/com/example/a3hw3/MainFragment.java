package com.example.a3hw3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {

private EditText editInputText;
public  final static String KEY_BUNDLE = "key.param.main";
private Button btnNext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editInputText = view.findViewById(R.id.ed_input_text);
        btnNext = view.findViewById(R.id.next);
        if(getArguments()!=null){
            String text = getArguments().getString(FifthFragment.KEY_BUNDLE);
            editInputText.setText(text);
        }
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle suitcase = new Bundle();
                suitcase.putString(KEY_BUNDLE,editInputText.getText().toString());
                SecondFragment fragment = new SecondFragment();
                fragment.setArguments(suitcase);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, fragment).commit() ;
            }
        });
    }
}