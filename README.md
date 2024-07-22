# TaskProcessor
System to process tasks using a doubly linked priority queue and a dynamic stack.
- The priority queue is used to add new tasks with their respective priorities.
- The stack is used to store tasks in progress, where the last task added will be the next one to be processed.
- Implements the following methods in the `TaskProcessor` class:
  - `addTask(String task, int priority)`: Adds a new task to the priority queue.
  - `startTask()`: Moves the highest priority task from the priority queue to the stack of tasks in progress.
  - `completeTask()`: Completes the task currently at the top of the stack of tasks in progress.
  - `listTasksInProgress()`: Returns a list of tasks that are currently in progress.
  - `listPendingTasks()`: Returns a list of pending tasks in the priority queue.
