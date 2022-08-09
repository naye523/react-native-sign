import { IEngine, SignClientTypes } from '@walletconnect/types';
export declare type SessionProposalEvent = SignClientTypes.EventArguments['session_proposal'];
export interface InitArguments {
    projectId: Pick<SignClientTypes.Options, 'projectId'>;
    relayUrl?: Pick<SignClientTypes.Options, 'relayUrl'>;
    metadata?: Pick<SignClientTypes.Options, 'metadata'>;
}
export declare type InitFunc = (args: InitArguments) => Promise<void>;
export declare type PairFunc = IEngine['pair'];
