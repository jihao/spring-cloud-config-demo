# README

	config repo: ./config-repo folder
	configserver: localhost:8888
	client1: localhost:8881

### 1. compile

```bash
	$ mvn clean package
```
### 2. start config server

```bash
	$ java -jar ./spring-cloud-config-server/target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar
```

### 3. check config 
```bash
	$ curl http://localhost:8888/client1/production
	$ curl http://localhost:8888/client1/development
```
```json	
        {"name":"client1","profiles":["development"],"label":null,"version":"1b68c54a32107989f91c8dfbfa847b8427686e1f","propertySources":[{"name":"https://github.com/jihao/spring-cloud-config-demo/config-repo/client1-development.properties","source":{"key2":"dev-value2","key1":"dev-value1","message":"developers"}},{"name":"https://github.com/jihao/spring-cloud-config-demo/config-repo/application.properties","source":{"global.param2":"\"shared2\"","global.param1":"\"shared1\"","info.message":"\"this is shared by all spring cloud config clients\""}}]}
```

### 4. start client

```bash
	$ java -jar ./spring-cloud-config-client1/target/spring-cloud-config-client1-0.0.1-SNAPSHOT.jar 
```

### 5. see access client REST url

```bash
	$ curl http://localhost:8881/greeting
	Hello developers
```

### 6. change config in GitHub repo, commit

### 7. see latest configuration through config server

```bash
	$ curl http://localhost:8888/client1/development
```
### 8. refresh client and see changes take effect after refresh

```bash
	$ curl http://localhost:8881/refresh
	$ curl http://localhost:8881/greeting
	Hello developers-haha
```
### 9. start another client with another profile and port

```bash
	$ java -jar ./spring-cloud-config-client1/target/spring-cloud-config-client1-0.0.1-SNAPSHOT.jar --server.port=8882 --spring.profiles.active=production
	$ curl http://localhost:8882/greeting
	Hello product managers
```
