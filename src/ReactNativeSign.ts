import { EventEmitter, NativeModulesProxy, Subscription } from 'expo-modules-core'

import { ChangeEventPayload, ReactNativeSignViewProps } from './ReactNativeSign.types'
import ReactNativeSign from './ReactNativeSignModule'

export function hello(): string {
  return ReactNativeSign.hello()
}

export async function setValueAsync(value: string) {
  return await ReactNativeSign.setValueAsync(value)
}

const emitter = new EventEmitter(NativeModulesProxy.ReactNativeSign ?? ReactNativeSign)

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener)
}

export { ReactNativeSignViewProps, ChangeEventPayload }
