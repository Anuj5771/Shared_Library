def call() {
    stage('Build the Application') {
        sh '''
            export NODE_OPTIONS=--openssl-legacy-provider
            
            echo "Building React app with CI=false to ignore warnings..."
            CI=false make build
        '''
    }

    stage('Start the Application') {
        sh 'npm start'
    }
}
