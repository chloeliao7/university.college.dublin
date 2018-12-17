code
SaaS
* software as a service : a complete software solution with a user interface

PaaS
* patform as a service : a platfrom where a deveeloper can deploy their application 
	*  paas includes hardware, operating system and development tools and administrative tools 

IaaS
* infrastructure as a system : provide machine **storage and network** resources where developers can manage by installing their own operating system application and support resource 

different types of cloud: 
* private, public , community and hybrid
	* private : owned by specific organization and only used y that organization and may need to reside on or off side. 
	* public cloud : owned by a large organization or comany offering cloud servivce : available to the public.  least excpensve 
	* community cloud: **TWO MORE ORGANIZATION**: is shared by two organization : has shared concerned 
	*  hibrid: **TWO MORE CLOUD SYSTEM** a cloud that consists or teo or more cloud systems: private public and so on; 

Security Disadvantage: vrcmm : v : vendor : m: multitendencie m: malisious. r : risj of failing 
cmmvr : country: malisious, multitendancy, vendor, risk of failign 
* country or jurisdiction: if cloud resources _reside in multiple states_ (LEGAL ISSUES)
* multitennant risk: an application error might expose ones company to another
* malisious insiders: imployee hackiung 
* vendor lock in :  difficult forco mpany to change provider in event of service level agreement breach/problems 
* risk of the cloud provider failing 

what does “as a service offer” : EXAMPLES : aws, google app engine DMS! : device independance, multitendancy, large scale 
* scalability
* multitendancy : alows resource to be shares
* device independance : difference hardware 

what are **common** forms of **virtualizations** : 
	server virtualiztion: 
	desktop virtualization, 
	virtual network,
 	virtual storage,

1.  server virtualization : making one server apeas as many 
2.  desktop virtualization:  this allows multiple users to switch betweeen multiple operating system 
3. virtual networks: called private VPN where vpc is your network key: and gives you access to your computer 
4. virtual storage: scalable  and redundant storage through the use of avstract and logical disck drives 

Advantages of PaaS:  FLSSL
* lower cost of ownership
* lower administaative overhead needed 
* scalable
* Strengthen **Security**
* Focus Resources, **Stay Up to Date DATA**

Three virtual computer devices: 
1. virtual cpu 
2. vitual memory
3. virtual disk 

two applications that are not well suite for virtualization:
1. applications with high graphics
2. application with high hardware requirement 

The most **common technologies of Virtualisation**: 
PHOF ; paravirtualization, hardware assisted, os level virtualization, full virtualization 
Full virtualisation: The host **emulates a complete installation**, including **hardware layer,** for each guest.
Para-virtualisation: **Host provides a VM **interface for the **guests**  and that the guests access hardware through that host VM
Hardware-assisted virtualisation: **Hardware provides support to run instructions **independently for each OS.
OS-level virtualisation: **Same OS in host and guests. ** Isolation in the user land. VM must all be **running the same OS** 

—————————— 

**Pig Script That **
Logs -  that contains hostname and ip address accessed 
Host Info  - that contains hostname and username 

Write a Pig script that finds the top 5 most IP address accessed by user Anita and stores this information in a file named top5sites.

Use	  = LOAD ‘hostinfo’ AS (hostname and username)  // find the username and username 
filtered = FILTER user BY hostname = ‘anita’; // find the keywords anita from hostinfo 

logs = LOAD ‘logs’ AS (host, ips) // get the infro host and ips 
Joinitems = JOIN filtered  BY hostname, logs by host; // join the hostname and logs 

Groupitems = GROUP joineditems by ips; 

Summed = FOREACH Groupitems GENERATE group, count(Joinitems) AS ipa; 
Sorted = ORDERED Summed by ipa desc 
Store Top5 INTO ’top5sites’ 

—————————— 

**K Means **
Steps To K Means Map Reduce : 
1. . _Given K **partition** into k **non empty** subsets_ 
	*  devide partition into the cluster 
2.  compute seed points as the centroid of cluster of the current partition. 
	*  the centroid is the center mean point 
