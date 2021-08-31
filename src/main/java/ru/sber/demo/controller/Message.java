package ru.sber.demo.controller;

import javax.validation.constraints.NotNull;

public class Message {
    @NotNull
    private String text;

    public Message() {

    }

    public Message(@NotNull String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                '}';
    }
}
