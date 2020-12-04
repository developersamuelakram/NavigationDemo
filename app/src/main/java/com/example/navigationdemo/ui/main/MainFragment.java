package com.example.navigationdemo.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.navigationdemo.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel


        Button button = (Button) getView().findViewById(R.id.button);
        EditText editText = (EditText) getView().findViewById(R.id.nametext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //mainfragmentdirections is java auto generated
                //maintosecond is our id of action.
                // now just like the button had an id main to second simmilarly edittextview
                // has an id that can be used here in one line
                //we are sending our text with the button click
                Navigation.findNavController(v).navigate(MainFragmentDirections
                        .mainToSecond()
                        .setUserName(editText.getText().toString()));

            }
        });
    }

}