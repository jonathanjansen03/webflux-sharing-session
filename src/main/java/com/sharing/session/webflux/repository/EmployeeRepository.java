package com.sharing.session.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sharing.session.webflux.entity.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
