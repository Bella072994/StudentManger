package com.student.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Student;
import com.student.mapper.StudentMapper;

public class StudentDao {
private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		// TODO 自動生成されたメソッド・スタブ
this.jdbcTemplate = jdbcTemplate;
	}
	public List<Student> queryAll() {
		String sql = "select id,name,birthday,age";
		return jdbcTemplate.query(sql, new StudentMapper());
	}
	public List<Student> queryByName(String name) {
		String sql = "select id,name,birthday,age,score  from student where name like '%" + name + "%'";
                   
		return jdbcTemplate.query(sql, new StudentMapper());
	}
	public boolean addStu(Student student) {
		String sql = "insert into student(id,name,birthday,age,score) values(0,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(),
						student.getScore() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE }) == 1;
	}
	public boolean deleteStu(Integer id) {

		String sql = "delete from student where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}
	public boolean updateStu(Student student) {

		String sql = "update student set name=? ,age=?,birthday = ? ,score = ? where id = ?";
		Object stuObj[] = new Object[] {student.getName(), student.getAge(), student.getBirthday(),
				student.getScore(), student.getId() };

		return jdbcTemplate.update(sql, stuObj) == 1;
	}
}
