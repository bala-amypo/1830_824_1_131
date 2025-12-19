//ConflictCaseController.java                                                                                                                                                                                      package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ConflictCase;
import com.example.demo.service.ConflictCaseService;

    
    @PostMapping
     public ConflictCase createCase(@RequestBody ConflictCaseService conflictCaseService){
        return conflictCaseService.createCase(conflictCaseService);
     }
    @PutMapping("/{id}/status")
    public ConflictCase updateCaseStatus(@PathVariable Long caseId,@RequestParam String status){
        return conflictCaseService.updateCaseStatus(caseId,status);

    }
    

    @GetMapping("/person/{personId}")
    public List<ConflictCase>getCasesByPerson(@PathVariable Long personId) {
        return conflictCaseService.getCasesByPerson(personId);
    }

    @GetMapping("/{id}")
    public List<ConflictCase>getCasesById(@PathVariable Long id) {
        return conflictCaseService.getCasesById(id);
    }

    @GetMapping
    public List<ConflictCase>getAllCases(){
        return conflictCaseService.getAllCases();
    }
    
}