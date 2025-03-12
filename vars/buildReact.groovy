def call() {
    stage('Build the Application') {
        sh '''
            export NODE_OPTIONS=--openssl-legacy-provider
            make build
        '''
    }

    stage('Start the Application') {
        sh 'npm start'
    }
}
