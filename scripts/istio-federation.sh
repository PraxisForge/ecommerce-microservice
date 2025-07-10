#!/bin/bash
# Copilot: Create remote secrets for multi-cluster federation
istioctl x create-remote-secret --context=cluster-us --name=cluster-us | kubectl apply --context=cluster-eu -f -
istioctl x create-remote-secret --context=cluster-eu --name=cluster-eu | kubectl apply --context=cluster-us -f -
