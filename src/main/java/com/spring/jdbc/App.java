package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Started..." );
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcconfig.xml");
        StudentDao studentDao  = context.getBean("studentDao", StudentDao.class);
        Student student = new Student();
//        Doing Insertion Operation

//        student.setStudentId(206);
//        student.setStudentName("Kumar Sanu");
//        student.setCity("Banglore");
//        int result =studentDao.insert(student);
//        System.out.println("Number of inserted Data: "+result);

//        Doing Updation operation

//        student.setStudentId(209);
//        student.setStudentName("Pushpa Raj");
//        student.setCity("Hyderabad");
//        int result =studentDao.update(student);
//        System.out.println("Number of data updated: "+result);


//        Doing Delete Operation
//        int result =studentDao.delete(166);
//        System.out.println("Number of row deleted: "+result);

//        Fetching Single Data (Student Object) using rowMapper
//        Student student = studentDao.getStudent(209);
//        System.out.println(student);

// Fetching Multiple Students from database using queryMapper statement

        List<Student> students = studentDao.getAllStudent();
        System.out.println(students);
    }
}
