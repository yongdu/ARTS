## Java thread
A thread goes through various stages in its life cycle, from born, started, run to die. 

![Thread cycle](images/Thread_Life_Cycle.jpg)

New: a new thread begins its life cycle in the new state. It remains in this state until program starts the thread.

Runnable: After the thread is started, the thread becomes runnable. the run () methon will be invoked.

Waiting: the thread wait fo another thread to preform a task

Terminate: A runnable thread enters the ternimated state when it completes its task.

 When having the Runnable's executed by a thread pool it is easy to queue up the Runnable instances until a thread from the pool is idle. This is a little harder to do with Thread subclasses.

 **Common Pitfall**: Calling run() Instead of start()
When creating and starting a thread a common mistake is to call the run() method of the Thread instead of start(), like this:

```
 Thread newThread = new Thread(MyRunnable());
  newThread.run();  //should be start();
```
 
A newThread.start()  method will invoke the run method.

2 ways to create a thread

*by implement runnable interface*
1. implement the *run()* method
`public void run()`
2. instantiate a thread object by using follow constructor
`Thread(Runnable threadObj, String threadName)`
3. once a thread object is created, start it by calling *start()* method, which executes a call to *run()* method


*by extending thread class*
1. override *run()* method in thread class, put the business logic here
2. once the thread object is created, start it by calling *start()* method

