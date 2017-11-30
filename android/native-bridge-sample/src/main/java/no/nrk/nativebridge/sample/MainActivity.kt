package no.nrk.nativebridge.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import no.nrk.nativebridge.sample.data.incoming.InGaConf
import no.nrk.nativebridge.sample.data.outgoing.OutGaConf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webview?.loadUrl("http://10.0.2.2:8080")

        webview?.connection?.addHandler("gaData", { _ : InGaConf, connection ->
                val gaConf = OutGaConf("35009a79-1a05-49d7-b876-2b884d0f825b")
                connection.send(gaConf, "gaData")
            }
        )
    }
}