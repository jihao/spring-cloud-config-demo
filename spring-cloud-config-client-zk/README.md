
zkCli.sh

	create /config ""
	create /config/zkconfigclient ""
	create /config/zkconfigclient/message helloworld
	quit



start app

	$curl localhost:8883/greeting
	Hello helloworld
	

zkCli.sh, profile

[References: spring-cloud-zookeeper-config](http://cloud.spring.io/spring-cloud-zookeeper/spring-cloud-zookeeper.html#spring-cloud-zookeeper-config)
	
	create /config ""
	create /config/zkconfigclient,development ""
	create /config/zkconfigclient,development/message "developers"
	create /config/zkconfigclient,production ""
	create /config/zkconfigclient,production/message "product managers"
	quit
	

start app with development profile

	$java -jar target/spring-cloud-config-client-zk-0.0.1-SNAPSHOT.jar --spring.profiles.active=development
	$curl localhost:8883/greeting
	Hello developers
	
	
start app with production profile

	$java -jar target/spring-cloud-config-client-zk-0.0.1-SNAPSHOT.jar --spring.profiles.active=production
	$curl localhost:8883/greeting
	Hello product managers
	
	
For dynamic updates, use the spring-cloud-config-server dependency, use ```@Autowire Environment``` will get the latest value, once changed in zookeeper.
Alternatively use ```@RefreshScope```, which will be automatically refreshed. (see log like: ```o.s.c.e.event.RefreshEventListener       : Refresh keys changed: [message]```)
No need to post to /refresh now. Seems not been mentioned in the doc above. 

    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
    </dependency>
    
