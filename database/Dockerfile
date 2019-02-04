#---------------------------------------------------------#
#                                                         #
# Stage 1: Setup Postgres Database                        #
#                                                         #
#---------------------------------------------------------#
FROM postgres:11
ENV POSTGRES_USER root
ENV POSTGRES_PASSWORD root
ENV POSTGRES_DB world-db
ADD scripts/*.sql /docker-entrypoint-initdb.d/
COPY docker-healthcheck /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-healthcheck
HEALTHCHECK CMD ["docker-healthcheck"]
