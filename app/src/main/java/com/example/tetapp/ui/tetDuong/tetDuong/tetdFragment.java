package com.example.tetapp.ui.tetDuong.tetDuong;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
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

public class tetdFragment extends Fragment {

    private TetdViewModel mViewModel;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    SimpleDateFormat gio = new SimpleDateFormat("hh:mm:ss a");


    public static tetdFragment newInstance() {
        return new tetdFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tetd_fragment, container, false);

        CountdownView mCvCountdownView = view.findViewById(R.id.countdownView);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = view.findViewById(R.id.day);
        TextView textViewGio = view.findViewById(R.id.gio);

        textViewDate.setText(currentDate);

        textViewGio.setText(sdf.format(calendar.getTime()) +"\n");


        String countDate = "01-01-2021 00:00:00";
        Date now = new Date();
        try {
            //Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long newYearDate = date.getTime();
            long countDownToNewYear = newYearDate - currentTime;
            mCvCountdownView.start(countDownToNewYear);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (currentDate == countDate){
            Toast.makeText(getContext(), "aaaaaaaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
        }

        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TetdViewModel.class);
        // TODO: Use the ViewModel
    }

}