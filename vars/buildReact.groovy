def call() {
    stage('Build') {
        sh 'make build'
    }
}
