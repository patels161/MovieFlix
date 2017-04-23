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

	import io.egen.movieflix_server.entity.movies;
	import io.egen.movieflix_server.service.moviesService;

	
	@Controller
	@ResponseBody
	@RequestMapping(path = "movies")
	public class MoviesController {
		
		@Autowired
		moviesService service;

		@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<movies> findAll(){
			return service.findAll();
		}
		
		@RequestMapping(method=RequestMethod.GET, path="{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public movies findOne(@PathVariable("title") String title){
			return service.findOne(title);
		}
		
		@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public movies create(@RequestBody movies mv){
			return service.create(mv);
		}
		
		@RequestMapping(method=RequestMethod.PUT, path="{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public movies update(@PathVariable("title") String title, @RequestBody movies mv){
			return service.update(title, mv);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, path="{title}")
		public void delete(@PathVariable("title") String title){
			service.delete(title);
		}
	}

