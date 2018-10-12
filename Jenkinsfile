pipeline {
    environment {
        dockerImage = ''
    }
    agent none
    stages {
        stage('Build Project') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                echo 'Hello world!'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Build Docker Image') {
            steps{
                script {
                    echo 'Build docker image'
                    dockerImage = docker.build("joehou/dubbo-provider")
                }
              }
        }
        stage('push Docker Image') {
            steps {
                echo 'build image start'
                script {
                    echo "Push docker image"
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        dockerImage.push("${env.BUILD_NUMBER}")
                        dockerImage.push("latest")
                    }
                }
            }
        }
    }
}
