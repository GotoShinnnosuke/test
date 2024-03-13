package jp.ac.ohara.oharabank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jp.ac.ohara.oharabank.model.BankAccount;
import jp.ac.ohara.oharabank.model.form.LoginForm;
import jp.ac.ohara.oharabank.repository.BankAccountRepository;
import jp.ac.ohara.oharabank.service.BankAccountService;

@Controller
public class MainController {
	@Autowired
	private BankAccountService userService;
	
	@Autowired
	BankAccountRepository repository;
	
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "こんにちは");
    return "base";
  }
  
  @GetMapping("/login")
  public String login(LoginForm loginform,Model model) {
	model.addAttribute("sign","sin");
	model.addAttribute("formModel",loginform);
	return "login";
  }
  @GetMapping("/transaction")
  public ModelAndView secret(ModelAndView model, HttpServletRequest request) {
	  String user = request.getRemoteUser();
	  String msg = "[login by \"" + user + "\"]";
	  model.setViewName("transaction");
	  model.addObject("msg",msg);
	  return model;
  }
  
  @GetMapping("/form")
  public ModelAndView form(BankAccount bankaccount,ModelAndView model) {
	  model.addObject("title","入力フォームです");
	  model.addObject("msg","以下の項目を入力してください");
	  model.addObject("formModel",bankaccount);
	  model.setViewName("form");
	  return model;
  }
  
  
  @PostMapping("/form")
  public String form(@Validated @ModelAttribute @NonNull BankAccount bankaccount, RedirectAttributes result,ModelAndView model,
		  RedirectAttributes redirectattributes) {
	  try {
		  this.userService.save(bankaccount);
		  redirectattributes.addFlashAttribute("exception","");
		  }catch(Exception e){
		  redirectattributes.addFlashAttribute("exception","");
		  }
	  
	  return "redirect:/form";
  }
}  