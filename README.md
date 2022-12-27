# auzj6fml
<div align=left> 
  <img src="https://img.shields.io/badge/oracle-F80000?style=flat-square&logo=oracle&logoColor=white">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=flat-square&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/sonarlint-CB2029?style=flat-square&logo=sonarlint&logoColor=white">
  <img src="https://img.shields.io/badge/jenkins-D24939?style=flat-square&logo=jenkins&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=flat-square&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/docker-2496ED?style=flat-square&logo=docker&logoColor=white">
  <img src="https://img.shields.io/badge/nginx-009639?style=flat-square&logo=nginx&logoColor=white"> 
  <img src="https://img.shields.io/badge/RHEL-EE0000?style=flat-square&logo=red hat&logoColor=white">
  <img src="https://img.shields.io/badge/cloudflare-F38020?style=flat-square&logo=cloudflare&logoColor=white">
  <br>
  <br>
</div>

UI backend templates consisting of springboot, mybatis, lombok.<br>

* * *

### Configuration nginx

Create dhparam.pem for secure score.
```sh
sudo openssl dhparam -out /data/nginx-proxy-manager/openssl/dhparam.pem 4096
```

Configuration to place cloudflare in front.<br>
`nginx.conf example`
```text
ssl_prefer_server_ciphers off;
real_ip_header CF-Connecting-IP;
```

Configure with tls 1.2 for final score. 1.3 is good for security, but lowers the compatibility score. However, use 1.2, except for configurations with security problems.<br>
`ssl.conf example`
```text
ssl_dhparam /etc/ssl/dhparam.pem;

ssl_session_timeout 1d;
ssl_session_cache shared:MozSSL:10m;
ssl_session_tickets off;

ssl_protocols TLSv1.2 TLSv1.3;
ssl_ciphers ECDHE-ECDSA-AES256-GCM-SHA384:ECDHE-RSA-AES256-GCM-SHA384:ECDHE-ECDSA-CHACHA20-POLY1305:ECDHE-RSA-CHACHA20-POLY1305:ECDHE-ARIA256-GCM-SHA384:DHE-RSA-AES256-GCM-SHA384;
ssl_ecdh_curve X448:secp521r1:secp384r1;

ssl_stapling on;
ssl_stapling_verify on;
ssl_trusted_certificate /data/custom_ssl/npm-1/ca.pem;
resolver_timeout 30s;

add_header X-Frame-Options “SAMEORIGIN”;
add_header X-Content-Type-Options nosniff;
add_header X-XSS-Protection "1; mode=block";
add_header Content-Security-Policy "upgrade-insecure-requests" always;
```
> Note: There is an ssl-ciphers.conf misconfiguration bug when creating a custom ssl proxy host. Configure with ssl.conf until resolved.

Same as set above.<br>
`ssl-ciphers.conf example`
```text
#ssl_session_timeout 5m;
#ssl_session_cache shared:SSL:50m;

# intermediate configuration. tweak to your needs.
#ssl_protocols TLSv1.2 TLSv1.3;
#ssl_ciphers 'ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-RSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES256-GCM-SHA384:ECDHE-RSA-AES256-GCM-SHA384:ECDHE-ECDSA-CHACHA20-POLY1305:ECDHE-RSA-CHACHA20-POLY1305:DHE-RSA-AES128-GCM-SHA256:DHE-RSA-AES256-GCM-SHA384';
#ssl_prefer_server_ciphers off;
```
Openssl settings are treated the same.<br>
`openssl.cnf exmaple`
```env
[system_default_sect]
MinProtocol = TLSv1.2
#CipherString = DEFAULT@SECLEVEL=2
Ciphersuites = TLS_AES_256_GCM_SHA384:TLS_CHACHA20_POLY1305_SHA256
CipherString = ECDHE-RSA-AES256-GCM-SHA384:ECDHE-RSA-CHACHA20-POLY1305:ECDHE-ARIA256-GCM-SHA384
```

