package com.ecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Services.CategoryService;
import com.ecom.payload.ApiResponse;
import com.ecom.payload.CategoryDto;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService catService;
//	private CategoryDto create;

	@PostMapping("/create")
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto catDto) {
		CategoryDto create = catService.create(catDto);
		return new ResponseEntity<CategoryDto>(create, HttpStatus.CREATED);
	}

	@PostMapping("/update/{catid}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto catDto, @PathVariable int catid) {
		System.out.println(catid);
		CategoryDto update = catService.update(catDto, catid);
		return new ResponseEntity<CategoryDto>(update, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{catId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable int catId) {
		this.catService.delete(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Delete Successfully", true), HttpStatus.OK);
	}

	@GetMapping("/getByid/{catId}")
	public ResponseEntity<CategoryDto> getByid(@PathVariable int catId) {
		CategoryDto getbyId = catService.getbyId(catId);
		return new ResponseEntity<CategoryDto>(getbyId, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDto>> getAll() {
		List<CategoryDto> all = catService.getAll();
		if(all.size()>0)			
			return new ResponseEntity<List<CategoryDto>>(all, HttpStatus.OK);
		else
			return new ResponseEntity<List<CategoryDto>>(all, HttpStatus.NO_CONTENT);
	}

}
