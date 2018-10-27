>> lectures: 
man 15:00
wed 15:00

>> practical 
thurs 15:00

>> exams: 30% - 3 MCQs : 30 min each 
final exams: 40% 

>> topics: 
motivation, 
what is cloud computing 
virtualization 
iaaS, PaaS, and SaaS
Data storage in the cloud
hadPop and mapreduce 
case studies: AWS, EC2, S3, etc 
Migration in the cloud 
Cloud Security 
Advanced Topics 

>> Learn new tech
MapReduce, Ajax, NoSql, DTH

complex systems 
needs scalable, efficient, robust

99% your computer is idle 
	 - how to use cloud with idle times
	 
------------------------------------------>
	 
	 # lec 1 big data problems 

	 webs-scale problems 
	 - data intensive 
	 - processing intensive 

		examples 
		- crawling, indexing, searching and mining
		- science data (astronomy, partial and so on)
		- web 2.0 applications 
		- sensor networks 

		MAIN FAME - data stored locally 
		SEARCH ENGINE - searched in Europe 
			
		crawling - crawlers (or bots) which crawl to the deepest of the web pages. Data scrapings
		RPC - remote procedural code 

--------------------

>> Lecture 3 : Shared Memory 
CPU - PE - MU 

CPU: 
PE: Processor
MU: Memory Unit

MIMD: Multiple input, multiple value 
SM: 
SISD: 
SIMD: 
MiMD - PM: P&D Computers 

-----------
CPU - > PE <---> MU
----------------------

(tightly coupled) MIMD P&D Computers (Loosely Coupled)
	'																			'
	'																			'
	'																			'
	'																			'
	'																			'
	'															multicomputers
	'																<bus, switched> 
multiprocessor
- bus: sequent
- switched: ultra computer 

<!-- computer Paradigms: look it up  -->
- PC Computing 
- mainframe computing 

>> Issues with parallel computing 
Heterogeneity, 
latency, 
remote vs local communication 
failures 
security 

# Cloud computing = DEFINITION : 
<!-- - cloud computing is a model for enabling ubiquitous, convenient on demand 
network access to a shared pool of configurable computing resources that can 
be rapidly provisioned and released with minimum management 
efforts or service provider interactions. -->

# CC Characteristics: 

on demand self service
- automatically access
broad network access
- access to the internet 
elastic resource pooling 
- one place to serve multiple users 
rapid elasticity 
- rapid info provided to users 
measured service 
- with proper statistics 

<!-- examples of computing resourced include networks 
server storage and applications and services -->

why virtualized resources 
- cost reduction 
- isolation 
- testing/evaluation of os kernel and app 
- easy duplication 
- running application not supported by the host 
- green IT 

-------------------

Delivery Methods and Models
Saas :	 (goes straight to ): Software as a service 
PaaS :	 platform as a service 
IaaS :	 Infrastructure as a service 
Cloud 	Physical Infrastructure 

Types: 
Pirate 
community 
hybrid 

Storage: 
Cloud Storage : most common 
Storage as a Service : database, becoming prevalent 
Examples : amazon Simple DB, RDS, Redshift , Microsoft SQL (SSDS) 

Challenges 
- Security, Reliability, Outage, Theft

Reg Key, COMP41110-2018-CC
30520 

>> lecture 5 

Data Center : REQ 
- access to high speed
- cooling system to eliminate the heat 
- administrative staff : HARDWARE, SOFTWARE 
- Uninterrupted systems

SINGLE POINT OF FAILURE WHAT DO YOU DO : 
- fire, flood , weather , act of terrorism, ext 
- data center

IaaS 
- Infrastructure as services 
- offers the computing hardware resource 
- allows you to put any type of os on *
- allows to rent resources and management capabilities 
- avoids purchasing and administrating servers 

rent such as: 
- cpu, 
- storage space
- servers 
- network equipment etc 

Hosting IT InfrastructureL for multiple customers
- share power cooling system support staff 
- least expensive ways 

# Server Types: 
Physical Server 
- hardware allocated 
- based on services and companies 
- Dedicated virtual server 
- virtual runs physical server and acts like one 
- but is virtual 
share virtual server 

