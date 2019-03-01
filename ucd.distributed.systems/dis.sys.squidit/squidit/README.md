There are 6 modules to build, one Eureka server and the rest all register themselves to Eureka
To build all modules, in the squidit directory run: 

mvn clean install

The jar files have been deliberately kept seperate so each module can be run independently 
Running Eureka
java -jar eureka-0.0.1-SNAPSHOT.jar;

Running mongoServer1
java -jar mongo-server1-0.0.1.jar;

Running mongoServer2
java -jar mongo-server2-0.0.1.jar;

Running mongoServer3
java -jar mongo-server3-0.0.1.jar;

Running 
java -jar web-0.0.1-SNAPSHOT.jar;

Running Monitor
java -jar monitor-0.0.1-SNAPSHOT.jar;

1111 = eureka
3333 = web
4444 = server1
5555 = server2
6666 = server3
7777 = monitor

// Databases : Mongo
27019 - server3
27018 - server2
27017 - server1 
