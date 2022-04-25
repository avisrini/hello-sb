package com.avisrini.hellosb.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	public List<Student> getStudents() {
		return List.of(
					new Student(1L, "Jack", "jack@b.c", LocalDate.of(2000, 6, 10), 21),
					new Student(2L, "Jones", "jones@b.c", LocalDate.of(2001, 5, 13), 20)
				);
	}
}
