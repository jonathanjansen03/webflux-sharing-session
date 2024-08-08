package com.sharing.session.webflux.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

  private String name;
  private String role;
  private String department;
  private String email;
  private String phone;
  private long salary;
}
