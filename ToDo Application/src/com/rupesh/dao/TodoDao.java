package com.rupesh.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.rupesh.beans.Todo;

@Component
public class TodoDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public int save(Todo todo) {
		final String QUERY = "INSERT INTO todo_list(todo_title,todo_content,date) VALUES(:todoTitle,:todoContent,:todoDate)";
		MapSqlParameterSource inputMap = new MapSqlParameterSource();
		inputMap.addValue("todoTitle",todo.getTodoTitle());
		inputMap.addValue("todoContent",todo.getTodoContent());
		inputMap.addValue("todoDate",todo.getTodoDate());
		int rowEffect = namedParameterJdbcTemplate.update(QUERY,inputMap);
		return rowEffect;
	}

	public List<Todo> getAllTodo() {
		return namedParameterJdbcTemplate.query("SELECT * FROM todo_list",new TodoMapper());
	}

}
