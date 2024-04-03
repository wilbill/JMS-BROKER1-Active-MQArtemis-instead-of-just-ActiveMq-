package org.billy.jmsbroker1.jmsbroker1.messaging;

import org.billy.jmsbroker1.jmsbroker1.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
