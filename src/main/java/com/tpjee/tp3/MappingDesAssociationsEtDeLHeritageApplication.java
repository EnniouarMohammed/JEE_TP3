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
			Course course2 = new Course();
			Professor professor = new Professor();
			Professor professor2 = new Professor();
			Session session = new Session();
			Session session2 = new Session();
			Student student = new Student();
			Student student2 = new Student();

			//Course
			course.setTitre("JEE");
			course.setDescription("Java Spring Data JPA");

			course2.setTitre("DevOps");
			course2.setDescription("Git - Docker - Jenkins");

			//Professor
			professor.setName("Hirchoua Badr");
			professor.setD_affectation("09/02/24");

			professor2.setName("Mariam CHERRABI");
			professor2.setD_affectation("07/02/24");

			//Session
			session.setDate("16/02/24");
			session.setStartTime(session.getDate()+" 08:30");
			session.setEndTime(session.getDate()+ " 12:45");

			session2.setDate("14/02/24");
			session2.setStartTime(session2.getDate()+" 14:15");
			session2.setEndTime(session2.getDate()+ " 18:15");

			//Student
			student.setName("Enniouar Mohammed");
			student.setMatricule("123789");

			student2.setName("Tyson Mike");
			student2.setMatricule("159753");

			// Associations
			course.setCourseGivenByProfessor(professor);
			course2.setCourseGivenByProfessor(professor2);
			professor.setCourseToGive(course);
			professor2.setCourseToGive(course2);
			session.setSessionCourse(course);
			session2.setSessionCourse(course2);
			session.getStudentsList().add(student);
			session2.getStudentsList().add(student2);
			student.getSessionList().add(session);
			student2.getSessionList().add(session2);

			// Saving entities
			courseRepository.save(course);
			professorRepository.save(professor);
			sessionRepository.save(session);
			studentRepository.save(student);

			courseRepository.save(course2);
			professorRepository.save(professor2);
			sessionRepository.save(session2);
			studentRepository.save(student2);

			//READ - UPDATE - DELETE (Course)
			Course courseById = courseRepository.findById(1).get();
			System.out.println(courseById);
			courseById.setTitre("Java JEE");
			courseRepository.save(courseById);

			//courseRepository.deleteById(2);

			//READ - UPDATE - DELETE (Professor)
			Professor professorById = professorRepository.findById(2).get();
			System.out.println(professorById);
			professorById.setName("CHERRABI Mariam");
			professorRepository.save(professorById);

			//professorRepository.deleteById(2);

			//READ - UPDATE - DELETE (Session)
			Session sessioneById = sessionRepository.findById(2).get();
			System.out.println(sessioneById);
			sessioneById.setDate("08/02/24");
			sessionRepository.save(sessioneById);

			//courseRepository.deleteById(2);

			//READ - UPDATE - DELETE (Student)
			Student studentById = studentRepository.findById(2).get();
			System.out.println(studentById);
			studentById.setMatricule("999");
			studentRepository.save(studentById);

			//studentRepository.deleteById(2);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
