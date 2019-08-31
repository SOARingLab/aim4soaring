# Intersections demo
## /etc/hosts
```text
192.168.128.100	center.soaringlab.top 
192.168.128.101	up.soaringlab.top 
192.168.128.102	right.soaringlab.top 
192.168.128.103	down.soaringlab.top
192.168.128.104	left.soaringlab.top 
```

| Node | Host | endpoint | manage ui |
| ----- | ----- | ----- | ----- |
| node-center | center.soaringlab.top | tcp://center.soaringlab.top:60000 | http://center.soaringlab.top:8161/admin/queues.jsp | 
| node-up | up.soaringlab.top | tcp://up.soaringlab.top:60001 | http://up.soaringlab.top:8162/admin/queues.jsp | 
| node-right | right.soaringlab.top | tcp://right.soaringlab.top:60002 | http://right.soaringlab.top:8163/admin/queues.jsp | 
| node-down | down.soaringlab.top | tcp://down.soaringlab.top:60003 | http://down.soaringlab.top:8164/admin/queues.jsp | 
| node-left | left.soaringlab.top | tcp://left.soaringlab.top:60004 | http://left.soaringlab.top:8165/admin/queues.jsp | 

|  | map |  | 
| ----- | ----- | ----- | 
| | | |
|  |  node-up |  |
| node-left | node-center | node-right |
|  |  node-down |  |

## run activemq in each node
```bash
cd activemq/
docker-compose.yml up -d activemq_center
docker-compose.yml up -d activemq_up
docker-compose.yml up -d activemq_right
docker-compose.yml up -d activemq_down
docker-compose.yml up -d activemq_left
```

## run AIM in each node
### all in one
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=all-in-one
```

### 1 node center
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=1-node-center
```

### L node mode
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=L-node-center
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=L-node-down
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=L-node-left
```

### T node mode
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=T-node-center
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=T-node-down
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=T-node-left
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=T-node-right
```


### X node mode
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=X-node-center
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=X-node-down
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=X-node-left
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=X-node-right
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=X-node-up
```
