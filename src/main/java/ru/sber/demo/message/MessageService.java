package ru.sber.demo.message;

import ru.sber.demo.controller.Message;

public interface MessageService {
    Message get(String id);
    String save(Message message);
}
