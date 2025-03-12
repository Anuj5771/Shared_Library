def call() {
    def NVM_DIR = '/var/lib/jenkins/.nvm'

    stage('Build the Application') {
        sh """#!/bin/bash
            export NVM_DIR="${NVM_DIR}"
            [ -s "$NVM_DIR/nvm.sh" ] && source "$NVM_DIR/nvm.sh"
            nvm use 16
            # Removed NODE_OPTIONS line
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
