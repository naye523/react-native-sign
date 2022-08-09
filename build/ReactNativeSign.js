import { EventEmitter, NativeModulesProxy } from 'expo-modules-core';
import ReactNativeSign from './ReactNativeSignModule';
export function hello() {
    return ReactNativeSign.hello();
}
export async function setValueAsync(value) {
    return await ReactNativeSign.setValueAsync(value);
}
const emitter = new EventEmitter(NativeModulesProxy.ReactNativeSign ?? ReactNativeSign);
export function addChangeListener(listener) {
    return emitter.addListener('onChange', listener);
}
//# sourceMappingURL=ReactNativeSign.js.map