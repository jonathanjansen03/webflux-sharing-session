package com.sharing.session.webflux.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.sharing.session.webflux.controller.exception.DataNotFoundException;
import com.sharing.session.webflux.entity.Employee;
import com.sharing.session.webflux.model.request.EmployeeRequest;
import com.sharing.session.webflux.repository.EmployeeRepository;
import com.sharing.session.webflux.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Override
  public Mono<Employee> createEmployee(EmployeeRequest request) {
    return Mono.just(request).map(this::toEmployeeEntity).flatMap(employeeRepository::save)
        .doOnSuccess(employee -> log.info("Success create employee with id {}", employee.getId()));
  }

  @Override
  public Mono<List<Employee>> getAllEmployees() {
    return employeeRepository.findAll().collectList();
  }

  @Override
  public Mono<Employee> findEmployee(String id) {
    return employeeRepository.findById(id).switchIfEmpty(
        Mono.error(new DataNotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase(), "id")));
  }

  @Override
  public Mono<Employee> updateEmployee(String id, EmployeeRequest request) {
    return employeeRepository.findById(id)
        .switchIfEmpty(
            Mono.error(new DataNotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase(), "id")))
        .map(employee -> updateEmployeeData(employee, request)).flatMap(employeeRepository::save);
  }

  @Override
  public Mono<Void> deleteEmployee(String id) {
    return employeeRepository.findById(id)
        .switchIfEmpty(
            Mono.error(new DataNotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase(), "id")))
        .flatMap(employee -> employeeRepository.deleteById(id));
  }

  private Employee toEmployeeEntity(EmployeeRequest request) {
    Employee employee = new Employee();
    BeanUtils.copyProperties(request, employee);
    return employee;
  }

  private Employee updateEmployeeData(Employee employee, EmployeeRequest request) {
    BeanUtils.copyProperties(request, employee);
    return employee;
  }
}
