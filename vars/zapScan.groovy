def call(Map params = [:]) {
    def zapURL = params.get('zapURL', 'http://default-url.com')
    def reportPath = params.get('reportPath', '/home/ubuntu/report.html')
    def zapPort = params.get('zapPort', '10000')  // DEFAULT PORT AB 10000 KAR DIYA

    sh """
        zap.sh -cmd -port ${zapPort} -quickurl ${zapURL} -quickout ${reportPath}
    """

    echo "ZAP Scan done! Report at ${reportPath}"
}
