FROM mysql:5.7

# Environment variables
ENV MYSQL_ROOT_PASSWORD tiger

# Create Database
RUN	mkdir /usr/sql
RUN	chmod 644 /usr/sql

COPY ./mysql/script.sql /usr/sql/script.sql
ADD /mysql/script.sql /usr/sql/script.sql

RUN /etc/init.d/mysql start && \
        mysql -u root -p${MYSQL_ROOT_PASSWORD} -e "CREATE DATABASE Ecole" && \
    	mysql -u root -p${MYSQL_ROOT_PASSWORD} -D Ecole < /usr/sql/sources.sql && \
    	rm -rd /usr/sql
