def call() {
    stage('Build the Application') {
        sh '''
            echo "Building React app with legacy OpenSSL provider..."
            NODE_OPTIONS=--openssl-legacy-provider CI=false make build
        '''
    }

    stage('Start the Application') {
        sh '''
            echo "Starting app with legacy OpenSSL provider..."
            NODE_OPTIONS=--openssl-legacy-provider npm start
        '''
    }
}
