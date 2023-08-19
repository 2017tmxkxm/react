package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("todo")
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	// testTodo 메서드 작성하기
	@GetMapping("/testTodoResponseEntity")
	public ResponseEntity<?> testTodoResponseEntity() {
		TodoDTO response = TodoDTO.builder()
							.id("1")
							.title("testTodo ResponseEntity 리턴")
							.done(true)
							.build();
		
		//return ResponseEntity.ok().body(response);
		return ResponseEntity.badRequest().body(response);
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> testTodo() {
		String str = service.testService();
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
}
