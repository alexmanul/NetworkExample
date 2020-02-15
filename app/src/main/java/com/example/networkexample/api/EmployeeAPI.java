package com.example.networkexample.api;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface EmployeeAPI {

    @GET("/employee")
    Observable<JsonElement> getEmployees();

    @GET("/employee/{id}")
    Observable<JsonElement> getEmployeeById();

}
