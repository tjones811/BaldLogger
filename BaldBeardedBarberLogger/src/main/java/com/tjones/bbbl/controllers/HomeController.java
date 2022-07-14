package com.tjones.bbbl.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.tjones.bbbl.models.Client;
import com.tjones.bbbl.models.LoginUser;
import com.tjones.bbbl.models.User;
import com.tjones.bbbl.services.ClientService;
import com.tjones.bbbl.services.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClientService clientService;
	
	
	/**************Login and Reg and Logout**********/
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,Model model, HttpSession session) {
		
		userService.register(newUser, result);
		 if(result.hasErrors()) {
			 model.addAttribute("newLogin", new LoginUser());
			 return "index.jsp";
		 }
		 
		 else {
			 session.setAttribute("user_id", newUser.getId());
			 return "redirect:/dashboard";
		 }
	 }
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        session.setAttribute("user_id", user.getId());
    
        return "redirect:/dashboard";
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	
	/**************Dashboard**********/
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		 if (session.getAttribute("user_id") != null) {
			 model.addAttribute("allClients", clientService.allClients());
			 
			 Long user_id =  (Long) session.getAttribute("user_id");
			 User user = userService.findUser(user_id);
			 model.addAttribute("user", user);
   		 	
			 return "dashboard.jsp";
		 }
		 
		 else {
			 return "redirect:/"; 
		 }
	}
	
	/**************Create Client**********/
	@GetMapping("/newClient")
	 public String newClient(@ModelAttribute("client")Client client,Model model,
    		 HttpSession session) {
    	 
		 Long user_id =  (Long) session.getAttribute("user_id");
		 User user = userService.findUser(user_id);
		 model.addAttribute("user", user);
    	 return "newClient.jsp";
     }
     
     
     @PostMapping("/processClient")
     public String processNewClient(@Valid @ModelAttribute("client") Client client, 
    		 BindingResult result, Model model,HttpSession session ) {
    	 if (result.hasErrors()) {
    		 
    		 Long user_id =  (Long) session.getAttribute("user_id");
    		 User user = userService.findUser(user_id);
    		 model.addAttribute("user", user);
    		 return "newClient.jsp";
    	 }
    	 else {
    		 clientService.createClient(client);
    		 return "redirect:/dashboard";
    	 }
     }
	
	/*************Edit Client**********/
     @GetMapping("/editClient/{id}")
     public String editClient(@PathVariable("id") Long id,@ModelAttribute("item") Client client,
    		Model model, HttpSession session){
    	 
    	 Long user_id =  (Long) session.getAttribute("user_id");
		 User user = userService.findUser(user_id);
		 model.addAttribute("user", user);
		 
		 model.addAttribute("client", clientService.findClient(id));
    	 
    	 return "editClient.jsp";
     }
     
     
     @PutMapping("/processEditClient/{id}")
     public String processEditCleint(@PathVariable("id") Long id,@Valid @ModelAttribute("item") Client client,
    		 BindingResult result, Model model,HttpSession session) {
    	 
    	 if(result.hasErrors()) {
    		 
    		 Long user_id =  (Long) session.getAttribute("user_id");
    		 User user = userService.findUser(user_id);
    		 model.addAttribute("user", user);
    		 
    		 model.addAttribute("client", clientService.findClient(id));
    		 
    		 return "editClient.jsp";
    	 }
    	 else {
    		 
    		 clientService.updateClient(client);
    		 
    		 return "redirect:/dashboard";
    	 }
    	 
     }
	
	/**************See One Client**********/
     @GetMapping("/showClient/{id}")
     public String showClient(@PathVariable("id") Long id, Model model,HttpSession session) {
    	 
    	 Long user_id =  (Long) session.getAttribute("user_id");
		 User user = userService.findUser(user_id);
		 model.addAttribute("user", user);
		 
		 model.addAttribute("client", clientService.findClient(id));
    	 return "oneClient.jsp";
     }
	
	/**************Delete Client**********/
     @GetMapping("/deleteClient/{id}")
     public String delete(@PathVariable("id") Long id) {
    	 clientService.deleteClient(id);
    	 return "redirect:/dashboard";
     }
			

}
