#!/usr/bin/env python3

import sys
import getopt
from collections import defaultdict


# ===============================================================================
# Core functions
# ===============================================================================

def read_time_diff(infilename):
    vins = set()
    max_time = defaultdict(float)
    min_time = defaultdict(float)
    diff_time = defaultdict(float)
    with open(infilename) as infile:
        if_first_line = True
        for s in infile:
            if if_first_line:
                if_first_line = False
            else:
                d = s.strip().split(',')
                vin = d[0]
                t = float(d[1])
                vins.add(vin)
                max_time[vin] = max(t, max_time[vin])
                if vin in min_time:
                    min_time[vin] = min(t, min_time[vin])
                else:
                    min_time[vin] = t
    for vin in vins:
        diff_time[vin] = max_time[vin] - min_time[vin]

    return diff_time


def avg_time_diff(diff_time):
    return sum(diff_time.values()) / len(diff_time)


# ===============================================================================
# Main
# ===============================================================================

def usage():
    print("Usage:")
    print("   ", sys.argv[0], "datafile.csv")
    print("   ", sys.argv[0], "[-h|--help]")


def main():
    global baseline_filename
    global base_time
    try:
        opts, args = getopt.getopt(sys.argv[1:], "h:", ["help"])
    except getopt.GetoptError as err:
        print(err)
        usage()
        exit(2)
    for o, a in opts:
        if o in ("-h", "--help"):
            usage()
            exit()
        else:
            assert False, "unhandled option"
    if len(args) == 0:
        usage()
        exit(2)
    print(format(avg_time_diff(read_time_diff(args[0])), '.4f'))


if __name__ == "__main__":
    main()
