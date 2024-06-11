package com.cmpt276.asn2.models;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RectangleRepository extends JpaRepository<Rectangle,Integer> {
    List<Rectangle> findByName(String name);
    List<Rectangle> findByRid(int rid);
    List<Rectangle> deleteByRid(int rid);
    // List<Rectangle> findbyFontName(String fontName);
    // List<Rectangle> findByColor(String color);
    // List<Rectangle> findByWidthandHieght(int width, int height);
    
}
