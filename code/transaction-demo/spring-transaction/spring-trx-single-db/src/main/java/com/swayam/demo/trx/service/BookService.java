package com.swayam.demo.trx.service;

import java.util.List;
import java.util.Map;

import com.swayam.demo.trx.entity.Author;
import com.swayam.demo.trx.entity.Genre;
import com.swayam.demo.trx.web.dto.AuthorRequest;

public interface BookService {

	List<Genre> getGenres();

	List<Author> getAuthors();

	Map<String, Long> addAuthorWithGenre(AuthorRequest authorRequest);

}
