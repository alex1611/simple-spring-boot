package org.springbootdemo.springwebapp.respositories;

import org.springbootdemo.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
