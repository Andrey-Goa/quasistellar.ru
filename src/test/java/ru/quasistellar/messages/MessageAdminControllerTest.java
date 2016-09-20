package ru.quasistellar.messages;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.quasistellar.Application;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MessageAdminControllerTest {

    @Mock
    private MessageService messageService;
    @Mock
    private MailMessage ms;

    @InjectMocks
    private  MessageAdminController messageAdminController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(messageAdminController).build();

    }

    @Test
    public void testAdminMessages() throws Exception {
        List<Message> messageList = new ArrayList<>();
        when(messageService.all()).thenReturn(messageList);
        mockMvc.perform(get("/admin/clients"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/message/message"))
                .andExpect(model().attribute("messages", messageList));
    }


    @Test
    public void testSaveMessages() throws Exception {
        Message message = new Message();
        message.setName("Name");
        message.setEmail("Test@mail.ru");
        message.setTel("");
        message.setContent("Test");
        when(messageService.create(message)).thenReturn(message);
        ms.sendM("Name", "Test@mail.ru", "", "Test");
        verify(ms, times(1)).sendM(message.getName(), message.getEmail(), message.getTel(), message.getContent());


    }

    @Test
    public void testMessageEdit() throws Exception {
        Message message = mock(Message.class);
        when(messageService.find(1)).thenReturn(message);
        mockMvc.perform(get("/admin/clients/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/message/edit"))
                .andExpect(model().attribute("message", message));
    }


}