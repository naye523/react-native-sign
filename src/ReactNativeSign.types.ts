import { IEngine, SignClientTypes } from '@walletconnect/types'

// Events
export type SessionProposalEvent = SignClientTypes.EventArguments['session_proposal']

// Arguments
export interface InitArguments {
  projectId: Pick<SignClientTypes.Options, 'projectId'>
  relayUrl?: Pick<SignClientTypes.Options, 'relayUrl'>
  metadata?: Pick<SignClientTypes.Options, 'metadata'>
}

// Functions
export type InitFunc = (args: InitArguments) => Promise<void>
export type PairFunc = IEngine['pair']