Load balancing: 
- huge network traffic requirement 
- virtual servers can be interchangeable dependent on load 
- between users an servers 
- distribute web request

# Infrastructure as a service ! 

Redundancies: 
IaaS Providers allows you to 
- add servers, processors and ram 
- scale and resource allocations 
Redundancies 
- duplicates offsite server , storage devices 
- can failover from one location to another 
- load balancing 
- redundant resources 

Advantages and disadvantages: 
- Eliminates expensive private Infrastructure
- ease of hardware scalability 
- better resources 
- on demand 
- supports green 

disadvantages
- security issues 
- interpolation 
- performance 

-------------------------------------->
>> Lecture 4
Virtualization

- the illustion of creating or having two or more entities where sphere is only one physical entity in the system 

interests: 
- making one sever appear to be many 
- making one server appear to be many 
- desktop appears to be running multiple of simultaneous 

# Virtualization history 
- IBM developed virtual os > 30 years ago 

# Without virtualization 
# ISA (instruction setter architecture): Architecture of a processor 
- Software compiled for one ISA (instruction setter architecture) will not run on hardware with a different ISA
- Even if ISAs are the same, OS may differ 

# Abstractions

comp systems are built on levels of abstractions 
higher level of abstraction hoof details at lower level 

# Isomorphism from guest to host 
Isomorphism as applied to web means rendering 
- maps guest state to host state 
- similar to abstraction

# Virtualization tech 
- VMM virtual machine management 
	- VMWare, MS Virtual Server
	- Construct Virtual Disks
	- n Implement R/W/F/D functions

# Paravirtualisation - modify the OS Kernel 
to replace non virtualisable instruction 
with hyper-calls that communicate 
directly with the vitalization 
layer, Hypervisor

# Hardware assisted virtualization 
- tech that allows for a cpu instruction se communication between the VMM and .....

# Virtualization Categories 
tech
	- os level virtualization 
	- hardware assisted virtualization 
	- paravirtualization ()
	- full virtualization ()
Device 
	- virtual cpu 
	- virtual memory 
	- virtual disk 

Form 
	- server virtualization
	- desktop virtualization 
	- network virtualization 

# Hypervisor
- manages VMMs 
- creates simulated computer environments for guest software 
- (google picks weather you can have a mac, linux or windows based virtual system)

# Full virtualization 
- the host emulates a complete installation, 
 > including hardware layer, 
 > for each guest

 # Paravirtualisation
 - modifying the Ketnet to replace non virtualisable instructions with hyper-calls ( system call )	
 - hyper-calls communicates directly with the vitalization layer hypervisor 

# Hardware-Assisted Virtualization 
- Tech that allows a CPU instruction to run on root level mode below the os

# forms of virtualization 
- server virtualization 
- desktop virtualization
- virtual networks 
- virtual storage = nfs 

--------------------------------->

# Keep the Hierarchy 
- Saas, PaaS, IaaS, Cloud physical Infrastructure 

# PAAS MODEL
- platform as a service: provides a collection of hardware and software 
- Avoids the complexity of buying and maintaining different tools for developing an application

# PAAS SERVICE
- change the way the software is developed and deployed 
- users can use language runtimes, application framework, db, message queue, testing tools and deployment tools as service 
- programing languages: JAVA, Perl, PHD, Python, Ruby, Scala
- Application framework: Node , Rails, Drupal, Wordpress, spring
- Database ClearDB, PostgreSQL, Cloud-ant, MongoDB, Redis,
- Testing Tools: Provided by the software provider 

# History: mainframe 1960, pc evolution: 1985, LAN: 1990, WEB:1995, PaaS:2008

# Abstraction of IaaS: Layered system: infrastructure layer provides users with direct to the underlying infrastructure

Isolation: 
- isolate users from the resource interaction to the lower level of resource interaction
- allow devs to create new software that is not susceptible to the number of provisioned machines or their network configurations

