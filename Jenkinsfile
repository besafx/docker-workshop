pipeline {
    agent none 
    stages {
        stage('Example Build') {
            agent { docker 'maven:latest' } 
            steps {
                echo 'Hello, Maven'
                sh 'mvn --version'
            }
        }
        stage('Example Test') {
            agent { docker 'openjdk:9' } 
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}