pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build Project') {
            steps {
                echo 'Hello world!'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo 'build image start'
            }
        }
        stage('Push image') {
            environment {
                app = docker.build("joehou/dubbo-provider")
            }
            steps {
                echo "push"
                docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                    app.push("${env.BUILD_NUMBER}")
                    app.push("latest")
                }
            }
        }
    }
}
