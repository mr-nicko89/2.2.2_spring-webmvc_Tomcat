package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	@GetMapping(value = "/hello")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}
	@GetMapping(value = "/goodbye")
	public String printGoodBay(@RequestParam(value = "name",required = false) String name,
							   @RequestParam(value = "surname", required = false) String surname, Model model){
//		System.out.println("Hello, "+ name + " " + surname);
		model.addAttribute("message", "Hello, "+ name + " " + surname);
		return "goodbye";
	}
	@GetMapping(value = "/calculator")
	public String calculator (@RequestParam(value = "a") int a, @RequestParam(value = "b") int b,
							  @RequestParam(value = "action") String action, Model model){
		double result;

		switch (action){
			case "multiplication":
				result = a*b;
				break;
			case "division":
				result = a/(double)b;
				break;
			case "subtraction":
				result = a-b;
				break;
			case " addition":
				result = a+b;
				break;
			default:
				result = 0;
				break;
		}
		model.addAttribute("result", result);
		return "/calculator";
	}

	
}