#!/usr/bin/env python3

import sys
import getopt
from collections import defaultdict


# ===============================================================================
# Core functions
# ===============================================================================

def count_passthrough(infilename):
    passed_vins = set()
    vins = set()
    with open(infilename) as f:
        for line in f:
            d = line.strip().split(',')
            vin = d[0]
            if vin in vins:
                passed_vins.add(vin)
            else:
                vins.add(vin)

    print("all vins size: {}, passed vins: {}\n".format(len(vins), len(passed_vins)))

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
    count_passthrough(args[0])


if __name__ == "__main__":
    main()
