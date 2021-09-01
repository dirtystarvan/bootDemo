package ru.sber.demo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.sber.demo.controller.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Profile("test")
public class LogMessageServiceImpl implements MessageService {
    private static final Logger log = LoggerFactory.getLogger(LogMessageServiceImpl.class);
    private final Map<String, Message> messages = new HashMap<>();

    @Override
    public Message get(String id) {
        return messages.get(id);
    }

    @Override
    public String save(Message message) {
        String id = UUID.randomUUID().toString();
        log.info("message");
        messages.put(id, message);
        return id;
    }
}