3. 3. assign each object (centrioid) to the closest seed point 
4. go back to step 2 until no more new assignments 

// pcab = partition, compute, assign and back to step 2.  
1. _partition_ the non empty subset 
2. _compute_ the seed points as centroid 
3. _assign_ each object (centrioid) to the closest seed point 
4. go **back** to _step 2_ until no more new assignments 

Using Map/Reduce model, **define the mapper & reducer** of K-Mean algorithm.

**// node id and centroids : both ID and Cluster : add S**
nodeID:  identification of each objects (place)
nodeIDs: all nodeID (the combination of all of them)

centroidID: identification of each centroid point of each cluster (id)
centroidIDs: all centroidID (iteration of all of them)

**Mapper**:

input: <nodeid, [centroidIDs]> // gather all centroids to each node id
 emit: <centroidID, nodeID>  // needs to be dynamically incremented 

// maps out each nodeid to its pooter centrois id 

**Reducer** 
input<centroidID, nodeID>
Reduce => <centroidID, [nodeID]> // Iterate 
output<centroidID, [nodeID]>// Repeat 


#####################################################################


QUESTION II (20%)
In the context of Cloud Computing;
1. What are the delivery models of cloud computing? Give an example of each model.
		1. IaaS (Infrastructure-as-a-Service)
		2. PaaS (Platform-as-a-Service)
		3. SaaS (Software-as-a-Service)

2. Describe briefly an OpenSaaS and why it is needed? 
	1. open source code for SaaS 
	2.  can start building their websites by self-hosting WordPre
	3. they are important so developers can create an easier way to make content 

3. What are the advantages of Virtualization?
	1. reduce in cost
	2. minimize downtime
	3. greater buisness 
	4. simple data center management

1. What is Amazon SimpleDB?
	1. communicated with Amazon Elastic Compute Cloud (**EC2**) 
	2. _is a **NoSQL Distributed database** written in **erlang**_
	3. part of **Amazon Web Services**


Question III (35%)
1. Explain the difference between storage-area network (SAN) and Cloud-based storage.
	1. **secure, high-speed data transfer network** provides access to consolidated **block-level storage**
	2. cloud based storage can be seen in many forms and is not limited to SA: dynamic and does not need to transfer in blocks 

1. Briefly describe the RAID storage system. Give an example of a RAID system.
	1. redundant array of independent disks: **data mirrored** to **one or more disks**
	2. data that is mirrored, has methods like **stripping (spreading data over multiple disk drives)**
	3. when you create a _**partition on a computer**_ and then copy your drive to it 

1. Explain what is an elastic IP address. Why it is important in cloud computing environment?
	1. elastic IP address is an example of an ip that comunicated your own IP computer to the AWS account 
	2. it is important so that aws has the ability to secure your data but also keep your data in the right structure and order. 

1. Briefly explain the architecture of Google File System (GFS).
	1. GooglesFS are 
		1. files based on independent **chunks** 
		2. where they are combined and communicated to** chunk servers**
		3. which are then communicated to a **master**
		4. which then are **mapped to the application** and the loop goes on 
	
1. Briefly describe Server Virtualisation. 
	1. is the process of multiplying one physical server into multiple isolated virtual environments.

What is virtualisation? :
*  process of creating a virtual version of a physical object.
* a virtual version of real hardware.
*  virtual hardware can be used to run a complete operating system.
* can be multiple instances of an operating system

Define paravirtualisation: 
	1. paravirtualization is a **guest virtual system** that is **independant from the hardware **or other virtual system. 

EXAMPLE: 
difference between Middleware 
—>  -> application, app -> software, app -> database -> EX:** connecting two or more applications together **

Hypervisor in the cloud computing system?
——> hypervisor is a hardware** virtualisation technique** that allows ** multiple guest OS to run on a single system**


The main three components of AWS S3 are: 
Objects, Bucket, and Keys. Define each of these three components and how they are used in S3.

Object: when a life is uploade to amazon S3, it is sorted as a S3 object 
Buckets: a public cloud storage resource 
Key: key are names that are assigned to objects so they can be retried 