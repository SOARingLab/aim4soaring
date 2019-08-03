```
mvn spring-boot:run -Dspring-boot.run.profiles=node2
```
## ActiveMQ
- run active mq
```
docker run --name=activemq -d --rm -p 1883:1883 -p 5672:5672 -p 8161:8161 -p 61613:61613 -p 61614:61614 -p 61616:61616 webcenter/activemq:latest
```
- open <http://localhost:8161/admin/queues.jsp>
    - account: admin
    - password: admin
- REST api for active mq
    - endpoint: <http://localhost:61616>
    - account: admin
    - password: admin

