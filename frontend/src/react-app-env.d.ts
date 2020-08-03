/// <reference types="react-scripts" />
type BooleanSetter = (x: boolean) => void
type NumberSetter = (x: number) => void

interface Page<T> {
    content: T[]
}