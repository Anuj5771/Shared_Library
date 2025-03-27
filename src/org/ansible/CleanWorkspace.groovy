package org.ansible

def call() {
    stage ('CleanWorkspace')
         cleanWs()
     }
