package com.devmaster.lesson08.service;

import com.devmaster.lesson08.entity.Author;
import com.devmaster.lesson08.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    // Lấy toàn bộ tác giả
    public  List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    //Lấy 1 tác giả
    public Author getAuthorById(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    // Ghi lại
    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    // Xóa
    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    // Lây ra nhưng tác giả được chọn
    public List<Author> findAllById(List<Long> ids){
        return authorRepository.findAllById(ids);
    }
}
