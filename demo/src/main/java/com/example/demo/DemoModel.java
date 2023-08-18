package com.example.demo;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
// lombok 설치 테스트 
public class DemoModel {

	@NonNull
	private String id;
}
