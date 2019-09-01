# Prepare a runnable RPI

## flash a sd card using Etcher
> 2019-07-10-raspbian-buster.img

## locale
choose
- Locate: HongKong
- Language: English

## mirrors
### `/etc/apt/sources.list`
```bash
echo """
deb http://mirrors.tuna.tsinghua.edu.cn/raspbian/raspbian/ buster main non-free contrib
deb-src http://mirrors.tuna.tsinghua.edu.cn/raspbian/raspbian/ buster main non-free contrib
""" | sudo tee -a /etc/apt/sources.list
```

### `/etc/apt/sources.list.d/raspi.list`
```bash
echo """
deb http://mirrors.tuna.tsinghua.edu.cn/raspberrypi/ buster main ui
""" | sudo tee -a /etc/apt/sources.list.d/raspi.list
```

### update
```bash
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
sudo apt install openjdk-java8-jdk maven vim dnsutils -y
```

## deploy key
```bash
ssh-keygen -t ed25519
> enter
> enter
> enter
cat .ssh/id_ed25519.pub
```

## git clone
```bash
git clone git@gitlab.soaringlab.top:clhu/aim4.git
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
