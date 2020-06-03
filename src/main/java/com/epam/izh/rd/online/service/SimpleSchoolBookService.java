package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;


public class SimpleSchoolBookService implements BookService {
    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;


    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    public SimpleSchoolBookService() {
    }

//    public boolean save(SchoolBook book) {
//
//        if (authorService.findByFullName(book.getAuthorName(), book.getAuthorLastName()) == null) {
//            return false;
//        } else {
//            schoolBookBookRepository.save(book);
//            return true;
//        }
//    }

    @Override
    public boolean save(Book book) {

        return schoolBookBookRepository.save((SchoolBook)book);

    }

    public Book[] findByName(String name) {
        return schoolBookBookRepository.findByName(name);
    }

    public int getNumberOfBooksByName(String name) {
        return findByName(name).length;
    }

    public boolean removeByName(String name) {
        return schoolBookBookRepository.removeByName(name);
    }

    public int count() {
        return schoolBookBookRepository.count();
    }

    public Author findAuthorByBookName(String name) {
        if (schoolBookBookRepository.findByName(name).length != 0) {
            return authorService.findByFullName(schoolBookBookRepository.findByName(name)[0].getAuthorName(), schoolBookBookRepository.findByName(name)[0].getAuthorLastName());
        }
        return null;
    }
}
