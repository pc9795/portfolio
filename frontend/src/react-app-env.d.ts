/// <reference types="react-scripts" />
type BooleanSetter = (x: boolean) => void
type NumberSetter = (x: number) => void

interface Pageable<T> {
    content: T[]
}