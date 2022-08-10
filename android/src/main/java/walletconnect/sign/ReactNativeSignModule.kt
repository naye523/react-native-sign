package walletconnect.sign

import android.util.Log

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

import com.walletconnect.sign.client.Sign
import com.walletconnect.sign.client.SignClient

class ReactNativeSignModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("ReactNativeSign")

    Events("session_proposal")

    Function("init") {
        val options = Sign.Params.Init(
          application = appContext.currentActivity!!.application,
          connectionType = Sign.ConnectionType.AUTOMATIC,
          relayServerUrl = "wss://",
          metadata = Sign.Model.AppMetaData(
            name = "Test App",
            description = "Test Description",
            url = "Tes utl",
            icons = listOf("1", "2")
          )
        )

      SignClient.initialize(options) { error ->
        throw error.throwable
      }
    }

  }
}
