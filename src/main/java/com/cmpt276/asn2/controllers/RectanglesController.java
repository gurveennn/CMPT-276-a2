package com.cmpt276.asn2.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmpt276.asn2.models.Rectangle;
import com.cmpt276.asn2.models.RectangleRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RectanglesController {
    
    @Autowired
    private RectangleRepository rectRepo;
    @GetMapping("/rectangles/view")
    public String getAllRectangles(Model model) {
        System.out.println("Getting all Rectangles");
        List<Rectangle> rectangles = rectRepo.findAll();

        //end of database call
        model.addAttribute("re", rectangles);
        return "rectangles/showAll";
    }

    @GetMapping("rectangles/{name}")
    public String getRectangle(@RequestParam String name, Model model) {
        System.out.println("Getting rectangle name");
        List<Rectangle> rectangles = rectRepo.findByName(name);

        //end of databse call
        model.addAttribute("re", rectangles);
        return "rectangles/showRectangle";
    }
    
    @PostMapping("/rectangles/add")
    public String addRectangle(@RequestParam Map<String, String> newRect, HttpServletResponse response) {
        System.out.println("Add rectangle");

        String newName = newRect.get("name");
        int newWidth = Integer.parseInt(newRect.get("width"));
        int newHeight = Integer.parseInt(newRect.get("height"));
        String newColor = newRect.get("color");
        rectRepo.save(new Rectangle(newName,newWidth,newHeight,newColor));
        response.setStatus(201);
        return "redirect:/rectangles/view"; 
    }

    @PostMapping("/rectangles/updateRectangle")
    public String updateRectangle(@RequestParam int rid, @RequestParam String name, @RequestParam int width, @RequestParam int height, @RequestParam String color, Model model, HttpServletResponse response) {
        System.out.println("updating rectangle");

        List<Rectangle> rectangles = rectRepo.findByRid(rid);
        if (!rectangles.isEmpty()) {
            Rectangle rectangle = rectangles.get(0);
            rectangle.setName(name);
            rectangle.setWidth(width);
            rectangle.setHeight(height);
            rectangle.setColor(color);
            
            rectRepo.save(rectangle);
        }
        
        List<Rectangle> allRectangles = rectRepo.findByRid(rid);
        model.addAttribute("re", allRectangles);
        response.setStatus(201);
        return "rectangles/showRectangle";
    }

    @PostMapping("/rectangles/delete")
    public String deleteRectangle(@RequestParam int rid) {
        System.out.println("deleting reactangle");
        rectRepo.deleteById(rid);
        return "redirect:/rectangles/view";
        //return "rectangles/showAll";
    }
}

