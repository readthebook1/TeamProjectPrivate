package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import logic.ProjectService;

@Controller
public class ReserveController {
	@Autowired
	private ProjectService service;
	

}
