# ***This branch configure SpringBoot to deploy on a JEE server without need to add springboot feature to application servers.***

# How to deploy
- Copy the JNDI info from `Liberty/server.xml` into your Liberty runtime `server.xml`
- Build the war and drop it into the `dropins` folder in Liberty

# springbootLiberty
SpringBoot on IBM Liberty with DerbyDB  

## IDE
Get eclipse and install Liberty profile.  Then create a server from the liberty runtime below.  

## Liberty
`server.xml` Disable all config for adminCenter and SSL.  We don't need it for this.

### Runtime
This was tested on `wlp-webProfile8-20.0.0.9` on Java 15.  
https://developer.ibm.com/wasdev/downloads/#asset/runtimes-wlp-webProfile8

## DerbyDB
Get `db-derby-10.15.2.0`, both bin and lib package.  
Then follow the tutorial below to create basic database.  
https://db.apache.org/derby/docs/10.2/workingwithderby/twwdactivity1.html
