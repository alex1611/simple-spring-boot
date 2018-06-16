package org.springbootdemo.springwebapp.respositories;

import org.springbootdemo.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
