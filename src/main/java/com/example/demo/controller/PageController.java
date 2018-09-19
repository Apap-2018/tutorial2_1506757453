package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";		
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name",name.get());
		} else {
			model.addAttribute("name", "KB");
		}
//		model.addAttribute("name", name);
		return "challenge";
	}
	
	/*
	 * generator controller
	 */
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required=false, defaultValue="0") String a, 
							@RequestParam(value = "b", required=false, defaultValue="0") String b, 
							@RequestParam(value = "result", required=false, defaultValue="hm") String result,
							Model model) {
		//ubah paramater a & b jadi int
		int aInt = Integer.parseInt(a);
		int bInt = Integer.parseInt(b);

		String hm = "h";				//string untuk loop a
		String res = "";				//string untuk loop b
		
		//ubah jika a atau b 0 jadi 1
		if (a.equalsIgnoreCase("0")) {
			aInt = 1;
		}
		if (b.equalsIgnoreCase("0")) {
			bInt = 1;
		}
		
		//Loop a
		for (int i = 0; i < aInt; i++) {
			hm = hm + "m";
		}
		hm = hm + " ";
		
		//Loop b
		for (int i = 0; i < bInt; i++) {
			res += hm;
		}
		result = res;
			
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("result", result);
		
		return "generator";
	}
}


