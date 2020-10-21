package com.rupesh.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rupesh.beans.Todo;
import com.rupesh.dao.TodoDao;

@Controller
public class MyController {

	@Autowired
	private TodoDao todoDao;

	@RequestMapping("/home")
	public String home(Model model) {
		String heading = "Welcome to TODO Manager";
		model.addAttribute("heading", heading);

		model.addAttribute("page", "home");
		List<Todo> list = this.todoDao.getAllTodo();
		model.addAttribute("todos",list);
		return "home";
	}

	@RequestMapping("/add")
	public String addTodo(Model model) {

		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		model.addAttribute("page", "add");
		return "home";
	}

	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo todo, Model model) {

		todo.setTodoDate(new Date());
		todoDao.save(todo);

		model.addAttribute("message", "Successfully added.");
		return "home";
	}
}
