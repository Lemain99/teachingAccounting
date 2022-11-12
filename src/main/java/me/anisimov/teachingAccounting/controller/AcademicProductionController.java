package me.anisimov.teachingAccounting.controller;

import me.anisimov.teachingAccounting.domain.AcademicProduction;
import me.anisimov.teachingAccounting.dto.AcademicProductionDto;
import me.anisimov.teachingAccounting.service.AcademicProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production")
public class AcademicProductionController {

    @Autowired
    private AcademicProductionService academicProductionService;

    @PostMapping("/create")
    public AcademicProductionDto create(@RequestBody AcademicProductionDto academicProductionDto) {
        return academicProductionService.createAcademicProduction(academicProductionDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        academicProductionService.deleteAcademicProduction(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AcademicProduction academicProduction) {
        academicProductionService.updateAcademicProduction(academicProduction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public AcademicProduction getById(Long id) {
        return academicProductionService.getById(id);
    }

    @GetMapping("/all")
    public List<AcademicProduction> getAll() {
        return academicProductionService.getAll();
    }
}