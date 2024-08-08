package com.sharing.session.webflux.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharing.session.webflux.entity.Employee;
import com.sharing.session.webflux.helper.ResponseHelper;
import com.sharing.session.webflux.model.request.EmployeeRequest;
import com.sharing.session.webflux.model.response.WebResponse;
import com.sharing.session.webflux.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(EmployeeController.EMPLOYEE_API_PATH)
@RequiredArgsConstructor
public class EmployeeController {

  public static final String EMPLOYEE_API_PATH = "/api/employees";
  private static final String ID_PATH = "/{id}";

  private final EmployeeService employeeService;

  @PostMapping
  public Mono<WebResponse<Employee>> createEmployee(@RequestBody EmployeeRequest employee) {
    return employeeService.createEmployee(employee).map(ResponseHelper::ok);
  }

  @GetMapping
  public Mono<WebResponse<List<Employee>>> getAllEmployees() {
    return employeeService.getAllEmployees().map(ResponseHelper::ok);
  }

  @GetMapping(ID_PATH)
  public Mono<WebResponse<Employee>> findEmployee(@PathVariable String id) {
    return employeeService.findEmployee(id).map(ResponseHelper::ok);
  }

  @PutMapping(ID_PATH)
  public Mono<WebResponse<Employee>> updateEmployee(@PathVariable String id,
      @RequestBody EmployeeRequest employee) {
    return employeeService.updateEmployee(id, employee).map(ResponseHelper::ok);
  }

  @DeleteMapping(ID_PATH)
  public Mono<WebResponse<Void>> deleteEmployee(@PathVariable String id) {
    return employeeService.deleteEmployee(id).thenReturn(ResponseHelper.ok());
  }
}
