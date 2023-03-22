package com.board.result;

import java.util.List;

import com.board.question.QuestionDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

	private int count;
	private T data;
	
}
