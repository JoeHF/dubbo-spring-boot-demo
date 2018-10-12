pipeline {
    environment {
        dockerImage = ''
    }
    agent none
    tools {
        maven 'maven-3.5.4'
    }
    stages {
        stage('Build Project') {
            // agent {
            //     docker {
            //         image 'maven:3-alpine'
            //         args '-v /root/.m2:/root/.m2'
            //     }
            // }
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
