#!/usr/bin/env groovy

import com.exaple.Docker

def call() {
    return new Docker(this).dockerLogin()
    }
