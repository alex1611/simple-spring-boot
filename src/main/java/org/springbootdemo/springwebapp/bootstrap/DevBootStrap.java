package org.springbootdemo.springwebapp.bootstrap;

import org.springbootdemo.springwebapp.model.Author;
import org.springbootdemo.springwebapp.model.Book;
import org.springbootdemo.springwebapp.model.Publisher;
import org.springbootdemo.springwebapp.respositories.AuthorRepository;
import org.springbootdemo.springwebapp.respositories.BookRepository;
import org.springbootdemo.springwebapp.respositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        Publisher harperCollins = new Publisher("Harper Collins","195 Broadway, New York, NY 10007, USA");
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Doman Driver Design", "1234",harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Publisher worx = new Publisher("Worx","ds");
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development withoutEJB", "23444",worx);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
