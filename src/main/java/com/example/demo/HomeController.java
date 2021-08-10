package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("directors", directorRepository.findAll());
        return "index";
    }

    @GetMapping("/addDirector")
    public String addDirector(Model model){
        model.addAttribute("director", new Director());
        return "directorForm";
    }

    @RequestMapping("/updateDirector/{id}")
    public String updateDirector(@PathVariable("id") long id, Model model){
        model.addAttribute("director", directorRepository.findById(id).get());
        return "directorForm";
    }

    @RequestMapping("/deleteDirector/{id}")
    public String deleteDirector(@PathVariable("id") long id){
        directorRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/processDirector")
    public String processDirector(@ModelAttribute Director director){
        directorRepository.save(director);
        return "redirect:/";
    }

    @GetMapping("/addMovie")
    public String addMovie(Model model){
        model.addAttribute("movie", new Movie());
        model.addAttribute("directors", directorRepository.findAll());
        return "movieForm";
    }

    @RequestMapping("/updateMovie/{id}")
    public String updateMovie(@PathVariable("id") long id, Model model){
        model.addAttribute("movie", movieRepository.findById(id).get());
        model.addAttribute("directors", directorRepository.findAll());
        return "movieForm";
    }

    @RequestMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") long id){
        movieRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/processMovie")
    public String processMovie(@ModelAttribute Movie movie){
        movieRepository.save(movie);
        return "redirect:/";
    }
}
