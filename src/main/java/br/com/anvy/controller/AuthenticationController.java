package br.com.anvy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.anvy.entity.User;
import br.com.anvy.security.TokenGenerate;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
@RestController
public class AuthenticationController {

	@PostMapping(path="/authentication", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TokenGenerate> logon(@RequestBody User user) {
		if("admin".equals(user.getUsername())) {
			
			TokenGenerate tokenGenerate = new TokenGenerate();
			tokenGenerate.setLogin(user.getUsername());
			tokenGenerate.generate();
			
			return new ResponseEntity<TokenGenerate>(tokenGenerate, HttpStatus.OK);
		} else {
			return new ResponseEntity<TokenGenerate>(HttpStatus.OK);
		}
		
	}
}
