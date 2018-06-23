# Server languages

#### Coordination model
Utlizing multicore architecture to provide massive concurrency is a key design goal for server software engineering.
The coordination model of a language can stongly influence the performance achieved (make escaping the common pitcalls like deadlock , livelock).

1. Explicit concurrency

Using mutexs to protect shared resource in languages *Java*,*Rust*, *C with PThread*. This approach is relatively low level and can lead to problems, like race conditions, deadlock and livelock.  
2. [Actor concurrency][Actor Model]
Actor is the unit that does computation (recieve a message and do computation based on it). Actors are completedly isolate with each other and don't share memory. Used widely in langauge *Erlang*, *Elixir*, *the Akka Framework*.
3. Communication Sequential Process (CSP)


[Actor Model]: https://www.brianstorti.com/the-actor-model/
[CSP]:https://arild.github.io/csp-presentation/#11