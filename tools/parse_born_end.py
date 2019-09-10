#!/usr/bin/env python3

import datetime
import time
import sys
import pprint


vin_to_born_time = {}
timestamp_to_passtime = {}
time_pattern='%Y-%m-%d-%H:%M:%S.%f'

init_time = -1

for line in sys.stdin:
  record = line.split()
  timestamp = datetime.datetime.strptime(record[0], time_pattern).timestamp()
  if init_time == -1:
    init_time = timestamp

  vin = record[1]
  if vin not in vin_to_born_time:
    vin_to_born_time[vin] = timestamp
  else:
    timestamp_to_passtime[timestamp-init_time] = timestamp - vin_to_born_time[vin]

# pprint.pprint(timestamp_to_passtime)

total = sum(timestamp_to_passtime.values())
average = total / len(timestamp_to_passtime)

print(total, average)

cnt = 0
sums = 0
last_time = -1
timestep=3
for ts in timestamp_to_passtime:
  cnt += 1
  sums += timestamp_to_passtime[ts]
  if last_time == -1: 
    last_time = ts//timestep
  if last_time != ts//timestep:
    last_time = ts//timestep
    print("({}, {:.2f})".format(last_time*timestep, sums/cnt), end=" ")
