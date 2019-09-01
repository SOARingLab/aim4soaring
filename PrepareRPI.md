# Prepare a runnable RPI

## flash a sd card using Etcher
> 2019-07-10-raspbian-buster.img

## locale
choose
- Locate: HongKong
- Language: English

enable ssh servers
## mirrors
```bash
echo """
deb http://mirrors.tuna.tsinghua.edu.cn/raspbian/raspbian/ buster main non-free contrib
deb-src http://mirrors.tuna.tsinghua.edu.cn/raspbian/raspbian/ buster main non-free contrib
""" | sudo tee -a /etc/apt/sources.list

echo """
deb http://mirrors.tuna.tsinghua.edu.cn/raspberrypi/ buster main ui
""" | sudo tee -a /etc/apt/sources.list.d/raspi.list

sudo apt update
```

## hostname
```bash
sudo hostnamectl set-hostname up.soaringlab.top
```

```text
10.131.245.126	center.soaringlab.top 
10.131.245.127	up.soaringlab.top 
10.131.245.128	right.soaringlab.top 
10.131.245.129	down.soaringlab.top
10.131.245.130	left.soaringlab.top 
```

## network
```bash
echo """
# interfaces(5) file used by ifup(8) and ifdown(8)

# Please note that this file is written to be used with dhcpcd
# For static IP, consult /etc/dhcpcd.conf and 'man dhcpcd.conf'

# Include files from /etc/network/interfaces.d:
source-directory /etc/network/interfaces.d

auto lo
iface lo inet loopback

auto eth0
iface eth0 inet static
address 10.131.245.127
netmask 255.255.254.0
gateway 10.131.244.1
dns-nameservers 202.120.224.6
""" | sudo tee -a /etc/network/interfaces
sudo systemctl restart networking.service
```

## java
```bash
sudo apt install openjdk-8-jdk maven vim -y
```

## deploy key
```bash
ssh-keygen -t ed25519
cat .ssh/id_ed25519.pub
```

## git clone
```bash
git clone git@gitlab.soaringlab.top:clhu/aim4.git
```
```bash
mvn spring-boot:run
```
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=all-in-one
```

--------------------
## docker
```bash
curl -sSL https://get.docker.com | sh
sudo usermod -aG docker pi
```

## run activemq
```bash
sudo docker run -d --name=`hostname -f` --restart=always -p8000:8161 -p60000:61616 registry.soaringlab.top/woahbase/alpine-activemq:armhf
```

| Node | Host | endpoint | manage ui |
| ----- | ----- | ----- | ----- |
| node-center | center.soaringlab.top | tcp://center.soaringlab.top:60000 | http://center.soaringlab.top:8000/admin/queues.jsp | 
| node-up | up.soaringlab.top | tcp://up.soaringlab.top:600001 | http://up.soaringlab.top:8001/admin/queues.jsp | 
| node-right | right.soaringlab.top | tcp://right.soaringlab.top:60002 | http://right.soaringlab.top:8002/admin/queues.jsp | 
| node-down | down.soaringlab.top | tcp://down.soaringlab.top:60003 | http://down.soaringlab.top:8003/admin/queues.jsp | 
| node-left | left.soaringlab.top | tcp://left.soaringlab.top:60004 | http://left.soaringlab.top:8004/admin/queues.jsp | 
