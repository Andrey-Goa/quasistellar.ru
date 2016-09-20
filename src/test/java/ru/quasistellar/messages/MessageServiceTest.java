package ru.quasistellar.messages;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.quasistellar.Application;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MessageServiceTest {

    @Mock
    MessageRepository messageRepository;

    @InjectMocks
    MessageService messageService;

    private List<Message> messageList;
    private Message messageOne;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        messageList = new ArrayList<>();
        messageOne = mock(Message.class);
    }

    @Test
    public void testAll() throws Exception {
        when(messageRepository.findAll()).thenReturn(messageList);
        Iterable<Message> messages = messageService.all();

        verify(messageRepository, times(1)).findAll();
        assertThat(messages, is(equalTo(messageList)));
    }

    @Test
    public void testCreate() throws Exception {
        Message message = new Message();
        messageService.create(message);
        verify(messageRepository,times(1)).save(message);

    }

    @Test
    public void testFind() throws Exception {
        when(messageService.find(1)).thenReturn(messageOne);
        messageService.find(1);
        verify(messageRepository, times(1)).findOne(1);

    }

    @Test
    public void testDelete() throws Exception {

        messageService.delete(1);
        verify(messageRepository, times(1)).delete(1);

    }
}