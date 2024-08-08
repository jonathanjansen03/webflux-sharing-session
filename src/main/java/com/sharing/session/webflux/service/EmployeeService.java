package com.sharing.session.webflux.service;

import java.util.List;

import com.sharing.session.webflux.entity.Employee;
import com.sharing.session.webflux.model.request.EmployeeRequest;

import reactor.core.publisher.Mono;

public interface EmployeeService {

  Mono<Employee> createEmployee(EmployeeRequest request);

  Mono<List<Employee>> getAllEmployees();

  Mono<Employee> findEmployee(String id);

  Mono<Employee> updateEmployee(String id, EmployeeRequest request);

  Mono<Void> deleteEmployee(String id);
}
