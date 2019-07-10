# Developer Documentation

So you want to contribute to the project? Having a copy of Consul running locally will be very helpful. Also a local copy of Kong. Don't have either or these running? Use the following instructions to quickly and -- hopefully -- painlessly get the services up and running.

## Setting up Consul to run locally for development

### Ensure KVM, Minikube, and Helm are installed

Follow the [Kubternetes Deployment Playbook](https://wiki.marchex.com/index.php/Kubernetes-Deployment-Playbook) up to the "How to Deploy via Helm Chart" section. 
This should give you a working Kubetenetes environment locally.

### Use the sanctioned HashiCorp Helm Chart to run Consul locally

Follow the instructions at [Running Consul on Kubernetes](https://www.consul.io/docs/platform/k8s/run.html) up to the "Upgrading Consul on Kubernetes" section (you can pretty much ignore the "Joining an Existing Consul Cluster" section).

**_NOTE_**: It could take several minutes or more for all the pods and services to spin up. You can watch the progress with the minikube dashboard. Start the dashboard with the following command:

```$bash
hminikube dashboard
```