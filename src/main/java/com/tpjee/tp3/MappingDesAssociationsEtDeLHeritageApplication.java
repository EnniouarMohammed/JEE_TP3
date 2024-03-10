package com.tpjee.tp3;

import com.tpjee.tp3.dao.entities.Course;
import com.tpjee.tp3.dao.entities.Professor;
import com.tpjee.tp3.dao.entities.Session;
import com.tpjee.tp3.dao.entities.Student;
import com.tpjee.tp3.dao.repositories.CourseRepository;
import com.tpjee.tp3.dao.repositories.ProfessorRepository;
import com.tpjee.tp3.dao.repositories.SessionRepository;
import com.tpjee.tp3.dao.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class MappingDesAssociationsEtDeLHeritageApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private ProfessorRepository professorRepository;

	public static void main(String[] args) {
		SpringApplication.run(MappingDesAssociationsEtDeLHeritageApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		try {
			//Creating Objects
			Course course = new Course();
			Professor professor = new Professor();
			Session session = new Session();
			Student student = new Student();

			//Course
			course.setTitre("JEE");
			course.setDescription("Java Spring Data JPA");

			//Professor
			professor.setName("Hirchoua Badr");
			professor.setD_affectation("01/09/24");

			//Session
			session.setDate("09/04/24");
			session.setStartTime(session.getDate()+" 08:30");
			session.setEndTime(session.getDate()+ " 12:45");

			//Student
			student.setName("Enniouar Mohammed");
			student.setMatricule("123789");

			// Associations
			course.setCourseGivenByProfessor(professor);
			professor.setCourseToGive(course);
			session.setSessionCourse(course);
			session.getStudentsList().add(student);
			student.getSessionList().add(session);

			// Saving entities
			courseRepository.save(course);
			professorRepository.save(professor);
			sessionRepository.save(session);
			studentRepository.save(student);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
