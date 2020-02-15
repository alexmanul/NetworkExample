package com.example.networkexample.network;

import com.example.networkexample.model.Employee;

import java.util.List;

import io.reactivex.Observable;

public interface EmployeeRepository {

    Observable<List<Employee>> getEmployees();
}
