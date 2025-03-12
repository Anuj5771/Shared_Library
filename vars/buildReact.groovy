def call() {
    stage('Install Dependencies') {
        sh 'npm install'
        sh 'npm audit fix --force'   // Yeh line add kari hai
    }
    
    stage('Build React App') {
        sh 'npm run build'
    }
}

