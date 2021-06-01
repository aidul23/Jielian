package com.brogrammers.jielian.fragments;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.databinding.FragmentMapBinding;

import org.jetbrains.annotations.NotNull;
import org.qap.ctimelineview.TimelineRow;
import org.qap.ctimelineview.TimelineViewAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;


public class MapFragment extends Fragment {

    private FragmentMapBinding binding;
    ArrayList<TimelineRow> timelineRowsList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMapBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupTimeline();
    }

    private TimelineRow createRandomTimelineRow(int id) {

        // Create new timeline row (pass your Id)
        TimelineRow myRow = new TimelineRow(id);

        //to set the row Date (optional)
        //myRow.setDate(getRandomDate());
        //to set the row Title (optional)
        myRow.setTitle(getTimeTitle());
        //to set the row Description (optional)
        myRow.setDescription("Description " + id);
        //to set row Below Line Size in dp (optional)
        myRow.setBellowLineSize(4);
        //to set row Image Size in dp (optional)
        myRow.setImageSize(16);

        myRow.setBellowLineColor(getResources().getColor(R.color.colorPrimary));

        //to set background color of the row image (optional)
        myRow.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        //to set the Background Size of the row image in dp (optional)
        myRow.setBackgroundSize(24);
        //to set row Date text color (optional)
        myRow.setDateColor(Color.argb(255, 0, 0, 0));
        //to set row Title text color (optional)
        myRow.setTitleColor(Color.argb(255, 0, 0, 0));
        //to set row Description text color (optional)
        myRow.setTitleColor(Color.argb(255, 0, 0, 0));

        return myRow;
    }

    public int getRandomNumber(int min, int max) {
        return min + (int) (Math.random() * max);
    }


    public String getTimeTitle() {
        Date date = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat("hh:mm aa");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
        String dateFormatted = formatter.format(date);
        return dateFormatted;
    }

    private void setupTimeline() {


        for (int i = 0; i < 5; i++) {
            //add the new row to the list
            timelineRowsList.add(createRandomTimelineRow(i));
        }

        ArrayAdapter<TimelineRow> myAdapter = new TimelineViewAdapter(requireContext(), 0, timelineRowsList,
                //if true, list will be sorted by date
                false);


        binding.timelineListView.setAdapter(myAdapter);
    }
}

