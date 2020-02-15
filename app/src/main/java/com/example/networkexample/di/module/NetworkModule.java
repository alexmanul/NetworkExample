package com.example.networkexample.di.module;

import com.example.networkexample.network.EmployeeRepository;
import com.example.networkexample.network.EmployeeRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    public EmployeeRepository providesEmployeeRepository() {
        return new EmployeeRepositoryImpl();
    }
}
