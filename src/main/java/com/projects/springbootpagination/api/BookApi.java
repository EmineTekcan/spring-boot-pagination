package com.projects.springbootpagination.api;

import com.projects.springbootpagination.model.Book;
import com.projects.springbootpagination.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookApi {

    private final BookRepository bookRepository;
    @GetMapping
    public Page<Book> getAllBooksPagination(@RequestParam  int pageSize,
                                            @RequestParam  int page){

        Pageable pageable= PageRequest.of(page,pageSize);
        return bookRepository.findAll(pageable);
    }

    //totalElements count query
    @GetMapping("/pagination")
    public Page<Book> getAllBooksPagination(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    //not count query
    //is there just a continuation
    //one more record than the pageable(size) number
    //It costs less
    @GetMapping("/slice")
    public Slice<Book> getAllBooksSlice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
