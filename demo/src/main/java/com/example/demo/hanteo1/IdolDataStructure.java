package com.example.demo.hanteo1;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class IdolDataStructure {

	private Category rootCategory;

	private ObjectMapper objectMapper = new ObjectMapper();

	public IdolDataStructure() {
		buildCategories();
	}

	private void buildCategories() {
		Category anonymousBoard = new Category("36", "익명게시판", List.of());

		Category boyCategory = new Category(
			"11", "남자",
			List.of(
				new Category("21", "엑소",
					List.of(
						new Category("31", "공지사항", List.of()),
						new Category("32", "첸", List.of()),
						new Category("33", "백현", List.of()),
						new Category("34", "시우민", List.of()))
				),
				new Category("22", "방탄소년단",
					List.of(
						new Category("35", "공지사항", List.of()),
						anonymousBoard,
						new Category("37", "뷔", List.of()))
				)));

		Category girlCategory = new Category(
			"21", "여자",
			List.of(
				new Category("23", "블랙핑크", List.of(
					new Category("38", "공지사항", List.of()),
					anonymousBoard,
					new Category("39", "로제", List.of()))
				)
			)
		);

		rootCategory = new Category("00", "root", List.of(boyCategory, girlCategory)); // 요구사항 구현 편의를 위한 root category
	}

	public void printJSonString() {
		try {
			System.out.println(objectMapper.writeValueAsString(rootCategory));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private List<Category> searchChildCategoryByName(String categoryName, List<Category> categoryList) {
		for (Category category : categoryList) {
			if (Objects.equals(category.getName(), categoryName)) {
				return category.getChildCategories();
			}

			List<Category> childCategories = searchChildCategoryByName(categoryName, category.getChildCategories());
			if (!childCategories.isEmpty()) {
				return childCategories;
			}
		}

		return List.of();
	}

	public List<Category> searchChildCategoryByName(String categoryName) {
		return searchChildCategoryByName(categoryName, List.of(rootCategory));
	}

	private List<Category> searchChildCategoryById(String categoryId, List<Category> categoryList) {
		for (Category category : categoryList) {
			if (Objects.equals(category.getId(), categoryId)) {
				return category.getChildCategories();
			}

			List<Category> childCategories = searchChildCategoryById(categoryId, category.getChildCategories());
			if (!childCategories.isEmpty()) {
				return childCategories;
			}
		}

		return List.of();
	}

	public List<Category> searchChildCategoryById(String categoryId) {
		return searchChildCategoryById(categoryId, List.of(rootCategory));
	}
}
