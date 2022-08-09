import { EventEmitter, NativeModulesProxy } from 'expo-modules-core';
import ReactNativeSign from './ReactNativeSignModule';
// Methods
export const init = async (args) => {
    return await ReactNativeSign.init(args);
};
export const pair = async (args) => {
    return await ReactNativeSign.pair(args);
};
// Events
const emitter = new EventEmitter(NativeModulesProxy.ReactNativeSign ?? ReactNativeSign);
export function onSessionProposal(listener) {
    return emitter.addListener('session_proposal', listener);
}
//# sourceMappingURL=ReactNativeSign.js.map