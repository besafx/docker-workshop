pipeline {
    agent none 
    stages {
        stage('Runing Postgres Server'){
            agent { 
                docker {
                    image 'postgres:11'
                    args '-p 5030:5432'
                }
            }
            environment {
                POSTGRES_USER = 'root'
                POSTGRES_PASSWORD = 'root'
                POSTGRES_DB = 'world-db'
            }
            steps{
                sh 'chmod +x database/docker-healthcheck'
                echo 'Server Runing on port 5030'
            }
        }
        stage('Building Image') {
            agent { docker 'maven:3.5.2-jdk-9' } 
            steps {
                echo 'Building image...'
                sh 'mvn clean package -DskipTests -Djavax.net.ssl.trustStorePassword=changeit'
                echo 'Building image successfully'
            }
        }
        stage('Runing Image'){
            agent{ docker 'openjdk:9'}
            steps{
                echo 'Launching application'
                sh 'java -jar target/app.jar'
            }
        }
    }
}