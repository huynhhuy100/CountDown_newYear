package com.example.tetapp.ui.tetDuong.tetAm;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tetapp.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.iwgang.countdownview.CountdownView;

public class tetAFragment extends Fragment {

    private TetAViewModel mViewModel;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    SimpleDateFormat gio = new SimpleDateFormat("hh:mm:ss a");

    public static tetAFragment newInstance() {
        return new tetAFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tet_a_fragment, container, false);

        CountdownView mCvCountdownView = view.findViewById(R.id.countdownView);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = view.findViewById(R.id.day);
        TextView textViewGio = view.findViewById(R.id.gio);

        textViewDate.setText(currentDate);

        textViewGio.setText(sdf.format(calendar.getTime()) +"\n");


        String countDate = "12-02-2021 00:00:00";
        String dateend = "24-12-2020 2:23:0";
        Date now = new Date();

        try {
            //Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long newYearDate = date.getTime();
            long countDownToNewYear = newYearDate - currentTime;
            mCvCountdownView.start(countDownToNewYear);

            if (date.equals(dateend)){
                Toast.makeText(getContext(), "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
            }else {

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TetAViewModel.class);
        // TODO: Use the ViewModel
    }

}