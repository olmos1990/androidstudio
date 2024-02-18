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

import com.example.myapplication2024.databinding.FragmentMongodbBinding;
import com.example.myapplication2024.ui.mongodb.MongodbViewModel;

public class MongodbFragment extends Fragment {

    private FragmentMongodbBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MongodbViewModel mongodbViewModel =
                new ViewModelProvider(this).get(MongodbViewModel.class);

        binding = FragmentMongodbBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Toast.makeText(getActivity().getApplicationContext(),"mongodb",Toast.LENGTH_SHORT).show();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}