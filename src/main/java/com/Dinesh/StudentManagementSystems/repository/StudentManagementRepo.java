package com.Dinesh.StudentManagementSystems.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Dinesh.StudentManagementSystems.model.StudentRecord;

@Repository
public class StudentManagementRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addStudentRecord(StudentRecord studentRecord) {
		jdbcTemplate.update("Insert into students(roll_no,name,contact_no) values (?,?,?)",
				new Object[] { studentRecord.getRollNo(), studentRecord.getName(), studentRecord.getContactNo() });
	}

	public Optional<StudentRecord> getStudentRecord(int rollNo) {
		List<StudentRecord> studentRecords = jdbcTemplate.query("select * from students where roll_no=?",
				new Object[] { rollNo }, new RowMapper() {
					@Override
					public StudentRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
						StudentRecord studentRecord = new StudentRecord();
						studentRecord.setRollNo(rs.getInt("roll_no"));
						studentRecord.setName(rs.getString("name"));
						studentRecord.setContactNo(rs.getInt("contact_no"));
						return studentRecord;
					}
				});
		if (studentRecords.isEmpty()) {
			return Optional.empty();
		}
		return Optional.ofNullable(studentRecords.get(0));
	}

	public List<StudentRecord> getStudentRecords() {
		List<StudentRecord> studentRecords = jdbcTemplate.query("select * from students", new RowMapper() {
			@Override
			public StudentRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentRecord studentRecord = new StudentRecord();
				studentRecord.setRollNo(rs.getInt("roll_no"));
				studentRecord.setName(rs.getString("name"));
				studentRecord.setContactNo(rs.getInt("contact_no"));
				return studentRecord;
			}
		});
		return studentRecords;
	}

	public boolean editStudentRecord(StudentRecord studentRecord) {
		int num = jdbcTemplate.update("update students set name=?,contact_no=? where roll_no=?",
				new Object[] { studentRecord.getName(), studentRecord.getContactNo(), studentRecord.getRollNo() });
		return num>0?true:false;
	}
	
	public boolean deleteStudentRecord(int rollNo) {
		int num = jdbcTemplate.update("delete from students where roll_no=?",
				new Object[] {rollNo });
		return num>0?true:false;
	}
}
