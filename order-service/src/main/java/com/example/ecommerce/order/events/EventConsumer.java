package com.example.ecommerce.order.events;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class EventConsumer {
    @KafkaListener(topics = "orders", groupId = "order-service")
    public void handleOrderCreated(OrderCreatedEvent event) {
        // Copilot: update local state, trigger saga, etc.
    }
    @RabbitListener(queues = "order.created.queue")
    public void handleOrderCreatedRabbit(OrderCreatedEvent event) {
        // Copilot: update local state, trigger saga, etc.
    }
}
