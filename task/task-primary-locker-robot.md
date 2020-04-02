### store bag

- given locker available 
  when robot store bag
  then return ticket
  
- given locker 1 full and locker 2 available
  when robot store bag
  then return ticket

- given all lockers available
  when robot store bag
  then return ticket and bag should store in first locker
  
- given all lockers full
  when robot store bag
  then throw error
  
### retrieve bag

- given valid ticket
  when retrieve bag by robot
  then return bag
  
- given invalid ticket
  when retrieve bag by robot
  then throw error
  
- given duplicate ticket 
  when retrieve bag by robot
  then throw error