Add-ons to SaaS : examples: AMAZON AWS and so on : Middle ware based system 
- Microsoft Common Language runtime CLR 
- Customer Pays SaaS provider for the service : 
+ SaaS Provider pays the cloud for the infrastructure 
++ cloud provider ++ SaaS ++ Client

PaaS Advantages
- Lower total of ownership cost 
- Lower administration overhead
- more current system software 
- increased business and IT Alignment 
- Scalable Solutions 

PaaS Advantages for devs
- ease of use
- low cost 
- infrastructure 
- risk Lower
- reusable

PaaS Disadvantages : Security, portability, trust 

# GAE Features: 
Google App Engine: GOA: lets developers to create and host web based applications that reside and run on services managed by google
1. supports java, python, go 
2. support dynamic web pages
3. data storage and query support 
4. api and SDKs 
6. Load balancing for application scalability 
7. administrative console for managing applications and database 

-------------------------------------------------->

SaaS 
- users not interested in handling software 
- need for high powered applications

saas is not:
- a software + service 
- offline application 
- it is customizable 
- doesn't not require install any application on local machine 

Privacy concerns 
- SaaS Does not guarantee privacy 
- GDPR

Multi tenant of SaS Solutions 
- two or more clients may share the same server 
share: depending on size, fees and etc
Multi tenant: complex and expensive 

Different perspectives: 
- Providers: offering software services to users on a
subscription-based model
- Consumers: use and pay as you need.

Objectives of SaaS: software tools that you don''t have on your laptop 
- Ubiquitous Software
- Management
- Multi-user Platform

>> Service-oriented Architecture (SOA)
- Integrating one or more web services
- A set of web services: API
- SaaS application interacts with a user – a web service interacts with a program.

Mashup
- Model: collection of services joined to create overall solution 

web based: users browser combines the various content sources 

server-based: an application running on a server combines the data 

>> Open SaaS 
- SaaS Solutions: run on specific OS, DBMS, Language
- Use a open source programing language 
- run on a open source os and dbms 
- move data to different applicaitons

# SaaS – Examples
- mail, document management, social network, business service: erp crm, sales and more

# SaaS Characteristics
- one to many, web access, centralized management, multi device support 
- better scalability, hight availability, api integration 

# SaaS – Suitability
- on demand software, 
- software for startup combines
- software compatible with multiple devices 
- software with varying hand 

# SaaS – Not suitable 
- real time applications - stock trading and more 
- application with confidential data 
- better on-premise applicaitons

# SaaS Advantages
- maintenance, pay as you use, multi tenancy, reliability and disaster recovery 
- ease of access

# SaaS Disadvantages
- Security: Data is stored on Cloud
- Internet connection: No connection, no application: Latency: Data is far away from the end users: Not suitable for real time applications
- Flexibility: Not easy to switch between SaaS vendors
- Compliance Regulation relating to data storage (national/international level)
- Loss of control: The user does have any control over the data

ANSWER : What is the difference between cloud computing and saas 

-----------------

>> lectures new 
ec2 services 
- instances, instance types
- preconfigured templates (amazon machine image);
- key pairs 
- instance store volume 
- elastics block store (ebs) volume 
- availability zones (where its located )
- firewall 
- elastics ip address 
- virtual private cloud (VPC) 

ec2 connect is a console 

--------------------

# Summarize FOR MCQ ~1 

IAAS: 

Virtualization - creating or having two or more entities where there there is only one physical entity in the system 
VPN - virtual private network

 NAS devices - aws, bluelock, csc, gogrid, ibm

 IaaS providers allow to: 
 - Add servers, processors, RAM, etc.
 - Scale resource allocation

 Colocation
 - duplicate off site servers 
 - fail over from one location to another 
 - move it between different servers dependent of business 

IAAS: 
- CPU cycles
- Storage space
- Servers
- Network equipment, etc

Server types in IAAS 
- Physical 
- dedicated
- shared 

Load Balancing: 
- many requested to load-balancing servers to multiple servers 

-------->

SaaS

past: 19xx, 20xx, 
- Providers offering software services to
- users on a use and pay as you need.

!!! UBIQUITOUS - Make software services available globally

-------> 

SAAS IS NOT AN Offline APPLICATION -- all online 

