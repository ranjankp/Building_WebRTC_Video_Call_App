package com.example.vidcallapp

import android.webkit.JavascriptInterface

class JavascriptInterface( val callActivity: CallActivity){
    @JavascriptInterface
    public fun onPeerConnected() {
        callActivity.onPeerConnected()
    }
}