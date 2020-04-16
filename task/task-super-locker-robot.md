### 业务需求

作为一个超级储物柜机器人，我能够将包存在空置率最高的那个储物柜，并可以取出。
作业要求
要有面向问题域的Tasking，将task结果存放在task目录中，文件命名为task-super-locker-robot.md
采用TDD的方式编码
小步提交
PS：继续在你使用上一个需求的代码库，上做提交，需要创建新的分支，分支命名为：SuperLockerRobot


### store bag

- given locker 1 vacancy rate less than locker 2
  when super robot store bag
  then return ticket and bag should store in locker 2

- given locker 1 vacancy rate more than locker 2
  when super robot store bag
  then return ticket and bag should store in locker 1
  
- given locker 1 vacancy rate equal to locker 2
  when super robot store bag
  then return ticket and bag should store in locker 1
  
- given all lockers full
  when super robot store bag
  then throw locker full exception

### retrieve bag

- given valid ticket
  when retrieve bag by superRobot
  then return bag
  
- given invalid ticket
  when retrieve bag by superRobot
  then throw invalid ticket exception
  
- given reused ticket 
  when retrieve bag by superRobot
  then throw invalid ticket exception
