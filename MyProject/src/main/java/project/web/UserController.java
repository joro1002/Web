package project.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.model.binding.UserAddBindingModel;
import project.model.binding.UserLoginBindingModel;
import project.model.service.UserServiceModel;
import project.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@Valid @ModelAttribute("userLoginBindingModel")
                                     UserLoginBindingModel userLoginBindingModel,
                                     BindingResult bindingResult, ModelAndView modelAndView,
                                     HttpSession httpSession) {
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/users/login");
        }else {
            modelAndView.setViewName("redirect:/");
        }

        //ToDo login in service
        httpSession.setAttribute("user", "userServiceModel");
        httpSession.setAttribute("id", "userId");
        return modelAndView;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@Valid @ModelAttribute("userAddBindingModel")
                                        UserAddBindingModel userAddBindingModel,
                                        BindingResult bindingResult, ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/users/register");
        } else {

            UserServiceModel userServiceModel = this.userService
                    .registerUser(this.modelMapper.map(userAddBindingModel, UserServiceModel.class));
            modelAndView.setViewName("redirect:/users/login");
        }

        return modelAndView;
    }
}
