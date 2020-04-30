I have Todo as one TODO instance and TodoList that represents list of Todo.  
This implementation allows to persist TodoLists and separate Todos. Concrete strategy is determined by underlying storage:  
1. if the underlying storage supports extraction and persisting of single Todo then use Todo;  
2. otherwise wrap them into TodoList.  