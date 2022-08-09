import { EventEmitter, NativeModulesProxy } from 'expo-modules-core'

import { InitFunc, PairFunc, SessionProposalEvent } from './ReactNativeSign.types'
import ReactNativeSign from './ReactNativeSignModule'

// Methods
export const init: InitFunc = async args => {
  return await ReactNativeSign.init(args)
}

export const pair: PairFunc = async args => {
  return await ReactNativeSign.pair(args)
}

// Events
const emitter = new EventEmitter(NativeModulesProxy.ReactNativeSign ?? ReactNativeSign)

export function onSessionProposal(listener: (event: SessionProposalEvent) => void) {
  return emitter.addListener<SessionProposalEvent>('session_proposal', listener)
}

export { SessionProposalEvent }
