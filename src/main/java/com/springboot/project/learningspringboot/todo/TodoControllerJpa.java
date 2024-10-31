package com.springboot.project.learningspringboot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
// /list-todo
	private TodoService todoService;
	
	private TodoRepository todoRepository;
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository=todoRepository;
	}
	@RequestMapping("list-todo")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedinUsername(model);		
		
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
		
	}
	

	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedinUsername(model);
		Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
         if(result.hasErrors()) {
        	 return "todo";
         }
		String userName = getLoggedinUsername(model);
		todoService.addTodo(userName,todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todo";		
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodos(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todo";
		
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
//		todoService.deleteById(id);
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";		
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
         if(result.hasErrors()) {
        	 return "todo";
         }
		String userName = getLoggedinUsername(model);
		todo.setUserName(userName);
		todoService.updateTodo(todo);
		return "redirect:list-todo";		
	}
	
	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
