package com.example.demo.hanteo1;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

	private String id;

	private String name;

	private List<Category> childCategories;
}
