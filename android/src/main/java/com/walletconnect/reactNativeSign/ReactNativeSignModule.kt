package com.walletconnect.reactNativeSign

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import expo.modules.kotlin.records.Record
import expo.modules.kotlin.records.Field
import com.walletconnect.sign.client.Sign
import com.walletconnect.sign.client.SignClient

// -- Event constants ------------------------------------------------------------ //
private var SESSION_PROPOSAL_EVENT = "session_proposal"

class ReactNativeSignModule : Module() {
  override fun definition() = ModuleDefinition {

    Name("ReactNativeSign")
    Events(SESSION_PROPOSAL_EVENT)

    // -- Records ---------------------------------------------------------------- //
    class MetadataOptions: Record {
      @Field
      val name: String = ""
      @Field
      val description: String = ""
      @Field
      val url: String = ""
      @Field
      val icons: List<String> = listOf()
    }

    class InitOptions: Record {
      @Field
      val relayServerUrl: String = "wss://relay.walletconnect.com"
      @Field
      val projectId: String = ""
      @Field
      val metadata: MetadataOptions = MetadataOptions()
    }

    // -- Delegates -------------------------------------------------------------- //
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

    // -- Lifecycle hooks -------------------------------------------------------- //
    OnCreate {
      SignClient.setWalletDelegate(walletDelegate)
      SignClient.setDappDelegate(dappDelegate)
    }

    // -- Functions -------------------------------------------------------------- //
    Function("init") { options: InitOptions ->
      val initString = Sign.Params.Init(
        application = appContext.currentActivity!!.application,
        connectionType = Sign.ConnectionType.AUTOMATIC,
        relayServerUrl = options.relayServerUrl,
        metadata = Sign.Model.AppMetaData(
          name = options.metadata.name,
          description = options.metadata.description,
          url = options.metadata.url,
          icons = options.metadata.icons
        )
      )
      SignClient.initialize(initString) { error ->
        throw error.throwable
      }
    }

  }
}
