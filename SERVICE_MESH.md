# Service Mesh & Global Scale

## 1. Istio Install
- Run `scripts/install-istio.sh`
- Label default namespace for injection

## 2. Sidecar Validation
- Run `scripts/validate-sidecar.sh`
- Confirm `istio-proxy` in all pods

## 3. Traffic Management
- Apply manifests in `istio/` for Gateway, VirtualService, DestinationRule

## 4. Security
- Apply `istio/peerauth-strict.yaml` and `istio/orders-authzpolicy.yaml`

## 5. Observability
- Run `scripts/port-forward-observability.sh`
- Import `istio/grafana-istio-dashboard.json` in Grafana

## 6. Multi-Cluster
- Run `scripts/istio-federation.sh`
- Apply ServiceEntry and DestinationRule for global services

## 7. Autoscaling & Cost Controls
- Apply `k8s/product-service-hpa.yaml`, `k8s/resourcequota.yaml`, `k8s/limitrange.yaml`

## 8. Global Load Balancer & DNS
- Apply `cloud/aws-gwlb.yaml`
- Create Route53 record for `api.ecommerce.com`

## Verification
- Check `istioctl proxy-status`
- Validate traffic split, mTLS, and access policies
