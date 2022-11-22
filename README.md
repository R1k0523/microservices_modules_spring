## (WIP) Попытка автоматизировать сборку микросервисов на Spring Boot
2 модуля на Spring Boot. Каждый должен являться микросервисом.

### Пока что нужно сделать следующее:

1. Для каждого модуля собрать образ:
```
./gradlew :<модуль>:bootBuildImage --imageName=service/<модуль>
```

2. Запустить docker compose
```
docker-compose up
```
