package org.springbootdemo.springwebapp.respositories;


import org.springbootdemo.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
