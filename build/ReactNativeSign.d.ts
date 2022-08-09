import { Subscription } from 'expo-modules-core';
import { ChangeEventPayload, ReactNativeSignViewProps } from './ReactNativeSign.types';
export declare function hello(): string;
export declare function setValueAsync(value: string): Promise<any>;
export declare function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription;
export { ReactNativeSignViewProps, ChangeEventPayload };
