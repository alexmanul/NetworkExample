package com.example.networkexample.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.networkexample.network.EmployeeRepository;

public class MyViewModel extends ViewModel {

    private final EmployeeRepository repository;

    public MyViewModel(EmployeeRepository employeeRepository) {
        repository = employeeRepository;
    }
}
