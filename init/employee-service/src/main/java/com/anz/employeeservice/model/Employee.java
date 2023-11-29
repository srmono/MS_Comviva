package com.anz.employeeservice.model;

public record Employee(Long id, Long departmentId, String Name, int age, String position) {
}
