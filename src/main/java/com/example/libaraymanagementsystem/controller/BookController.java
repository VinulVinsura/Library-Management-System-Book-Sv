package com.example.libaraymanagementsystem.controller;

import com.example.libaraymanagementsystem.dto.BookDto;
import com.example.libaraymanagementsystem.dto.Response;
import com.example.libaraymanagementsystem.entity.BookEntity;
import com.example.libaraymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@CrossOrigin
@RequiredArgsConstructor // All final varibles are inject
public class BookController {
    Response response=new Response();

    final BookService bookService;
    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.CREATED) //HTTP status of our post method
    public Response addBook(@RequestBody BookDto bookDto){

        BookEntity bookEntity = bookService.addBook(bookDto);
        if (bookEntity!=null){
           response.setId(bookEntity.getId());
           response.setIsbn(bookEntity.getIsbn());
           response.setStatus("Book Added Successful !!!");
           return response;
        }


        response.setStatus("Book Added Unsuccessful !!!");
        return response;
    }


    @GetMapping("/getBookList")
    public List<BookDto> getBookList(){
        return bookService.getBooks();
    }

}
