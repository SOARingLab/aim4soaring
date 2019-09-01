# Single intersection demo 
> all in one

## Springboot
```
mvn spring-boot:run -Dspring-boot.run.profiles=node2
```

## ActiveMQ
run activemq using docker-compose

```bash
cd ./activemq
docker-compose up -d
docker ps -a
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
|  |  node-up |  |
| node-left | node-center | node-right |
|  |  node-down |  |

> /etc/hosts
```text
127.0.0.1	north.soaringlab.top south.soaringlab.top west.soaringlab.top east.soaringlab.top
127.0.0.1	up.soaringlab.top right.soaringlab.top left.soaringlab.top down.soaringlab.top
```
