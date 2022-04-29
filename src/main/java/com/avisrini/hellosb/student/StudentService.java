package com.avisrini.hellosb.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
		
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email exists already");
		}
		
		studentRepository.save(student);
	}

	public void removeStudent(Long id) {
		Optional<Student> studentOptional = studentRepository.findStudentById(id);
		
		if (studentOptional.isPresent()) {
			studentRepository.deleteById(id);
		}
	}
}
