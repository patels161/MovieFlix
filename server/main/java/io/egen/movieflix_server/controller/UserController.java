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

	import io.egen.movieflix_server.entity.users;
	import io.egen.movieflix_server.service.UserService;

	
	@Controller
	@ResponseBody
	@RequestMapping(path = "users")
	public class UserController {
		
		@Autowired
		UserService service;

		@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<users> findAll(){
			return service.findAll();
		}
		
		@RequestMapping(method=RequestMethod.GET, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public users findOne(@PathVariable("id") String uid){
			return service.findOne(uid);
		}
		
		@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public users create(@RequestBody users us){
			return service.create(us);
		}
		
		@RequestMapping(method=RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public users update(@PathVariable("id") String uid, @RequestBody users us){
			return service.update(uid, us);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, path="{id}")
		public void delete(@PathVariable("id") String uid){
			service.delete(uid);
		}
}
