package com.rupesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rupesh.beans.Todo;

public class TodoMapper implements  RowMapper<Todo> {

	@Override
	public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Todo todo = new Todo();
		todo.setTodoTitle(rs.getString("todo_title"));
		todo.setTodoContent(rs.getString("todo_content"));
		return todo;
	}

}
