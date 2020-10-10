package com.psq.springbootjpa.web;

import com.psq.springbootjpa.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/authors")
public class authorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public Object getAuthorForPage(
            @PageableDefault(page = 0, value = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

}
