#!/usr/bin/env groovy

package com.exaple

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin localhost:8083"
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"

    }
}
