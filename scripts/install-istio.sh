#!/bin/bash
# Copilot: Download and install Istio 1.18.2, label default namespace for injection

curl -L https://istio.io/downloadIstio | ISTIO_VERSION=1.18.2 sh -
cd istio-1.18.2
export PATH=$PWD/bin:$PATH
istioctl install --set profile=demo -y
kubectl label namespace default istio-injection=enabled --overwrite
