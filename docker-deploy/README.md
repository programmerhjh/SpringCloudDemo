####docker-compose安装地址
https://docs.docker.com/compose/install/#master-builds

####本项目实际配置
这里我的环境为window7系统 + 虚拟机上的centos7
centos7上有安装了docker，但没有安装docker-compose
首先配置好工程里的东西后，在windows上环境变量的系统变量上设置DOCKER_HOST变量，参数为 tcp://{docker.ip}:2375 其中docker.ip为本人的装有docker虚拟机ip地址
然后在虚拟机的docker上配置文件开启远程ip访问

vim /usr/lib/systemd/system/docker.service 

找到如下区域并修改

[Service]

ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock

systemctl daemon-reload

systemctl restart docker

然后关闭centos7 iptables服务 及关闭防火墙（不关闭会构建镜像失败，我自己踩了这个坑）

service iptables stop

然后打开windows dos窗口使用maven命令在docker上构建镜像

mvn clean

mvn package docker:build

构建成功后，然后重新开启防火墙（不开启的话，运行docker里面的镜像会报 NO-CHAIN 异常）

重启docker

service docker restart

运行镜像，先运行eureka-server，在运行service-hi （运行service-hi服务时，需要连接到eureka-server，否则service-hi会因为找不到服务注册中心注册不了服务报错）

docker run -p 8761:8761 -t springcloud/docker-eureka-server

docker run -p 8763:8763 --link sleepy_euler:springcloud/docker-eureka-server -t springcloud/docker-service-hi
