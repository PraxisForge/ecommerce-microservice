#!/bin/bash
# Copilot: Port-forward Kiali and Grafana
kubectl -n istio-system port-forward svc/kiali 20001:20001 &
kubectl -n istio-system port-forward svc/grafana 3000:3000 &
