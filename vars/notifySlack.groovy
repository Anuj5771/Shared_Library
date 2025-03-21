def call(String channel, String color, String message) {
    slackSend (
        channel: channel,
        color: color,
        message: message
    )
}
