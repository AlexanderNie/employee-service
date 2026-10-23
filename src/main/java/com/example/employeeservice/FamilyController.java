
package com.example.employeeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/family")
public class FamilyController {

    private final List<Map<String, Object>> familyMembers = List.of(
        Map.of("id", 1, "name", "Alex", "relationship", "Father","secret", "Alex likes fishing"),
        Map.of("id", 2, "name", "Carrie", "relationship", "Mother","secret", "Carrie loves sushi"),
        Map.of("id", 3, "name", "Wanzhen", "relationship", "Daughter","secret", "Wanzhen enjoys outdoor activities")
    );

    @GetMapping
    public List<Map<String, Object>> getFamilyMembers() {
        return familyMembers;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getFamilyMember(
            @PathVariable int id) {

        return familyMembers.stream()
            .filter(member ->
                member.get("id").equals(id))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "Family member not found: " + id));
    }


  @GetMapping("/secret/{name}")
public String getFamilyMemberSecret(@PathVariable String name) {

    return familyMembers.stream()
        .filter(member ->
            member.get("name").toString().equalsIgnoreCase(name))
        .map(member -> member.get("secret").toString())
        .findFirst()
        .orElseThrow(() ->
            new IllegalArgumentException(
                "Family member not found: " + name));
}
}
