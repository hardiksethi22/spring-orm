package com.hardiksethi.spring_orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hardiksethi.spring_orm.dao.studentDao;
import com.hardiksethi.spring_orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext context;
   
	public static void main( String[] args )
    {
	   Student student;
	   int uid;
	   String uName,uCity;
       context = new ClassPathXmlApplicationContext("com/hardiksethi/spring_orm/config.xml");
       studentDao stu =  context.getBean("studentdao",studentDao.class);
		
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       boolean go = true;
       while(go) {
       System.out.println("**************** Welcome to Student Control Centre *****************");
       System.out.println("Press 1 : Add a new Student");
       System.out.println("Press 2 : Display all the Students");
       System.out.println("Press 3 : Get details of single Student");
       System.out.println("Press 4 : Delete a single student details");
       System.out.println("Press 5 : Update the details");
       System.out.println("Press 6 : Exit");
       
       try { 
    	   int input = Integer.parseInt(br.readLine());
    	   switch (input) {
		case 1:
			
			System.out.println("Enter Student Id: ");
			uid = Integer.parseInt(br.readLine());
			
			System.out.println("Enter Student Name: ");
			uName = br.readLine();
			
			System.out.println("Enter Student City: ");
			uCity = br.readLine();
			
			student = new Student(uid, uName, uCity);
			int i = stu.insert(student);
			
			System.out.println("Student inserted into database " + i);
			
			break;
		case 2:
			System.out.println("fetching all the Student Details ");
			List<Student> listStudents = stu.getAllStudents();
			System.out.println("***************************************");
			System.out.println("Student Id   Student Name  Student City");
			for(Student s : listStudents) {
				System.out.println(s.getStudentId() +"           "+  s.getStudentName()+"           " + s.getStudentCity());
				System.out.println("-----------------------------------------");
			}
			break;
		case 3:
			System.out.println("Enter Student Id for which you want details ");
			uid = Integer.parseInt(br.readLine());
			student = stu.getStudent(uid);
			System.out.println("***************************************");
			System.out.println("Student Id   Student Name  Student City");
			System.out.println(student.getStudentId() +"           "+  student.getStudentName()+"           " + student.getStudentCity());
			System.out.println("-----------------------------------------");
			break;
		case 4:
			System.out.println("Enter Student Id you want to delete ");
			uid = Integer.parseInt(br.readLine());
			stu.deleteStudent(uid);
			break;
		case 5:
			System.out.println("Enter Student Id you want to update");
			uid = Integer.parseInt(br.readLine());
			
			System.out.println("Enter Student Name: ");
			uName = br.readLine();
			
			System.out.println("Enter Student City: ");
			uCity = br.readLine();
			
			student = new Student(uid, uName, uCity);
			stu.updateStudent(student);
			break;
		case 6:
			go = false; 
			break;
		
    	   }
       }
       
       catch(Exception e) {
    	   System.out.println("Invalid input try with another one" + e.getMessage());
       }
       }
       System.out.println("Thanks for using Student Control Centre.");
       /*
		 * Student student = new Student(111,"hhh","yyuhy"); int i =
		 * stu.insert(student); System.out.println(i);
		 */
    }
}
