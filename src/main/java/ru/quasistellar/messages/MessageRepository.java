package ru.quasistellar.messages;

import org.springframework.data.repository.CrudRepository;



public interface MessageRepository extends CrudRepository<Message, Integer> {

    public Message findByEmail(String email);

}
