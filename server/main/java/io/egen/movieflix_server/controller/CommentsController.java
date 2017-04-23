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

import io.egen.movieflix_server.entity.comments;
import io.egen.movieflix_server.service.CommentService;

@Controller
@ResponseBody
@RequestMapping(path = "comments")
public class CommentsController {

	@Autowired
	CommentService service;

	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<comments> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public comments findOne(@PathVariable("id") String cid){
		return service.findOne(cid);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public comments create(@RequestBody comments cm){
		return service.create(cm);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public comments update(@PathVariable("id") String cid, @RequestBody comments cm){
		return service.update(cid, cm);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String cid){
		service.delete(cid);
	}
}
