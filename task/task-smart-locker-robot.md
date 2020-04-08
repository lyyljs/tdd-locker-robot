### store bag

- given locker 1 rest capacity less than locker 2
  when smart robot store bag
  then return ticket and bag should store in locker 2

- given locker 1 rest capacity more than locker 2
  when smart robot store bag
  then return ticket and bag should store in locker 1
  
- given all lockers full
  when smart robot store bag
  then throw error

### retrieve bag

- given valid ticket
  when retrieve bag by primaryRobot
  then return bag
  
- given invalid ticket
  when retrieve bag by primaryRobot
  then throw error
  
- given duplicate ticket 
  when retrieve bag by primaryRobot
  then throw error
