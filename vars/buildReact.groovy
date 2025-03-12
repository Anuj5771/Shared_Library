def call() {
    def NVM_DIR = '/var/lib/jenkins/.nvm'

    stage('Build the Application') {
        sh """#!/bin/bash
            export NVM_DIR="${NVM_DIR}"
            [ -s "$NVM_DIR/nvm.sh" ] && source "$NVM_DIR/nvm.sh"
            nvm use 16
            export NODE_OPTIONS=--max-old-space-size=4096
            npm install
            CI=false npm run build  // <-- Yeh line change ki hai
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
