package ru.sber.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.sber.demo.controller.Message;
import ru.sber.demo.message.MessageService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ContractTestIT {
    @MockBean
    private MessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveMessage200() throws Exception {
        when(messageService.save(any())).thenReturn("success");
        mockMvc.perform(post("/demo/saveMessage").content("{\"text\":\"LOLKEK\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("success"));
    }

    @Test
    void saveMessage400() throws Exception {
        when(messageService.save(any())).thenReturn("success");
        mockMvc.perform(post("/demo/saveMessage").content("{}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void saveMessage500() throws Exception {
        when(messageService.save(any())).thenThrow(new RuntimeException());
        mockMvc.perform(post("/demo/saveMessage").content("{\"text\":\"LOLKEK\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(500));
    }
}
