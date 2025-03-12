def call() {
    def NVM_DIR = '/var/lib/jenkins/.nvm'  // NVM ka path jahan node versions installed hain

    stage('Build the Application') {
        sh """#!/bin/bash
            set -e  # Yeh ensure karega ki error aaye toh pipeline fail ho turant

            export NVM_DIR="${NVM_DIR}"
            [ -s "$NVM_DIR/nvm.sh" ] && source "$NVM_DIR/nvm.sh"  # NVM ko load kar rahe ho

            nvm use 16  # Node.js version 16 use kar rahe ho

            export NODE_OPTIONS=--max-old-space-size=4096  # Memory allocation increase
            npm install  # Dependencies install kar rahe ho

            CI=false npm run build  # React build run kar rahe ho (CI flag false rakha hai)
        """
    }

    stage('Start the Application') {
        sh """#!/bin/bash
            set -e

            export NVM_DIR="${NVM_DIR}"
            [ -s "$NVM_DIR/nvm.sh" ] && source "$NVM_DIR/nvm.sh"

            nvm use 16

            npm start  # React app ko start kar rahe ho
        """
    }
}
