## Springboot
```
mvn spring-boot:run -Dspring-boot.run.profiles=node2
```
## ActiveMQ
- run active mq array using docker-compose
```bash
cd ./activemq
docker-compose up -d
docker ps -a
```
```text
~/aim4/activemq> docker ps -a                                                                                                                                                                                                                                                     master!
CONTAINER ID        IMAGE                       COMMAND             CREATED             STATUS              PORTS                                                                                   NAMES
17e4bcff5802        webcenter/activemq:latest   "/app/run.sh"       4 minutes ago       Up 4 minutes        1883/tcp, 5672/tcp, 61613-61614/tcp, 0.0.0.0:8163->8161/tcp, 0.0.0.0:61618->61616/tcp   activemq_right
5ceff0cf092f        webcenter/activemq:latest   "/app/run.sh"       4 minutes ago       Up 3 minutes        1883/tcp, 5672/tcp, 61613-61614/tcp, 0.0.0.0:8164->8161/tcp, 0.0.0.0:61619->61616/tcp   activemq_down
d485428fbd11        webcenter/activemq:latest   "/app/run.sh"       4 minutes ago       Up 4 minutes        1883/tcp, 5672/tcp, 61613-61614/tcp, 0.0.0.0:8162->8161/tcp, 0.0.0.0:61617->61616/tcp   activemq_up
db6649752a35        webcenter/activemq:latest   "/app/run.sh"       4 minutes ago       Up 4 minutes        1883/tcp, 5672/tcp, 0.0.0.0:8161->8161/tcp, 61613-61614/tcp, 0.0.0.0:61616->61616/tcp   activemq_center
d5a7007b0aae        webcenter/activemq:latest   "/app/run.sh"       4 minutes ago       Up 4 minutes        1883/tcp, 5672/tcp, 61613-61614/tcp, 0.0.0.0:8165->8161/tcp, 0.0.0.0:61620->61616/tcp   activemq_left
```

| Node | Host | endpoint | manage ui |
| ----- | ----- | ----- | ----- |
| node-center | center.soaringlab.top | tcp://center.soaringlab.top:61616 | http://center.soaringlab.top:8161/admin/queues.jsp | 
| node-up | up.soaringlab.top | tcp://up.soaringlab.top:61617 | http://up.soaringlab.top:8162/admin/queues.jsp | 
| node-right | right.soaringlab.top | tcp://right.soaringlab.top:61618 | http://right.soaringlab.top:8163/admin/queues.jsp | 
| node-down | down.soaringlab.top | tcp://down.soaringlab.top:61619 | http://down.soaringlab.top:8164/admin/queues.jsp | 
| node-left | left.soaringlab.top | tcp://left.soaringlab.top:61620 | http://left.soaringlab.top:8165/admin/queues.jsp | 

|  | map |  | 
| ----- | ----- | ----- | 
| | | |
|  |  node-up |  |
| node-left | node-center | node-right |
|  |  node-down |  |

```text
127.0.0.1	north.soaringlab.top south.soaringlab.top west.soaringlab.top east.soaringlab.top
127.0.0.1	up.soaringlab.top right.soaringlab.top left.soaringlab.top down.soaringlab.top
```
