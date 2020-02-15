package com.example.networkexample.di.module;

import com.example.networkexample.network.EmployeeRepository;
import com.example.networkexample.viewmodel.MyViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class RecyclerViewModule {

    @Provides
    static MyViewModelFactory providesMyViewModelFactory(EmployeeRepository employeeRepository) {
        return new MyViewModelFactory(employeeRepository);
    }
}
