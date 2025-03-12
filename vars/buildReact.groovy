def call() {
    def NVM_DIR = '/var/lib/jenkins/.nvm'  // Absolute path is safer in Jenkins

    stage('Build the Application') {
        sh """#!/bin/bash
            export NVM_DIR="${NVM_DIR}"
            [ -s "$NVM_DIR/nvm.sh" ] && source "$NVM_DIR/nvm.sh"
            nvm use 16
            export NODE_OPTIONS=--openssl-legacy-provider
            npm install
            npm run build
        """
    }

    stage('Start the Application') {
        sh """#!/bin/bash
            export NVM_DIR="${NVM_DIR}"
            [ -s "$NVM_DIR/nvm.sh" ] && source "$NVM_DIR/nvm.sh"
            nvm use 16
            npm start
        """
    }
}
