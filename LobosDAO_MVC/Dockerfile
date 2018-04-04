FROM java:latest
COPY . /losLobos/
WORKDIR /losLobos/bin/
 
RUN cd .. && javac src/Model/*.java -d bin/

CMD ["java","-classpath","../lib/mysql-connector-java-5.1.46-bin.jar:","Model.principal"]