SAAS IS NOT SOFTWARE SERVICE -- not just software and service 
Customizable like instances 

NO NEED TO INSTALL SOFTWARE 

PRIVACY CONCERNS = SINCE ONLINE

-------> 

ONE TO MANY, SHARED DATABASE RESOURCE, MULTI TENANT SOLUTIONS MAY BE expensive

---------> 

SOA = SERVICE ORIENTED ARCHITECTURE
- A set of web services: API
- Integrating one or more web services
- Application development methodology
- SaaS interacts with a user and web service interacts with a program 

WHAT IS MASHUP 
- MODEL = collection of services 
- WEB based = users browser combines the various content sources to create unified display 
- SERVER based = application on a server combines data 

SaaS vs Open SaaS = specific language vs open source, run on open os and dbms vs not

SaaS Characteristics : 
- one to many, web access, centralized management, multi-device support 
- better scalability, high availability, api integration 

Suitable: on demand software, software startup companies, multiple device software, software with varying loads
Not-Suitable: Real Time Applications: SaaS append on internet connections, confined data applications: security, better on premise applications 

SaaS advantages: maintenance, pay as you use, scalability, multitennancy, reliability, easy of access
SaaS disadvantages: security, internet connection, flexibility, compliance , loss of control

virtualization: 

Virtual Machine Monitor (VMM): lets you choose which operating
 
---------> 

Instruction set architecture - ISA
- the way a computer sets up in assembly and executes commands 

NETWORKED ATTACHED STORAGE NAS
SERVICE ORIENTED ARCHITECTURE SOA
VIRTUAL PRIVATE NETWORK VP NS

virtualization technology : 
- OS Level virtualization 
- hardware assisted virtualization 
- paravirtualization 
- full virtualization

virtualization Device : 
- virtual cpu 
- virtual memory
- virtual disk 

Types - Form : 
- Server virtualization 
- Desktop virtualization 
- network virtualization 

Paravirtualisation 

IMPORTANT: --------------------> 
HYPERVISOR: Manages VMMS, creates simulated computer environments for guest 
PARAVIRTUALISATION: going through current and working in parallel with the os 
FULLVIRTUALISATION: guest os and reg os work in separate manner : uses VMM 
HARDWARE ASSISTED VIRTUALIZATION: cpu instructions com where vmm runs in new root below kernel 
EX: VT and AMD 

-------------------------------------------->

AMAZON EC2 : Services 
- instances
- preconfigured templates
- key pairs 
- instance store volumes 
- elastic block store
- availability zones 
- firewall
- elastic IP address 
- Virtual private cloud 

...............................................

>> next lecture 

network attached system 

RAID - Redundant Array of inexpensive Disks 
- access reading and writing information from a set of disks at THE SAME TIME 
- reliability ad parity and mirroring information on multiple disks
- performance: importoovinf performance and reliability of the storage device 
- configuration raid - , raid1, raid2 etc : different ways of identifying data

RPC remote procedure call - 
NFS Network File System - 
Scalable distributed file system = multiple clusters currently there 
- no madder how many nodes you don''t loose time and scalability 

>> mapreduce: google created with c++ 

its now used with yahoo, google and many more platforms 

Parallel computing = want to do things faster 
Distributed Computing = 

Parallel
Characteristics : Overall Goal =
Characteristics : Interactions =
Characteristics : Granularity =
Characteristics : reliable =

Distributed Systems
Characteristics : Overall Goal =
Characteristics : Interactions =
Characteristics : Granularity =
Characteristics : reliable =

MAP reduction - Problem - partition

MTBF - mean time between failures
- NODES FAIL 

K Means 
- partition objects into k non empty subset 
- depending on how close these seed points are towards to each other 
- compute seed points, calculate till its in the center 
- assign object 
- keep doing it till no more.... do step two {no new assignment}

<nodeID,[nodeID]> = keyValue pair 
- map and reduce MAIN 
- NEW COMBINATION! 

examples of mapreduce
- GREP 
- Count of url accesses 
- reverse weblink graph 
- inverted index 

MAP REDUCE!!! LOOK IT UP !