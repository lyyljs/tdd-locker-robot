### store bag

- given locker available 
  when primaryRobot store bag
  then return ticket
  
- given locker 1 full and locker 2 available
  when primaryRobot store bag
  then return ticket

- given all lockers available
  when primaryRobot store bag
  then return ticket and bag should store in first locker
  
- given all lockers full
  when primaryRobot store bag
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
