# dubbo-spring-boot-demo
This is the demo providing provider and consumer using alibaba dubbo

## build project
`mvn -Drat.skip=true clean install`

## run provider
1. `cd dubbo-spring-boot-demo/dubbo-provider`
2. `mvn exec:java -Dexec.mainClass="com.joe.provider.bootstrap.DubboProviderApplication"`
