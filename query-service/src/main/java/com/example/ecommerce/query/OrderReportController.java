package com.example.ecommerce.query;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/reports/orders")
public class OrderReportController {
    @GetMapping
    public List<Object> getAllOrders() {
        // Return from read store
        return Collections.emptyList();
    }
}
