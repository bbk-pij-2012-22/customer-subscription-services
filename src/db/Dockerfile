FROM mysql:8

LABEL MANTAINER marshall_gj@hotmail.com

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=customer_subscription_db
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root

COPY ./schema/ /docker-entrypoint-initdb.d/
COPY ./data /docker-entrypoint-initdb.d/
