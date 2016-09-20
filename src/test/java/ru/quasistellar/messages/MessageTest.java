package ru.quasistellar.messages;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

public class MessageTest {


    @Test
    public void testSetDate() throws Exception {
        Message message = new Message();
        Date date = new Date();
        assertThat(message.getDate(), is(equalTo(date)));
    }


}