package com.Dinesh.StudentManagementSystems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Dinesh.StudentManagementSystems.model.StudentRecord;
import com.Dinesh.StudentManagementSystems.service.StudentManagementService;

@RestController
public class StudentManagementController {

	@Autowired
	private StudentManagementService studentManagementService;
	
	@GetMapping("studentRecord/{rollNo}")
	public ResponseEntity getStudentRecord(@PathVariable int rollNo) {
		try {
			Optional<StudentRecord> result =studentManagementService.getStudentRecord(rollNo);
			if(result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records found for rollNo "+rollNo);
			}
			return ResponseEntity.status(HttpStatus.OK).body(result.get());
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	
	@GetMapping("studentRecords")
	public ResponseEntity getStudentRecords() {
		try {
			List<StudentRecord> result =studentManagementService.getStudentRecords();
			if(result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records found");
			}
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	
	@PutMapping("studentRecord/add")
	public ResponseEntity addStudentRecord(@RequestBody StudentRecord studentRecord) {
		try {
			studentManagementService.addStudentRecord(studentRecord);
			return ResponseEntity.status(HttpStatus.CREATED).body("Student Records added successfully");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	
	@PostMapping("studentRecord/edit/{rollNo}")
	public ResponseEntity editStudentRecord(@PathVariable int rollNo,@RequestBody StudentRecord studentRecord) {
		try {
			boolean result = studentManagementService.editStudentRecord(studentRecord);
			if(result) {
				return ResponseEntity.status(HttpStatus.OK).body("Student record updated successfully");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found for rollNo "+rollNo);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	
	@DeleteMapping("studentRecord/delete/{rollNo}")
	public ResponseEntity deleteStudentRecord(@PathVariable int rollNo) {
		try {
			boolean result = studentManagementService.deleteStudentRecord(rollNo);
			if(result) {
				return ResponseEntity.status(HttpStatus.OK).body("Student record deleted successfully");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student record not found for rollNo "+rollNo);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
}
