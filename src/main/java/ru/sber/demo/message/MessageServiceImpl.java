package ru.sber.demo.message;

import org.springframework.stereotype.Service;
import ru.sber.demo.controller.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {
    private final Map<String, Message> messages = new HashMap<>();

    @Override
    public Message get(String id) {
        return messages.get(id);
    }

    @Override
    public String save(Message message) {
        String id = UUID.randomUUID().toString();
        messages.put(id, message);
        return id;
    }
}
