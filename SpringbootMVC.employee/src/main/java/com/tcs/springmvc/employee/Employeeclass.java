package com.tcs.springmvc.employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeeclass {
    
    private int empId;
    private String empName;
    private double empSalary;
    private String empDepartment;
    private String empDoj;

}
