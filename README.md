# dubbo-spring-boot-demo
This is the demo project using alibaba dubbo to implement micro service. 

## DevOps
This project enables jenkins as continual integration tool supporting automatic testing and building package after merging code to master. Also we use docker hub to upload built service package and keep online service update to date.

## Build project
1. `mvn -Drat.skip=true clean install`

## Format java code
you need to first format your java code by running `mvn fmt:format`

## Run Provider service
run dirrectly
1. `cd dubbo-spring-boot-demo/dubbo-provider`
2. `mvn exec:java -Dexec.mainClass="com.joe.provider.DubboProviderApplication"`

use docker
1. `docker pull joehou/dubbo-provider`
2. `docker run -d -p dubbo_port_you_want_to_export:dubbo_port_you_want_to_export -e DUBBO_IP_TO_REGISTRY=your_host_ip -e DUBBO_PORT_TO_REGISTRY=dubbo_port_you_want_to_export  --name sample-app joehou/dubbo-provider`

This will register provider service to zookeeper. You could change zookeeper config in application.properties. `DUBBO_IP_TO_REGISTRY` is required because this service is running in docker and service'ip is internal so it's not accessiable outside. We must expose docker host ip to make service findable.
