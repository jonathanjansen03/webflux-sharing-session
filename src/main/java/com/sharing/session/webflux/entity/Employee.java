package com.sharing.session.webflux.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = Employee.COLLECTION)
public class Employee {

  public static final String COLLECTION = "employees";

  @Id
  private String id;
  private String name;
  private String role;
  private String department;
  private String email;
  private String phone;
  private long salary;
}
