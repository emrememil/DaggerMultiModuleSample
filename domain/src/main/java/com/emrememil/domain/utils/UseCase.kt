package com.emrememil.domain.utils

abstract class UseCase<in P, R> {

    suspend operator fun invoke(p: P): R {
        return execute(p)
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R

}

suspend operator fun <R> UseCase<Unit, R>.invoke(): R = this(Unit)