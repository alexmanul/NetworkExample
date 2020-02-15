package com.example.networkexample.network;


import android.text.TextUtils;

import com.example.networkexample.api.EmployeeAPI;
import com.example.networkexample.model.Employee;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class EmployeeRepositoryImpl extends BaseRepository<EmployeeAPI> implements EmployeeRepository {
    final String IMAGE_URL = "https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg";

    @Override
    public Observable<List<Employee>> getEmployees() {
        return createApi(EmployeeAPI.class)
                .getEmployees().map(json -> {
                    List<Employee> employees = new ArrayList<>();

                    JsonObject jsonObject = json.getAsJsonObject();
                    JsonArray data = jsonObject.get("data").getAsJsonArray();

                    for (int i = 0; i < data.size(); i++) {
                        Employee employee = new Employee();
                        JsonObject object = data.get(i).getAsJsonObject();

                        employee.setId(object.get("id").getAsInt());
                        employee.setName(object.get("employee_name").getAsString());
                        employee.setSalary(object.get("employee_salary").getAsInt());
                        employee.setAge(object.get("employee_age").getAsInt());
                        employee.setImage(object.get("profile_image").getAsString());

                        if (TextUtils.isEmpty(employee.getImage())) {
                            employee.setImage(IMAGE_URL);
                        }

                        employees.add(employee);
                    }

                    return employees;
                }).compose(applySchedulers());
    }

}
