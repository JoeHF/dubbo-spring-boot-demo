pipeline {
    environment {
        dockerImage = ''
    }
    agent any
    tools {
        maven 'maven-3.5.4'
    }
    stages {
        stage('Build Project') {
            steps {
                echo 'Hello world!'
                sh 'mvn -B -DskipTests package'
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
        stage('Push Docker Image') {
            steps {
                script {
                    echo "Push docker image to dockerhub"
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        dockerImage.push("${env.BUILD_NUMBER}")
                        dockerImage.push("latest")
                    }
                }
            }
        }
    }
}
