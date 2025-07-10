package com.example.ecommerce.query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.ecommerce.order.events.OrderCreatedEvent;
@Component
public class OrderEventConsumer {
    @KafkaListener(topics = "orders")
    public void handleOrderCreated(OrderCreatedEvent event) {
        // Save to Elasticsearch/Redis for fast querying
    }
}
