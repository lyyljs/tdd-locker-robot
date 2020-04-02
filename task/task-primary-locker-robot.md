### save bag

- given locker available 
  when robot save bag
  then return ticket
  
- given locker 1 full and locker 2 available
  when robot save bag
  then return ticket

- given all lockers available
  when robot save bag
  then return ticket and bag should save in first locker
  
- given all lockers full
  when robot save bag
  then throw error
  
### get bag

- given valid ticket
  when get bag by robot
  then return bag
  
- given invalid ticket
  when get bag by robot
  then throw error
  
- given duplicate ticket 
  when get bag by robot
  then throw error
