package com.psq.springbootjpa.service;

import com.psq.springbootjpa.domain.Author;

public interface AuthorService {

    Author updateAuthor();

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    Author findAuthor(Long id);

    void deleteAuthor(Long id);
}
