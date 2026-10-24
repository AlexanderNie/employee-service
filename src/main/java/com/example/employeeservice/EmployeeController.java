
package com.example.employeeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final List<Map<String, Object>> employees = List.of(
        Map.of("id", 1, "name", "Alex", "department", "IT"),
        Map.of("id", 2, "name", "Carrie", "department", "Finance")
    );

    @GetMapping
    public List<Map<String, Object>> getEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getEmployee(
            @PathVariable int id) {

        return employees.stream()
            .filter(employee ->
                employee.get("id").equals(id))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "Employee not found: " + id));
    }
}
