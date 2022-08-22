package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto cat = categoryService.createCategory(categoryDto);
		return  new ResponseEntity<CategoryDto>(cat,HttpStatus.CREATED);
		
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer id){
		CategoryDto cat = categoryService.updateCategory(categoryDto,id);
		return  new ResponseEntity<CategoryDto>(cat,HttpStatus.OK);
		
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id){
		this.categoryService.deleteCategory(id);
		return  new ResponseEntity<ApiResponse>(new ApiResponse("Deleted",true),
				HttpStatus.OK);
		
	}
	
	//get
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer id){
		CategoryDto cat=this.categoryService.getCategory(id);
		return  new ResponseEntity<CategoryDto>(cat,HttpStatus.OK);
		
	}
	
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> cat=this.categoryService.getAllCategory();
		return  new ResponseEntity<List<CategoryDto>>(cat,HttpStatus.OK);
		
	}
	
}
