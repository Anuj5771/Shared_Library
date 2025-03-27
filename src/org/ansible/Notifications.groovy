package org.ansible

def call(String jobName, String buildNumber, String buildUrl, String emailRecipients, String channelName, boolean isSuccess) {
    stage('Notifications') {
        if (isSuccess) {
            slackSend(channel: channel_Name, color: 'good', username: 'Jenkins CI',
                      message: "✅ SUCCESS: Ansible Playbook Executed! Job: ${jobName}, Build: ${buildNumber}, URL: ${buildUrl}")

            emailext(
                attachmentsPattern: "*.txt",
                body: "The Jenkins job **${jobName}** completed successfully! Build: **#${buildNumber}**.",
                subject: "Jenkins SUCCESS: ${jobName} #${buildNumber}",
                to: email_Recipients
            )
            println "Success notification sent."
        } else {
            slackSend(channel: channel_Name, color: 'danger', username: 'Jenkins CI',
                      message: "❌ FAILURE: Ansible Playbook Execution Failed! Job: ${jobName}, Build: ${buildNumber}, URL: ${buildUrl}")

            emailext(
                attachmentsPattern: "*.txt",
                body: "The Jenkins job **${jobName}** failed! Build: **#${buildNumber}**. Check logs.",
                subject: "Jenkins FAILED: ${jobName} #${buildNumber}",
                to: email_Recipients
            )
            println "Failure notification sent."
        }
    }
}
