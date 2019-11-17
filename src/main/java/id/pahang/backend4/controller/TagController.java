package id.pahang.backend4.controller;

import id.pahang.backend4.model.Tag;
import id.pahang.backend4.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping()
    public List<Tag> getAllTag(){
        return tagRepository.findAll();
    }
}
