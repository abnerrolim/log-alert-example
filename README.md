# log-alert-example
A very simple PoC using spring-boot, Slf4j and l4j2 to create alerts when any log is called using a specific mark. In this project alerts will be sent by email, but any appender can be used (Kafka, Http, etc).  

A possible scenario can be proactive alerts to dev team when a severe error occur, like database connection failure and so on.

## Components

* MDCFilter: shows the use of Slf4j MDC to log context across request
* LogUtils: just a standard mark builder
* Controller: Dummy REST controller simulating business layers.
* log4j2-spring.xml: configurations

## Start 
1. Inject into enviroment the variables to STMPAppender's configuration:
    * receipients
    * from
    * smtpHost
    * smtpPort
    * smtpUser
    * smtpProtocol
    * smtpPassword

2. Start log-alert-example.jar
3. Call http://localhost:8080/log-alert/log/{severe} where {severe} is just a boolean to simulate a severe error log.

If all configs are correct an email will arrive as bellow:

```
28-02-2018 17:14:26,819 INFO  br.org.test.Application context:{} Starting Application on abner-pc with PID 17745 (/home/workspace/log-alert-example/target/classes started by abner in /home/workspace/log-alert-example)
28-02-2018 17:14:26,822 INFO  br.org.test.Application context:{} No active profile set, falling back to default profiles: default
28-02-2018 17:14:28,383 INFO  br.org.test.Application context:{} Started Application in 2.554 seconds (JVM running for 3.166)
28-02-2018 17:14:33,972 ERROR br.org.test.controller.Controller context:{x-global-id=933a4b7e-698d-45bd-b169-b15707e47371} A disaster has occurred into system. Alert support team, please
```