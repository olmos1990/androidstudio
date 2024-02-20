package com.example.myapplication2024.ui.mongodb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication2024.R;

import com.example.myapplication2024.databinding.FragmentMongodbBinding;
import com.example.myapplication2024.ui.mongodb.MongodbViewModel;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MongodbFragment extends Fragment {

    private FragmentMongodbBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MongodbViewModel mongodbViewModel =
                new ViewModelProvider(this).get(MongodbViewModel.class);

        binding = FragmentMongodbBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

// creating variables for our edittext, button and dbhandler
         EditText courseNameEdt;
         EditText courseTracksEdt;
         EditText courseDurationEdt;
         EditText courseDescriptionEdt;
         Button addCourseBtn;
         DBHandler dbHandler;



            // initializing all our variables.
            courseNameEdt = root.findViewById(R.id.idEdtCourseName);
            courseTracksEdt = root.findViewById(R.id.idEdtCourseTracks);
            courseDurationEdt = root.findViewById(R.id.idEdtCourseDuration);
            courseDescriptionEdt = root.findViewById(R.id.idEdtCourseDescription);
            addCourseBtn = root.findViewById(R.id.idBtnAddCourse);

            // creating a new dbhandler class
            // and passing our context to it.
            dbHandler = new DBHandler(getActivity().getApplicationContext());

            // below line is to add on click listener for our add course button.
            addCourseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // below line is to get data from all edit text fields.
                    String courseName = courseNameEdt.getText().toString();
                    String courseTracks = courseTracksEdt.getText().toString();
                    String courseDuration = courseDurationEdt.getText().toString();
                    String courseDescription = courseDescriptionEdt.getText().toString();

                    // validating if the text fields are empty or not.
                    if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()) {
                        Toast.makeText(getActivity().getApplicationContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.
                    dbHandler.addNewCourse(courseName, courseDuration, courseDescription, courseTracks);

                    // after adding the data we are displaying a toast message.
                    Toast.makeText(getActivity().getApplicationContext(), "Course has been added.", Toast.LENGTH_SHORT).show();
                    courseNameEdt.setText("");
                    courseDurationEdt.setText("");
                    courseTracksEdt.setText("");
                    courseDescriptionEdt.setText("");
                }
            });
        return root;
        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}