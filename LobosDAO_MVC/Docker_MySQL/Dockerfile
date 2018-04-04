FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=12345
ENV MYSQL_DATABASE=Universidad

ADD ["schemaDB.sql", "/docker-entrypoint-initdb.d"]




