pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Stage 2') {
            steps {
                echo 'Hello, JDK'
            }
        }
    }
}
