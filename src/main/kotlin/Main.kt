package org.example

enum class Singleton1 {
    INSTANCE;
    fun doSomething() = "Doing something"
}

object Singleton2 {
    fun doSomething() = "Doing something"
}
class Singleton {
    companion object {
        @Volatile
        private var instance: Singleton? = null
        fun getInstance(): Singleton {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Singleton()
                    }
                }
            }
            return instance!!
        }
    }

    fun doSomething() = "Doing something"
}

fun main() {
    val singleton1 = Singleton.getInstance()
    val singleton2 = Singleton.getInstance()
    val singleton3 = Singleton1.INSTANCE
    val singleton4 = Singleton2

    val result1 = singleton1.doSomething()
    val result2 = singleton2.doSomething()
    val result3 = singleton3.doSomething()
    val result4 = singleton4.doSomething()

    println("Result from singleton1: $result1")
    println("Result from singleton2: $result2")
    println("Result from singleton3: $result3")
    println("Result from singleton4: $result4")

    println(singleton1 == singleton2)
}
