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

pprint.pprint(timestamp_to_passtime)

total = sum(timestamp_to_passtime.values())
average = total / len(timestamp_to_passtime)

print(total, average)
