import { InitFunc, PairFunc, SessionProposalEvent } from './ReactNativeSign.types';
export declare const init: InitFunc;
export declare const pair: PairFunc;
export declare function onSessionProposal(listener: (event: SessionProposalEvent) => void): import("expo-modules-core").Subscription;
export { SessionProposalEvent };