Finally, check nginx settings.<br>
[Test in ssllabs](https://www.ssllabs.com/ssltest/analyze.html?d=au.gvp6nx1a.ml&hideResults=on&latest)<br>
[Test in ssllabs (Mirror site)](https://www.ssllabs.com/ssltest/analyze.html?d=au.ec4mrjp5.ml&hideResults=on&latest)<br>

> Note: In the case of SSL via cloudflare, it is difficult to get a good score because it includes CBC encryption. nginx direct SSL with the configuration set above can get top marks, but it's at a disadvantage in security except for SSL.<br><br>
> SSL via nginx<br>
> ![auzj6fml_1](https://user-images.githubusercontent.com/116544940/209469327-f9ba4bbf-75a6-4a1e-a97d-a5f33b956790.png)
> SSL via cloudflare<br>
> ![auzj6fml_2](https://user-images.githubusercontent.com/116544940/209469323-f818c982-2d11-4151-8bc3-5ae9598bb86e.png)

* * *

### Configuration 

It can be used as docker build, but since it is a development environment, it is simply put in an openjdk container for speed.<br>
`docker-compose.yml example`
```yml
version: "3.8"
services:
  auzj6fml:
    image: openjdk:17-jdk
    container_name: auzj6fml
    user: 1000:1000
    networks:
      gvp6nx1a:
        ipv4_address: 172.18.0.102
    expose:
      - 80/tcp
    environment:
      - TZ=Asia/Seoul
      - JAVA_OPTS=-Xmx1g
    volumes:
      - /data/auzj6fml/dockerfile/build/libs:/usr/share/java:rw
      - /data/auzj6fml/config:/config:rw
      - /data/auzj6fml/data:/data:rw
      - /data/auzj6fml/log:/log:rw
    command: java -jar /usr/share/java/auzj6fml-0.0.1-SNAPSHOT.jar
    restart: always
networks:
  gvp6nx1a:
    external: true
```
> Note: Configure to store oracle wallet and private key for ssh tunneling in config directory. And keep the in and out files in the data directory.

Shell script for Jenkins pre build. Runs in a jenkins docker container.
```sh
#!/bin/bash
log_file=/tmp/pre_build.log
{
  echo "$0"
  echo "$1 #$2"
  mkdir -p var/jenkins_home/workspace/auzj6fml/src/main/resources
  mkdir -p var/jenkins_home/workspace/bdkqpr0x/src/main/resources
  cp -f -v /var/jenkins_home/config/profiles/auzj6fml/application-security.properties /var/jenkins_home/workspace/auzj6fml/src/main/resources
  cp -f -v /var/jenkins_home/config/profiles/bdkqpr0x/application-security.properties /var/jenkins_home/workspace/bdkqpr0x/src/main/resources
} > $log_file
log=$(< $log_file tail -c 4096)
if [ -z "$log" ]; then
  exit 1
fi
/usr/bin/curl --data-urlencode text="$log" https://api.telegram.org/bot**********************************************/sendMessage?chat_id=**********
```

Shell script for Jenkins post build. Runs in the target host to be deployed.
```sh
#!/bin/bash
log_file=/tmp/post_build.log
{
  hostname -f
  echo "$0"
  echo "$1 #$2"
  ls -alh /data/auzj6fml/dockerfile/build/libs/*.jar
  cd /data/auzj6fml || exit 1
  sudo docker-compose rm -f -s
  sudo docker-compose up -d
} > $log_file
log=$(< $log_file tail -c 4096)
if [ -z "$log" ]; then
  exit 1
fi
/usr/bin/curl --data-urlencode text="$log" https://api.telegram.org/bot**********************************************/sendMessage?chat_id=**********
```

* * *

### How to use
It runs in a docker container and deploys to jenkins. Same as batch program.
```sh
sudo cd /data/auzj6fml && sudo docker-compose rm -f -s && sudo docker-compose up -d && sudo docker exec -it auzj6fml date
```

* * *

### Contact and license

<a href="mailto:xqbty8po-dntco43u@yahoo.com" target="_blank"><img src="https://img.shields.io/badge/yahoo!-6001D2?style=flat-square&logo=yahoo!&logoColor=white"/></a>
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
