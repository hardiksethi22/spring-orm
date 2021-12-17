package com.hardiksethi.spring_orm.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.hardiksethi.spring_orm.entities.Student;

public class studentDao {
	private HibernateTemplate hibernateTemp = new HibernateTemplate();
	
	public HibernateTemplate getHibernateTemp() {
		return hibernateTemp;
	}

	public void setHibernateTemp(HibernateTemplate hibernateTemp) {
		this.hibernateTemp = hibernateTemp;
	}
	
	@Transactional
	public int insert(Student student) {
		Integer re = (Integer) this.hibernateTemp.save(student);
		return re;
	}
	
	//GET ONE STUDENT DETAILS
	public Student getStudent(int studentId) {
		return this.hibernateTemp.get(Student.class, studentId);
	}
	
	//GET ALL STUDENTS DETAILS
	public List<Student> getAllStudents() {
		return this.hibernateTemp.loadAll(Student.class);
	}
	
	//DELETE THE STUDENT
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemp.get(Student.class, studentId);
		this.hibernateTemp.delete(student);
		System.out.println("Deleted student " + student);
	}
	
	//UPDATE THE STUDENT DETAILS
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemp.update(student);
		System.out.println("Update Student Details " + student);
	}
}