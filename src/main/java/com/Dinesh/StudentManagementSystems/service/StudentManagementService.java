package com.Dinesh.StudentManagementSystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dinesh.StudentManagementSystems.model.StudentRecord;
import com.Dinesh.StudentManagementSystems.repository.StudentManagementRepo;

@Service
public class StudentManagementService {

	
	@Autowired
	private StudentManagementRepo studentManagementRepo;
	
	
	public Optional<StudentRecord> getStudentRecord(int rollNo){
		try {
			return studentManagementRepo.getStudentRecord(rollNo);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<StudentRecord> getStudentRecords(){
		try {
			return studentManagementRepo.getStudentRecords();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean deleteStudentRecord(int rollNo) {
		try {
			
			return studentManagementRepo.deleteStudentRecord(rollNo);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean editStudentRecord(StudentRecord studentRecord) {
		try {
			
			return studentManagementRepo.editStudentRecord(studentRecord);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addStudentRecord(StudentRecord studentRecord) {
		try {
			
			studentManagementRepo.addStudentRecord(studentRecord);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
