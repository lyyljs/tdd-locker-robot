### store bag

- given locker 1 rest capacity less than locker 2
  when robot store bag
  then return ticket and bag should store in locker 2

- given locker 1 rest capacity more than locker 2
  when robot store bag
  then return ticket and bag should store in locker 1
  
- given all lockers full
  when robot store bag
  then throw error
