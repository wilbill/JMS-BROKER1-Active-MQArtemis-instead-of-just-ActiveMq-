package org.billy.jmsbroker1.jmsbroker1.messaging;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import lombok.RequiredArgsConstructor;
import org.billy.jmsbroker1.jmsbroker1.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@RequiredArgsConstructor
public class JmsOrderMessagingService implements OrderMessagingService{
    private JmsTemplate jms;

    @Override
    public void sendOrder(Order order){
        jms.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage((Serializable) order);
            }
        });
    }
}
