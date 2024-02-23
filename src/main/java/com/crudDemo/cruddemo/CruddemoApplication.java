package com.crudDemo.cruddemo;

import com.crudDemo.cruddemo.dao.entity.Student;
import com.crudDemo.cruddemo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentService studentDAO){
		return runner->{
//			createStudent(studentDAO);
			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);
//			getStudentList(studentDAO);

//			getStudentByLastName(studentDAO);
			updateStudent(studentDAO);

			// deleteStudent(studentDAO);
			//deletAllStudents(studentDAO);
		};
	}

	private void deletAllStudents(StudentService studentDAO) {
		int num=studentDAO.deleteAll();
		System.out.println(num);
	}

	private void deleteStudent(StudentService studentDAO) {
		int studentId=1;
		studentDAO.delete(1);

		System.out.println("Delete Done:");
	}

	private void updateStudent(StudentService studentDAO) {
		Student s=studentDAO.findById(6);
		s.setFirstName("Monu");
		studentDAO.update(s);

		System.out.println(s);
	}

	private void getStudentByLastName(StudentService studentDAO) {
		List<Student> students=studentDAO.dindByLastName("Mishra");

		for(Student s:students){
			System.out.println(s);
		}

	}

	private void getStudentList(StudentService studentDAO) {
		List<Student> students=studentDAO.findAll();

		for(Student s:students){
			System.out.println(s);
		}

	}

	private void readStudent(StudentService studentDAO) {
		Student s=studentDAO.findById(1);
		System.out.println(s.toString());
	}

	private void createMultipleStudent(StudentService studentDAO) {
		System.out.println("Creating Multiple Student Object: ");
		Student st=new Student("Vaibhav","Mishra","mishravaibhav517@gmail.com");
		Student st1=new Student("Mary","Smith","xx@yy.com");
		Student st2=new Student("John","Smith","xx@yy.com");

		System.out.println("Saving Objects: ");

		studentDAO.save(st);
		studentDAO.save(st1);
		studentDAO.save(st2);

	}

	private void createStudent(StudentService studentDAO) {

		System.out.println("Creating New Student Object: ");

		Student st=new Student("Gaurav","Mishra","mishragaurav517@gmail.com");

		System.out.println("Saving Object: ");

		studentDAO.save(st);

		System.out.println("Saved Student.Generated ID:  "+ st.getId());
	}

}
