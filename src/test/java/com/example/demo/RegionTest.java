package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.services.RegionService;
import com.example.demo.entities.Region;

@SpringBootTest
public class RegionTest {
    @Autowired
    private RegionService regionService;

    @Test
    public void Save() {
        // Arrange
        Boolean expected = true;

        Region region = new Region();
        region.setRegion_id(8);
        region.setName("Waktu Indonesia bagian Barat 2");

        // Act
        Boolean result = regionService.Save(region);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void Delete() {
        // Arrange
        Boolean expected = true;
        Integer region_id = 8;

        // Act
        Boolean result = regionService.Delete(region_id);

        // Assert
        assertEquals(expected, result);
    }
}
