package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 모델, 엔티티 합쳐서 구현
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class TodoEntity {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;			// 이 오브젝트의 아이디
	private String userId; 		// 이 오브젝트를 생성한 유저의 아이디
	private String title;		// Todo 타이틀 예) 공부하기
	private boolean done;	// true - todo를 완료한 경우 (checked)
}
