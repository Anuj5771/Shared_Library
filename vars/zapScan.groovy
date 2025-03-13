def call(Map params = [:]) {
    def zapURL = params.get('zapURL', 'http://default-url.com')
    def reportPath = params.get('reportPath', '/home/ubuntu/report.html')

    sh """
        zap.sh -cmd -quickurl ${zapURL} -quickout ${reportPath}
    """

    echo "ZAP Scan done! Report at ${reportPath}"
}
