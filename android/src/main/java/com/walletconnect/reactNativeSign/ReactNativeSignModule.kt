package com.walletconnect.reactNativeSign

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import com.walletconnect.sign.client.Sign
import com.walletconnect.sign.client.SignClient

// Event name constants
private var SESSION_PROPOSAL_EVENT = "session_proposal"

class ReactNativeSignModule : Module() {
  override fun definition() = ModuleDefinition {
    
    // Definitions
    Name("ReactNativeSign")
    Events(SESSION_PROPOSAL_EVENT)

    // Delegates
    val walletDelegate = object : SignClient.WalletDelegate {
      override fun onConnectionStateChange(state: Sign.Model.ConnectionState) {
        TODO("Not yet implemented")
      }

      override fun onError(error: Sign.Model.Error) {
        TODO("Not yet implemented")
      }

      override fun onSessionDelete(deletedSession: Sign.Model.DeletedSession) {
        TODO("Not yet implemented")
      }

      override fun onSessionProposal(sessionProposal: Sign.Model.SessionProposal) {
        sendEvent(SESSION_PROPOSAL_EVENT)
      }

      override fun onSessionRequest(sessionRequest: Sign.Model.SessionRequest) {
        TODO("Not yet implemented")
      }

      override fun onSessionSettleResponse(settleSessionResponse: Sign.Model.SettledSessionResponse) {
        TODO("Not yet implemented")
      }

      override fun onSessionUpdateResponse(sessionUpdateResponse: Sign.Model.SessionUpdateResponse) {
        TODO("Not yet implemented")
      }
    }
    
    val dappDelegate = object : SignClient.DappDelegate {
      override fun onConnectionStateChange(state: Sign.Model.ConnectionState) {
        TODO("Not yet implemented")
      }

      override fun onError(error: Sign.Model.Error) {
        TODO("Not yet implemented")
      }

      override fun onSessionApproved(approvedSession: Sign.Model.ApprovedSession) {
        TODO("Not yet implemented")
      }

      override fun onSessionDelete(deletedSession: Sign.Model.DeletedSession) {
        TODO("Not yet implemented")
      }

      override fun onSessionEvent(sessionEvent: Sign.Model.SessionEvent) {
        TODO("Not yet implemented")
      }

      override fun onSessionExtend(session: Sign.Model.Session) {
        TODO("Not yet implemented")
      }

      override fun onSessionRejected(rejectedSession: Sign.Model.RejectedSession) {
        TODO("Not yet implemented")
      }

      override fun onSessionRequestResponse(response: Sign.Model.SessionRequestResponse) {
        TODO("Not yet implemented")
      }

      override fun onSessionUpdate(updatedSession: Sign.Model.UpdatedSession) {
        TODO("Not yet implemented")
      }
    }

    // Lifecycle hooks
    OnCreate {
      SignClient.setWalletDelegate(walletDelegate)
      SignClient.setDappDelegate(dappDelegate)
    }

    // Functions
    Function("init") {
      val initString = Sign.Params.Init(
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
      SignClient.initialize(initString) { error ->
        throw error.throwable
      }
    }

  }
}
