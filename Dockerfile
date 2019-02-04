# Init Example Database World on PostgreSQL 11
FROM postgres:11

ENV POSTGRES_USER root
ENV POSTGRES_PASSWORD root
ENV POSTGRES_DB world-db

# Copier les scripts SQL dans : 
ADD src/main/resources/scripts/*.sql /docker-entrypoint-initdb.d/

# Copier les scripts d'init dans : 
#ADD scripts/*.sh /docker-entrypoint-initdb.d/

COPY docker-healthcheck /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-healthcheck

HEALTHCHECK CMD ["docker-healthcheck"]
