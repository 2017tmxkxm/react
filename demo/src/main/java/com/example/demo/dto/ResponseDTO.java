package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
// TodoDTO 뿐만 아니라 다른 모델의 DTO도 사용할 수 있게 Generic을 이용
public class ResponseDTO<T> {
	private String error;
	private List<T> data;
}
