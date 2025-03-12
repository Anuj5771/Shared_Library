def call() {
    stage('Build the Application') {
        // Set NODE_OPTIONS for OpenSSL legacy provider
        sh 'export NODE_OPTIONS=--openssl-legacy-provider && make build'
    }

    stage('Start the Application') {
        // Run npm start
        sh 'npm start'
    }
}
