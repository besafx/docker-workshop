pipeline {
    agent none 
    stages {
        stage('Building Image') {
            agent { docker 'maven:3.5.2-jdk-9' } 
            steps {
                echo 'Building Image'
                sh 'mvn clean package -DskipTests -Djavax.net.ssl.trustStorePassword=changeit'
            }
        }
    }
}