pipeline {
    agent none 
    stages {
        stage('Runing Image'){
            agent{ docker 'openjdk:9'}
            steps{
                echo 'Launching application'
                pwd()
                sh 'java -jar target/app.jar'
            }
        }
    }
}