package ru.quasistellar.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {


    @Autowired
    MessageRepository messageRepository;

    public Iterable<Message> all() {
        return messageRepository.findAll();
    }

    public Message create(Message message) {
        return messageRepository.save(message);
    }

    public Message find(int messageId) {
        return messageRepository.findOne(messageId);
    }

    public Message update(Message updatedMessage) {
        return messageRepository.save(updatedMessage);
    }

    public void delete(int messageId) {
        messageRepository.delete(messageId);
    }



    public Message findByEmail(String email) {
        return messageRepository.findByEmail(email);

    }
}
