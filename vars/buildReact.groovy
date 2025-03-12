def call() {
    stage('Build the Application') {
        sh '''
            export NVM_DIR="$HOME/.nvm"
            source "$NVM_DIR/nvm.sh"
            nvm use 16
            npm install
            npm run build
        '''
    }

    stage('Start the Application') {
        sh '''
            export NVM_DIR="$HOME/.nvm"
            source "$NVM_DIR/nvm.sh"
            nvm use 16
            npm start
        '''
    }
}
