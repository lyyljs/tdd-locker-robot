### store bag

- given locker 1 rest capacity less than locker 2
  when smart robot store bag
  then return ticket and bag should store in locker 2

- given locker 1 rest capacity more than locker 2
  when smart robot store bag
  then return ticket and bag should store in locker 1
  
- given locker 1 rest capacity equal to locker 2
  when smart robot store bag
  then return ticket and bag should store in locker 1
  
- given all lockers full
  when smart robot store bag
  then throw locker full exception

### retrieve bag

- given valid ticket
  when retrieve bag by smartRobot
  then return bag
  
- given invalid ticket
  when retrieve bag by smartRobot
  then throw invalid ticket exception
  
- given reused ticket 
  when retrieve bag by smartRobot
  then throw invalid ticket exception
