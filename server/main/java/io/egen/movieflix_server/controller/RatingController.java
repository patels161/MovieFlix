package io.egen.movieflix_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix_server.entity.ratings;
import io.egen.movieflix_server.service.RatingService;

@RestController
@RequestMapping(path = "ratings")
public class RatingController {

	@Autowired
	RatingService service;

	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ratings> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ratings findOne(@PathVariable("title") String title){
		return service.findOne(title);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ratings create(@PathVariable("title") String title, @RequestBody ratings rt){
		return service.create(title, rt);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ratings update(@PathVariable("title") String title, @RequestBody ratings rt){
		return service.update(title, rt);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("title") String title){
		service.delete(title);
	}
}
