package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private JdbcTemplate jdbcTemplate;

//    Implementing Insertion Operation
    @Override
    public int insert(Student student) {
        String query="insert into student(studentId, studentName, city) values(?,?,?)";
        int result =this.jdbcTemplate.update(query, student.getStudentId(), student.getStudentName(), student.getCity());
        return result;
    }

//    Implementing Update Operation
    @Override
    public int update(Student student){
        String query = "update student set StudentName=? , city=? where studentId=?";
        int result = this.jdbcTemplate.update(query, student.getStudentName(), student.getCity(), student.getStudentId());
        return result;
    }

//Implementing Delete Operation
    @Override
    public int delete(int studentId) {
        String query="delete from student where studentId=?";
        int result =this.jdbcTemplate.update(query, studentId);
        return result;
    }

    @Override
    public Student getStudent(int studentId) {
//        Selecting Single Student Data
        String query = "select * from student where studentId=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student=this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }

    // Fetching Multiple student from database or student object
    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> allStudents= this.jdbcTemplate.query(query,rowMapper);
        return allStudents;
    }

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public StudentDaoImpl(){
        super();
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}