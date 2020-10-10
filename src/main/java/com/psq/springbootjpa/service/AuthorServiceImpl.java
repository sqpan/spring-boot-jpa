package com.psq.springbootjpa.service;

import com.psq.springbootjpa.domain.Author;
import com.psq.springbootjpa.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author updateAuthor() {
        Author author = new Author();
        author.setPhone("12121212");
        author.setNickName("Jimmy");
        author.setSignDate(new Date());
        author.setId((long) 11);
        // save to database and generate ID for author1
        Author author1 = authorRepository.save(author);
        author1.setPhone("909090909090");
        // author1 already has an ID, if you save it again, it will do update instead of save a new one
        Author author2 = authorRepository.save(author1);
        return author2;
    }
}
