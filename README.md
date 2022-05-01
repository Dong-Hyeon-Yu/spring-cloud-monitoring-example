# :star: 모니터링과 JVM heap 튜닝을 곁들인 MSA 예시 :star:

▪️ Release Trains : `2021.0.1` (https://spring.io/projects/spring-cloud) <br></br>
▪️ Java : `openjdk-11`<br></br>
▪️ Spring Boot : 2.6.6 <br></br>
▪️ Gradle : 7.4 <br></br>
▪️ OS : linux 20.04.4 LTS <br></br>
▪️ IDE : IntelliJ IDEA Ultimate Edition <br></br>
▪️ Spring Cloud 구성요소
  - `spring-cloud-eureka-server`
  - `spring-cloud-gateway`
  - `spring-cloud-config`
  - `spring-cloud-openfeign`
  - `springdoc-openapi-ui:1.6.0`
<br></br>

#### ▪️ 모니터링 툴 (monitoring tools)
  - `prometheus` :9090 포트로 접속
  - `grafana`  : 3000 포트로 접속
  - `docker-compose`

#
#### ▪️ Test EndPoint
  : `localhost:8080/api/member` (gateway) -> (resoure-service) 

#
#### 💡 실행 주의사항(notice for execution) 💡
  : `spring-cloud-config` 를 먼저 실행시켜야, 나머지 JVM 인스턴스가 떴을때 설정파일을 받을 수 있음  
  (you must execute 'spring-cloud-config' first so that the other services get it's own application.yml files)<br></br>
  : 모니터링을 위해서는 `docker-compose` 를 이용해서 컨테이너를 띄워야함. (.monitor 폴더에 위치)  
  (you should do docker-compose up for monitoring under '.monitor' folder)
#
#### 👀 [모니터링 예시 - `jvm(Micrometer)`] 👀 
![스크린샷, 2022-04-04 21-14-11](https://user-images.githubusercontent.com/81698076/166152593-81ab4819-fe4d-4883-b0fd-c063a154f446.png)

#### 👀 [모니터링 예시 - `node_exporter`] 👀 
![스크린샷, 2022-04-04 21-14-24](https://user-images.githubusercontent.com/81698076/166152600-ed819a39-a4e3-4e00-a890-f3573118879b.png)

#
#### ✏️ [jvm 힙 덤프 분석해보기] (Analyzing JVM heap dump)
  : 아래 명령어로 덤프파일 생성 후, [Eclipse Memory Analyzer(MAT)](https://www.eclipse.org/mat/) 로 열어서 확인  
  (After creating a dumpfile using command lines below, open the file with 'Eclipse Memory Analyzer')
```bash
~$ jps  # jvm 프로세스 id를 알아내는 명령어 (finding all jvm pid)
85887 config service 
84762 discovery service
...(생략)...

~$ jmap -dump:format=b,file=heapdump.hprof 85887  # heapdump 파일 생성 명령어 (create heapdump files)

```
![스크린샷, 2022-04-24 20-19-46](https://user-images.githubusercontent.com/81698076/166153011-7ddfdeec-de80-484d-a1fe-e5fcf01717f4.png)
