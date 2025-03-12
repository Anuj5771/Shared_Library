def call() {
    stage('Build the Application') {
        sh 'make build'
    }

    stage('Start the Application') {
        sh 'npm start'
    }
}
