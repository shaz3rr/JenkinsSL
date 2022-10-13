#!/usr/bin/env groovy

import com.exaple.Docker

def call(String imageName) {
    return new Docker(this).dockerPush(imageName)
    }
