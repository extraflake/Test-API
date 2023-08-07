package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Department;
import com.example.demo.entities.Region;
import com.example.demo.services.DepartmentService;
import com.example.demo.services.RegionService;

@SpringBootTest
public class DepartmentTest {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RegionService regionService;

    @Test
    public void Save() {
        Boolean expected = true;

        Region region = regionService.Get(7);

        Department department = new Department();
        department.setDepartment_id(12);
        department.setName("Finance 2");
        department.setRegion(region);

        Boolean result = departmentService.Save(department);

        assertEquals(expected, result);
    }

    @Test
    public void Delete() {
        Boolean expected = true;
        Integer department_id = 12;

        Boolean result = departmentService.Delete(department_id);

        assertEquals(expected, result);
    }
}
