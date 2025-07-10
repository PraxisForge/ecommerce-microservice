# Event-Driven Architecture Usage

## Start Brokers
```
docker-compose up -d
```

## Example curl to trigger async flow
```
curl -X POST http://localhost:8081/api/orders -H "Content-Type: application/json" -d '{"userId":"u1","total":100.0}'
```

## Testcontainers
Integration tests use embedded Kafka and RabbitMQ for full event flow validation.
