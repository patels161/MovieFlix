package io.egen.movieflix_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.egen.movieflix_server.entity.genre;
import io.egen.movieflix_server.service.GenreService;

@Controller
@ResponseBody
@RequestMapping(path = "genre")
public class GenreController {

	@Autowired
	GenreService service;

	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<genre> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{cat}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public genre findOne(@PathVariable("cat") String cat){
		return service.findOne(cat);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public genre create(@RequestBody genre gn){
		return service.create(gn);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{cat}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public genre update(@PathVariable("cat") String cat, @RequestBody genre gn){
		return service.update(cat, gn);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{cat}")
	public void delete(@PathVariable("cat") String cat){
		service.delete(cat);
	}
}
