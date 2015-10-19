package com.example

class PingController {
    def index() {
        render(status: 200, text: '{"status": "UP"}')
    }
}
