#!/bin/bash
# Copilot: Deploy Bookinfo sample and check for istio-proxy in pods
kubectl apply -f istio-1.18.2/samples/bookinfo/platform/kube/bookinfo.yaml
kubectl get pods -n default -o json | jq '.items[].spec.containers[].name' | grep istio-proxy
