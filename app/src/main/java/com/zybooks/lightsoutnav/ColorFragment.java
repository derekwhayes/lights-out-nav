package com.zybooks.lightsoutnav;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ColorFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_color, container, false);

        SharedPreferences sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        int colorId = sharedPref.getInt("color", R.color.yellow);

        int radioId = R.id.radio_yellow;
        if (colorId == R.color.red) {
            radioId = R.id.radio_red;
        }
        else if (colorId == R.color.orange) {
            radioId = R.id.radio_orange;
        }
        else if (colorId == R.color.green) {
            radioId = R.id.radio_green;
        }

        RadioButton radio = rootView.findViewById(radioId);
        radio.setChecked(true);

        RadioGroup colorRadioGroup = rootView.findViewById(R.id.color_radio_group);
        for (int i = 0; i < colorRadioGroup.getChildCount(); i++) {
            radio = (RadioButton) colorRadioGroup.getChildAt(i);
            radio.setOnClickListener(this::onColorSelected);
        }

        return rootView;
    }

    private void onColorSelected(View view) {
        int colorId = R.color.yellow;
        if (view.getId() == R.id.radio_red) {
            colorId = R.color.red;
        }
        else if (view.getId() == R.id.radio_orange) {
            colorId = R.color.orange;
        }
        else if (view.getId() == R.id.radio_green) {
            colorId = R.color.green;
        }

        SharedPreferences sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("color", colorId);
        editor.apply();
    }
}