package com.example.demo.hanteo1;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {

	private int number;

	private Category category;

	private List<Post> postList;
}
