#!/usr/bin/env groovy

def call(String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin localhost:8083"
        sh "docker push $imageName"
    }
}