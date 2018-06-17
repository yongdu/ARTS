## Java thread
A thread goes through various stages in its life cycle, from born, started, run to die. 

![Thread cycle](images/Thread_Life_Cycle.jpg)

New: a new thread begins its life cycle in the new state. It remains in this state until program starts the thread.

Runnable: After the thread is started, the thread becomes runnable. the run () methon will be invoked.

Waiting: the thread wait fo another thread to preform a task

Terminate: A runnable thread enters the ternimated state when it completes its task.