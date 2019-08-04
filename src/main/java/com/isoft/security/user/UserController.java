package com.isoft.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
public class UserController implements ErrorController {

    private final String PATH = "/error";

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String getLogoutPage() {
        return "login";
    }

    @GetMapping(PATH)
    public String getErrorMessage(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {//error404
                model.addAttribute("errorCode", statusCode + " : Request " + HttpStatus.NOT_FOUND.getReasonPhrase());
                return "error";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {//error500
                model.addAttribute("errorCode", statusCode + " : Request " + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
                return "error";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {//error403
                model.addAttribute("errorCode", statusCode + " : Request " + HttpStatus.FORBIDDEN.getReasonPhrase());
                return "error";
            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {//error401
                model.addAttribute("errorCode", statusCode + " : Request " + HttpStatus.UNAUTHORIZED.getReasonPhrase());
                return "error";
            }
        }
        return "error";
    }

    @GetMapping("/new-user")
    public String getSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "response";
    }

    @PostMapping("/create-user")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, String userType) {
        if (!bindingResult.hasErrors()) {
            if (!(userType.equals("Administrator") || userType.equals("Receptionist")))
                return "redirect:/user?unknown";

            else if (userType.equals("Administrator"))
                user.setRole(UserRole.getEnumList().get(1));

            userService.createUser(user);
            return "redirect:user?newUser";
        }
        return "response";
    }

//    Rest API

//    @ResponseBody
//    @GetMapping("/rest-create-user")
//    public User addUser(Model model, @Valid User userList , BindingResult bindingResult) {
//
//        userList = new User(Arrays.asList(new User("admin", "admin1234", UserRole.getEnumList().get(1), new Date()),new User("user", "user1234", UserRole.getEnumList().get(0), new Date())));
////        userList = new HashSet<>();
////        User user = new User("admin", "admin1234", UserRole.getEnumList().get(1), new Date());
////        User user1 = new User("user", "user1234", UserRole.getEnumList().get(0), new Date());
////        userList.add(user);
////        userList.add(user1);
//////        List<User> userList = new ArrayList<>();
//
//        if (bindingResult.hasErrors()) {
//            System.out.println("I have errors");
//            return new User(new ArrayList<User>());
//        }
//
//        userService.createUser(userList);
////        userService.createUser(user1);
//
////        userList = Arrays.asList(user, user1);
//
//        return userList;
//    }

    @ResponseBody
    @GetMapping("/rest-delete-user")
    public String deleteUsers() {
        if (userRepository.findAll().isEmpty())
        return "No User In DB";

        userRepository.deleteAll();
        return "Users Successfully Deleted";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}