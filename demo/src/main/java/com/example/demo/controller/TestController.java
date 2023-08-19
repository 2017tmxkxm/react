package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;

@RestController
@RequestMapping("test")
public class TestController {
	
	@GetMapping
	public String testController() {
		return "Hello World!";
	}
	
	@RequestMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "Hello World! testGetMapping!";
	}
	
	// @PathVariable
	@GetMapping("/{id}")
	public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
		return "Hello World! + ID " + id;
	}
	
	// @RequestParam
	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required = false) int id) {
		return "Hello World! + ID " + id;
	}
	
	// @RequestBody
	// json 형식으로 받아서 Dto로 변환
	@ResponseBody
	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello World! ID " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
	}
	
	// ResponseDTO 반환 - data
	@GetMapping("/testResponseBody")
	public ResponseDTO<String> testControllerResponseBody(){
		List<String> list = new ArrayList<>();
		list.add("Hello World! I'm ResponseDTO");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return response;
	}
	
	// ResponseDTO 반환 - error
	@GetMapping("/testResponseBody2")
	public ResponseDTO<String> testControllerResponseBody2(){
		ResponseDTO<String> response = ResponseDTO.<String>builder().error("에러 발생 확인").build();
		return response;
	}
	
	// ResponseDTO 반환 - data, error
	@GetMapping("/testResponseBody3")
	public ResponseDTO<String> testControllerResponseBody3(){
		List<String> list = new ArrayList<>();
		list.add("Hello World! I'm ResponseDTO");
		ResponseDTO<String> response = ResponseDTO.<String>builder()
										.error("에러 발생 확인")
										.data(list)
										.build();
		return response;
	}
	
	// ResponseEntity 반환  - ResponseDTO
	@GetMapping("/testResponseEntity")
	public ResponseEntity<?> testControllerResponseEntity() {
		List<String> list = new ArrayList<>();
		list.add("Hello World! I'm ResponseEntity. And you got 400!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		// http status를 400으로 설정
		//return ResponseEntity.badRequest().body(response);
		return ResponseEntity.ok().body(response);
	}
	
}
