package com.example.networkexample.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.networkexample.network.EmployeeRepository;

public class MyViewModelFactory implements ViewModelProvider.Factory {

    private final EmployeeRepository repository;

    public MyViewModelFactory(EmployeeRepository employeeRepository) {
        repository = employeeRepository;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MyViewModel.class)) {
            return (T) new MyViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
