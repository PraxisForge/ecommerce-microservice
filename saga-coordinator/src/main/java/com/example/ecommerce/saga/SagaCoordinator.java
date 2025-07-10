package com.example.ecommerce.saga;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.ecommerce.order.events.OrderCreatedEvent;
@Component
public class SagaCoordinator {
    @KafkaListener(topics = "orders")
    public void onOrderCreated(OrderCreatedEvent event) {
        // 1. Call PaymentService (REST or event)
        // 2. On success, call InventoryService
        // 3. On all success, emit OrderCompletedEvent
        // 4. On failure, emit PaymentRefunded or StockReverted
    }
}
